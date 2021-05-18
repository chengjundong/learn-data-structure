package jd.cheng.leetcode.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Solution350 {

	public int[] intersect(int[] nums1, int[] nums2) {
		
		if(null == nums1 || null == nums2) {
			return new int[0];
		}
		
		if(0 == nums1.length || 0 == nums2.length) {
			return new int[0];
		}
		
		Map<Integer, Integer> map1 = new HashMap<>(nums1.length);
		for(int n1 : nums1) {
			Integer count = map1.get(n1);
			if(null == count) {
				map1.put(n1, 1);
			} else {
				map1.put(n1, ++count);
			}
		}
		
		Map<Integer, Integer> map2 = new HashMap<>(nums2.length);
		for(int n2 : nums2) {
			Integer count = map2.get(n2);
			if(null == count) {
				map2.put(n2, 1);
			} else {
				map2.put(n2, ++count);
			}
		}
		
		List<Integer> resultList = new ArrayList<>();
		for(Entry<Integer, Integer> e1 : map1.entrySet()) {
			if(map2.containsKey(e1.getKey())) {
				int count1 = e1.getValue();
				int count2 = map2.get(e1.getKey());
				int count = count1 > count2 ? count2 : count1; 
				for(int i=0; i<count; i++) {
					resultList.add(e1.getKey());
				}
			}
		}
		
		int[] result = new int[resultList.size()];
		for(int i =0; i<resultList.size(); i++) {
			result[i] = resultList.get(i);
		}
		
		return result;
    }
	
	public static void main(String[] args) {
		int[] n1 = new int[] {2,2};
		int[] n2 = new int[] {1,2,2,1};
		
		int[] result = new Solution350().intersect(n1, n2);
		if(result != null) {			
			for (int i : result) {
				System.out.print(i+",");
			}
		}
	}
}
