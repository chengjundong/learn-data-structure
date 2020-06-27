package jd.cheng.leetcode.algorithm;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;

/**
 * @author jucheng
 * @see <a href="https://leetcode-cn.com/problems/reverse-string/">link</a>
 */
public class Solution344 {

  public void reverseString(char[] s) {
    for(int i=0,j=s.length-1; i < j; i++, j--) {
      char c = s[i];
      s[i] = s[j];
      s[j] = c;
    }
  }

  @Test
  public void test() throws Exception {
    char[] c1 = new char[]{'h','e','l','l','o'};
    this.reverseString(c1);
    assertThat(c1).containsExactly('o','l','l','e','h');
  }
}
