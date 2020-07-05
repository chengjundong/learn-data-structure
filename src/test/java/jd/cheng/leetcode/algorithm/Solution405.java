package jd.cheng.leetcode.algorithm;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;

/**
 * @author jucheng
 * @see <a href="https://leetcode-cn.com/problems/convert-a-number-to-hexadecimal/">link</a>
 */
public class Solution405 {

  public String toHex(int num) {
    char[] hex = "0123456789abcdef".toCharArray();
    String s = new String();
    while (num != 0) {
      int end = num & 15;
      s = hex[end] + s;
      num >>>= 4;
    }
    if (s.length() == 0) {
      s = "0";
    }

    return s;
  }

  @Test
  public void test() throws Exception {
    assertThat(this.toHex(26)).isEqualTo("1a");
  }
}
