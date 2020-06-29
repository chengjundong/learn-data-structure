package jd.cheng.leetcode.algorithm;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;

/**
 * @author jucheng
 * @see <a href="https://leetcode-cn.com/problems/power-of-three/">link</a>
 */
public class Solution326 {

  public boolean isPowerOfThree(int n) {
    if(n == 1) return true;
    if(n == 0) return false;
    if(n % 3 != 0) return false;
    return isPowerOfThree(n/3);
  }

  @Test
  public void test() throws Exception {
    assertThat(this.isPowerOfThree(27)).isTrue();
    assertThat(this.isPowerOfThree(0)).isFalse();
    assertThat(this.isPowerOfThree(10)).isFalse();
    assertThat(this.isPowerOfThree(24)).isFalse();
  }
}
