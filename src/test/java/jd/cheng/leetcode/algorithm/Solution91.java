package jd.cheng.leetcode.algorithm;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * @author jucheng
 * @see <a href="https://leetcode-cn.com/problems/decode-ways/">decode-ways</a>
 */
public class Solution91 {

  public int numDecodings(String s) {
    char[] chars = s.toCharArray();
    int prev = Character.getNumericValue(chars[0]) * 10;
    int[] decodingCount = new int[chars.length+1];
    decodingCount[0] = 1;

    for (int i = 1; i <= chars.length; i++) {
      int cur = Character.getNumericValue(chars[i-1]);
      int count = 0;

      if(cur != 0) {
        count += decodingCount[i-1];
      }

      if(i != 1 && prev != 0 && cur+prev <= 26) {
        count += decodingCount[i-2];
      }

      decodingCount[i] = count;
      prev = cur * 10;
    }

    return decodingCount[decodingCount.length-1];
  }

  @Test
  public void test() {
    assertThat(numDecodings("2101")).isEqualTo(1);
    assertThat(numDecodings("10")).isEqualTo(1);
    assertThat(numDecodings("0")).isEqualTo(0);
    assertThat(numDecodings("06")).isEqualTo(0);
    assertThat(numDecodings("1")).isEqualTo(1);
    assertThat(numDecodings("12")).isEqualTo(2);
    assertThat(numDecodings("226")).isEqualTo(3);
    assertThat(numDecodings("1001")).isEqualTo(0);
  }
}
