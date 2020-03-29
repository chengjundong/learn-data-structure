package jd.cheng.leetcode.interview;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.Test;

/**
 * 
 * @author jucheng
 * @see https://leetcode-cn.com/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof/
 *
 */
public class Solution58 {
	
	public String reverseLeftWords(String s, int n) {
		
		if(null == s || "".equals(s)) {
			return s;
		}
		
		// the real step is k
		int k = n % s.length();
		if(k == 0) {
			return s;
		}
		
		char[] input = s.toCharArray();
		
		return new StringBuffer()
				.append(new String(Arrays.copyOfRange(input, k, s.length())))
				.append(new String(Arrays.copyOfRange(input, 0, k)))
				.toString();
    }
	
	@Test
	public void test() {
		assertThat(new Solution58()).extracting(
				s -> s.reverseLeftWords("abcdefg", 2),
				s -> s.reverseLeftWords("lrloseumgh", 6))
			.containsExactly("cdefgab", "umghlrlose");
	}
}
