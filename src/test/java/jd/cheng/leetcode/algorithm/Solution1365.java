package jd.cheng.leetcode.algorithm;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;

public class Solution1365 {

	public int[] smallerNumbersThanCurrent(int[] nums) {
		
		int [] result = new int[nums.length];
		
		int [] data = new int[101];
		
		for(int n : nums) {
			data[n] += 1;
		}
		
		for(int i=0; i<nums.length; i++) {
			int v = nums[i];
			for(int j=0; j<v; j++) {
				result[i] += data[j];
			}
		}
		
		return result;
    }
	
	@Test
	public void test() {
		assertThat(smallerNumbersThanCurrent(new int[] {8,1,2,2,3})).containsExactly(4,0,1,1,3);
	}
}
