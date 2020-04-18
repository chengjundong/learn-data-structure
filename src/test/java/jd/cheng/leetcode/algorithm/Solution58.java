package jd.cheng.leetcode.algorithm;

import static org.assertj.core.api.Assertions.*;

import java.util.LinkedList;

import org.junit.Test;

/**
 * 
 * @author jucheng
 * @see https://leetcode-cn.com/problems/length-of-last-word/
 *
 */
public class Solution58 {

	public int lengthOfLastWord(String s) {
		if(null == s || "".equals(s.trim())) {
			return 0;
		}
		
		LinkedList<Character> list = new LinkedList<>();
		
		for(int i=s.length()-1; i>=0; i--) {
			char c = s.charAt(i);
			if(' ' == c) {
				if(list.isEmpty()) {
					continue;
				} else {
					break;
				}
			} else {
				list.push(c);
			}
		}
		
		return list.size();
    }
	
	@Test
	public void test() {
		assertThat(new Solution58())
			.extracting(s -> s.lengthOfLastWord("    "),
					s -> s.lengthOfLastWord("    "),
					s -> s.lengthOfLastWord("Hello World"),
					s -> s.lengthOfLastWord("Hello JAVA      "))
			.containsExactly(0, 0, 5, 4);
	}
}
