package jd.cheng.leetcode.algorithm;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * @author jucheng
 * @see <a href="https://leetcode-cn.com/problems/perfect-squares/">perfect-squares</a>
 */
public class Solution279 {

  public int numSquares(int n) {

    int[] arr = new int[n+1];

    for (int i = 1; i <= n; i++) {
      int min = Integer.MAX_VALUE;
      for (int j = 1; j * j <= i; j++) {
        min = Math.min(min, 1 + arr[i-j*j]);
      }
      arr[i] = min;
    }

    return arr[n];
  }

  @Test
  public void test() {
    assertThat(numSquares(16)).isEqualTo(1);
    assertThat(numSquares(12)).isEqualTo(3);
    assertThat(numSquares(13)).isEqualTo(2);
  }
}
