package jd.cheng.leetcode.algorithm;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;


/**
 * @author jucheng
 * @see <a href="https://leetcode-cn.com/problems/power-of-four/">link</a>
 */
public class Solution342 {

  public boolean isPowerOfFour(int num) {
    double e = Math.log(num) / Math.log(4);
    return e == (int)e;
  }

  @Test
  public void test() throws Exception {
    assertThat(this.isPowerOfFour(16)).isTrue();
    assertThat(this.isPowerOfFour(5)).isFalse();
    assertThat(this.isPowerOfFour(2)).isFalse();
    assertThat(this.isPowerOfFour(8)).isFalse();
  }
}
