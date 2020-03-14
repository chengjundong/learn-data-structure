package jd.cheng.leetcode14;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Solution {

	public String longestCommonPrefix(String[] strs) {
		if(null == strs || 0 == strs.length) {
			return "";
		} else if(1 == strs.length) {
			return strs[0];
		}
		
		char[] prefix = strs[0].toCharArray();
		
		for(int i=1; i<strs.length; i++)  {
			
			char[] chars = strs[i].toCharArray();
			StringBuffer newPrefix = new StringBuffer();
			
			int limit  = Math.min(prefix.length, chars.length);
			for(int j = 0; j < limit; j++) {
				if(chars[j] == prefix[j]) {
					newPrefix.append(chars[j]);
				} else {
					break;
				}
			}
			
			if(newPrefix.length() == 0) {
				return "";
			} else {
				prefix = newPrefix.toString().toCharArray();
			}
		}
		
		return new String(prefix);
    }
	
	@Test
	public void test() {
		Solution s = new Solution();
		
		assertEquals("", s.longestCommonPrefix(new String [] {"dog","racecar","car"}));
		assertEquals("fl", s.longestCommonPrefix(new String [] {"flower","flow","flight"}));
		assertEquals("pan", s.longestCommonPrefix(new String [] {"pan","panda"}));
	}
}
