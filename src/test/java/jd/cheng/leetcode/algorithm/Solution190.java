package jd.cheng.leetcode.algorithm;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import org.junit.Test;

/**
 * @author jucheng
 * @see <a href="https://leetcode-cn.com/problems/reverse-bits/">reverse bits</a>
 */
public class Solution190 {

  // you need treat n as an unsigned value
  public int reverseBits(int n) {
    int ans = 0;
    for (int bitsSize = 31; n != 0; n = n >>> 1, bitsSize--) {
      ans += (n & 1) << bitsSize;
    }
    return ans;
  }

  @Test
  public void test() throws Exception {
    assertThat(this.reverseBits(0b00000010100101000001111010011100)).isEqualTo(0b00111001011110000010100101000000);
    assertThat(this.reverseBits(0b11111111111111111111111111111101)).isEqualTo(0b10111111111111111111111111111111);
  }
}
