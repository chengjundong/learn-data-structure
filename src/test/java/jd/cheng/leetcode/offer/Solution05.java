package jd.cheng.leetcode.offer;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Solution05 {

	public String replaceSpace(String s) {
		
		char[] chars = s.toCharArray();
		
		StringBuffer sb = new StringBuffer();
		for (char c : chars) {
			if(c == ' ') {
				sb.append("%20");
			} else {
				sb.append(c);
			}
		}
		
		return sb.toString();
    }
	
	@Test
	public void test() {
		assertEquals("We%20are%20happy.", this.replaceSpace("We are happy."));
	}
}
