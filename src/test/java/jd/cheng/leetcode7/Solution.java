package jd.cheng.leetcode7;

public class Solution {
	
	public int reverse(int x) {
		if(x == 0) {
			return x;
		}
		
		boolean isNegative = x < 0;
		
		char[] chars = String.valueOf(Math.abs(x)).toCharArray();
		
		int[] data = new int[chars.length];
		
		for(int i=chars.length-1; i >= 0; i--) {
			data[chars.length-1-i] = (int)chars[i] - (int)'0';
		}
		
		long result = 0;
		for(int i=data.length-1; i >= 0; i--) {
			result += data[i] * Math.pow(10, data.length-1-i);
		}
		
		result = isNegative ? -1 * result : result;
		
		return result >= Integer.MIN_VALUE && result <= Integer.MAX_VALUE ? (int)result : 0;
    }
	
	public static void main(String[] args) {
		// -2147483412
		System.out.println(new Solution().reverse(-2147483412));
	}
}
