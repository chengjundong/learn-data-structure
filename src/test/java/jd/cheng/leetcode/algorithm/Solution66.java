package jd.cheng.leetcode.algorithm;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;

/**
 * 
 * @author jucheng
 * @see https://leetcode-cn.com/problems/plus-one/
 *
 */
public class Solution66 {

	 public int[] plusOne(int[] digits) {
		 return _plusOne(digits, digits.length-1);
	 }
	 
	 public int[] _plusOne(int[] digits, int index) {
		 if(index  == -1) {
			 int[] result = new int[digits.length + 1];
			 result[0] = 1;
			 return result;
		 }
		 
		 if(digits[index] == 9) {
			 digits[index] = 0;
			 return _plusOne(digits, --index);
		 } else {
			 digits[index] += 1;
			 return digits;
		 }
	 }
	 
	 @Test
	 public void test() {
		 assertThat(this.plusOne(new int[] {1,2,3}))
		 	.contains(1,2,4);
		 assertThat(this.plusOne(new int[] {4,3,2,1}))
		 	.contains(4,3,2,2);
		 assertThat(this.plusOne(new int[] {9,9,9}))
		 	.contains(1,0,0,0);
		 assertThat(this.plusOne(new int[] {1,8,9,8}))
		 	.contains(1,8,9,9);
	 }
}
