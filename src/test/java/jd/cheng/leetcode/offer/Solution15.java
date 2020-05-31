package jd.cheng.leetcode.offer;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;

/**
 * @author jucheng
 */
public class Solution15 {

  // you need to treat n as an unsigned value
  public int hammingWeight(int n) {
    int result = 0;

    while(n != 0) {
      result ++;
      n = n & (n - 1);
    }

    return result;
  }

  @Test
  public void test() throws Exception {
    assertThat(this.hammingWeight(9)).isEqualTo(2);
    assertThat(this.hammingWeight(0b11111111111111111111111111111101)).isEqualTo(31);
  }
}
