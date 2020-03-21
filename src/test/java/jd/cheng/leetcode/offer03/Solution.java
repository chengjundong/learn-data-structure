package jd.cheng.leetcode.offer03;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Solution {

	public int findRepeatNumber(int[] nums) {
		
		int [] arr = new int[nums.length];
		
		for(int n : nums) {
			if(arr[n] == 1) {
				return n;
			} else {
				arr[n] = 1;
			}
		}
		
		return -1;
    }
	
	@Test
	public void test() throws Exception {
		assertEquals(2, findRepeatNumber(new int[] {2,3,1,0,2,5,3}));
	}
}
