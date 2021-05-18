package jd.cheng.leetcode.algorithm;

import java.util.HashMap;

public class Solution1 {

	public int[] twoSum(int[] nums, int target) {
		
		if(nums == null || nums.length < 2) {
			return null;
		} else if(nums.length == 2) {
			return new int[] {0,1};
		}
		
		HashMap<Integer,Integer> map = new HashMap<>(nums.length);
		for(int i=nums.length-1; i>=0; i--) {
			map.put(nums[i], i);
		}
		
		int[] result = new int[2];
		for(int i=nums.length-1; i>=0; i--) {
			int dect = target - nums[i];
			if(map.containsKey(dect) && i != map.get(dect)) {
				if(i > map.get(dect)) {					
					result[1] = i;
					result[0] = map.get(dect);
				} else {
					result[0] = i;
					result[1] = map.get(dect);
				}
				break;
			}
		}
		
		return result;
    }
	
	public static void main(String[] args) {
		int[] result = new Solution1().twoSum(new int[] {2, 7, 11, 15}, 9);
		System.out.println(result[0] + "," + result[1]);
	}
}
