package jd.cheng.leetcode.algorithm;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;

/**
 * @author jucheng
 * @see <a href="https://leetcode-cn.com/problems/repeated-substring-pattern/">link</a>
 */
public class Solution459 {

  public boolean repeatedSubstringPattern(String s) {
    String str = s + s;
    return str.substring(1, str.length()-1).contains(s);
  }

  @Test
  public void test() throws Exception {
    assertThat(this.repeatedSubstringPattern("abab")).isTrue();
    assertThat(this.repeatedSubstringPattern("abcabc")).isTrue();
    assertThat(this.repeatedSubstringPattern("abcabcabc")).isTrue();
    assertThat(this.repeatedSubstringPattern("abcabcabcabc")).isTrue();
    assertThat(this.repeatedSubstringPattern("aaa")).isTrue();
    assertThat(this.repeatedSubstringPattern("aba")).isFalse();
    assertThat(this.repeatedSubstringPattern("a")).isFalse();
    assertThat(this.repeatedSubstringPattern("ababababbaabab")).isFalse();
    assertThat(this.repeatedSubstringPattern("abaababaab")).isTrue();
  }
}
