package jd.cheng.leetcode27;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.StringJoiner;

import org.junit.Test;

public class Solution {

	public int removeElement(int[] nums, int val) {
		if(null == nums || 0 == nums.length) {
			return 0;
		}
		
		int i = 0;
	    for (int j = 0; j < nums.length; j++) {
	        if (nums[j] != val) {
	            nums[i] = nums[j];
	            i++;
	        }
	    }
	    return i;
    }
	
	@Test
	public void test() {
		// assign
		int[] arr = new int[] {0,1,2,2,3,0,4,2};
		int val = 2;
		
		// act
		int len = new Solution().removeElement(arr, val);
		
		// assert
		assertEquals(5, len);
		
		StringJoiner sj = new StringJoiner(",");
		for(int i=0; i<len; i++) {
			assertNotEquals(val, arr[i]);
			sj.add(String.valueOf(arr[i]));
		}
		
		System.out.println(sj.toString());
	}
}
