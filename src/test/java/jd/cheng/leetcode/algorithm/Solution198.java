package jd.cheng.leetcode.algorithm;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;

/**
 * @author jucheng
 * @see <a href="https://leetcode-cn.com/problems/house-robber/">house robber</a>
 */
public class Solution198 {

  public int rob(int[] nums) {

    int prevMax = 0;
    int curMax = 0;

    for(int n : nums) {
      int t = curMax;
      curMax = Math.max(prevMax + n, curMax);
      prevMax = t;
    }

    return curMax;
  }

  @Test
  public void test() throws Exception {
    assertThat(this.rob(new int[]{1})).isEqualTo(1);
    assertThat(this.rob(new int[]{1,2})).isEqualTo(2);
    assertThat(this.rob(new int[]{1,2,3,1})).isEqualTo(4);
    assertThat(this.rob(new int[]{2,7,9,3,1})).isEqualTo(12);
    assertThat(this.rob(new int[]{2,1,1,2})).isEqualTo(4);
  }
}
