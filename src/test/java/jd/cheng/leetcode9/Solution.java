package jd.cheng.leetcode9;

public class Solution {

	public boolean isPalindrome(int x) {
        if(x < 0) {
			return false;
		} else if(x < 10) {
			return true;
		}
		
		char[] chars = String.valueOf(x).toCharArray();
		
		for(int i=0, j=chars.length-1; i<=j; i++, j--) {
			if(chars[i] != chars[j]) {
				return false;
			}
		}
				
		return true;
    }
	
	public static void main(String[] args) {
		System.out.println(new Solution().isPalindrome(121));
	}
}
