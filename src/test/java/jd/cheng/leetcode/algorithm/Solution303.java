package jd.cheng.leetcode.algorithm;

public class Solution303 {

	/**
	 * sum[i] = nums[0] + nums[1] + ... nums[i-1]
	 */
	private final int sum[];
	public Solution303(int[] nums) {
		sum = new int[nums.length + 1];
		sum[0] = 0;
		sum(1, nums);
    }
	
	private void sum(int index, int[] nums) {
		if(index == sum.length) {
			return;
		} else {
			sum[index] = sum[index-1] + nums[index-1];
			sum(index+1, nums);
		}
	}
    
    public int sumRange(int i, int j) {
        return sum[j+1] - sum[i];
    }
    
    public static void main(String[] args) {
		Solution303 array = new Solution303(new int[] {-2,0,3,-5,2,-1});
		System.out.println(array);
	}
}
