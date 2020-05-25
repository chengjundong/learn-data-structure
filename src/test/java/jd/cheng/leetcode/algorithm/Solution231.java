package jd.cheng.leetcode.algorithm;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;

/**
 * @author jucheng
 * @see <a href="https://leetcode-cn.com/problems/power-of-two/">2的幂</a>
 */
public class Solution231 {

  public boolean isPowerOfTwo(int n) {
    if(n <= 0) return false;
    else if(n == 1) return true;
    else {
      while(n > 1) {
        if(0 != n%2) return false;
        n = n/2;
      }
    }
    return true;
  }

  @Test
  public void test() throws Exception {
    assertThat(this.isPowerOfTwo(1)).isTrue();
    assertThat(this.isPowerOfTwo(2)).isTrue();
    assertThat(this.isPowerOfTwo(16)).isTrue();
    assertThat(this.isPowerOfTwo(218)).isFalse();
  }
}
