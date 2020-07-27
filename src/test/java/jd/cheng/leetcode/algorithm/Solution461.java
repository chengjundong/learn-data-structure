package jd.cheng.leetcode.algorithm;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;


/**
 * @author jucheng
 * @since <a href="https://leetcode-cn.com/problems/hamming-distance/">link</a>
 */
public class Solution461 {

  public int hammingDistance(int x, int y) {

    int ans = 0;
    while (x != 0 || y != 0) {
      int _x = x & 1;
      int _y = y & 1;
      ans += (_x ^ _y);

      x = x >> 1;
      y = y >> 1;
    }

    return ans;
  }

  @Test
  public void test()throws Exception {
    assertThat(this.hammingDistance(1,4)).isEqualTo(2);
  }
}
