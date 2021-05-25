package jd.cheng.leetcode.algorithm;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * @author jucheng
 * @see <a href="https://leetcode-cn.com/problems/integer-break/">integer-break</a>
 */
public class Solution343 {

  /**
   * 2 <= n <= 58
   */
  private int[] arr = new int[59];

  public int integerBreak(int n) {

    arr[1] = 1;
    arr[2] = 1;

    for (int x = 3; x <= n; x++) {
      int max = 0;
      for(int y = 1; y <= x-1; y++) {
        int i = Math.max(y, arr[y]);
        int j = Math.max(x-y, arr[x-y]);
        max = Math.max(max, i * j);
      }
      arr[x] = max;
    }

    return arr[n];
  }

  @Test
  public void test() {
    assertThat(integerBreak(2)).isEqualTo(1);
    assertThat(integerBreak(4)).isEqualTo(4);
    assertThat(integerBreak(10)).isEqualTo(36);
  }
}
