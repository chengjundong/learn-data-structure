package jd.cheng.leetcode.algorithm;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;

public class Solution191 {

  // you need to treat n as an unsigned value
  public int hammingWeight(int n) {
    int count = 0;

    while(n != 0) {
      count += (n & 1);
      n = n >>> 1;
    }

    return count;
  }

  @Test
  public void test() throws Exception {
    assertThat(this.hammingWeight(0b00000000000000000000000000001011)).isEqualTo(3);
    assertThat(this.hammingWeight(0b00000000000000000000000010000000)).isEqualTo(1);
    assertThat(this.hammingWeight(0b11111111111111111111111111111101)).isEqualTo(31);
  }
}
