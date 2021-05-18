package jd.cheng.leetcode.algorithm;

public class Solution387 {

	public int firstUniqChar(String s) {
		if(s == null || s.trim().equals("")) {
			return -1;
		}
		
		int[] freq = new int[26];
		
		char[] chars = s.toCharArray();
		
		for(int i=0; i< chars.length; i++) {
			freq[chars[i] - 'a']++;
		}
		
		for(int i=0; i< chars.length; i++) {
			if(1 == freq[chars[i] - 'a']) {
				return i;
			}
		}
		
		return -1;
    }
	
	public static void main(String[] args) {
		System.out.println(new Solution387().firstUniqChar("loveleetcode"));
	}
}
