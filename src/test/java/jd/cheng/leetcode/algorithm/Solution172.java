package jd.cheng.leetcode.algorithm;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;

/**
 * @author jucheng
 * @see <a href="https://leetcode-cn.com/problems/factorial-trailing-zeroes/">factorial trailing
 * zeroes</a>
 */
public class Solution172 {

  public int trailingZeroes(int n) {
    int result = 0;
    long k = 5;
    while(n >= k) {
      result += n/k;
      k *= 5;
    }

    return result;
  }

  @Test
  public void test() throws Exception {
    assertThat(this.trailingZeroes(4)).isZero();
    assertThat(this.trailingZeroes(5)).isEqualTo(1);
    assertThat(this.trailingZeroes(10)).isEqualTo(2);
    assertThat(this.trailingZeroes(25)).isEqualTo(6);
    assertThat(this.trailingZeroes(30)).isEqualTo(7);
  }
}
