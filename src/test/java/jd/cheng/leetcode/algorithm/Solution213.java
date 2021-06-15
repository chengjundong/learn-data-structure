package jd.cheng.leetcode.algorithm;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

/**
 * @author jucheng
 * @see <a href="https://leetcode-cn.com/problems/house-robber-ii/">house-robber-ii</a>
 */
public class Solution213 {

  public int rob(int[] nums) {

    if (nums == null) {
      return 0;
    } else if (nums.length == 1) {
      return nums[0];
    } else if (nums.length == 2) {
      return Math.max(nums[0], nums[1]);
    }

    int prevMax = 0;
    int curMax = 0;

    int result = Integer.MIN_VALUE;

    for (int i = 0; i < nums.length; i++) {
      int l = nums.length - 2 + i;
      for (int j = i; j <= l; j++) {
        int t = curMax;
        curMax = Math.max(prevMax + nums[j % nums.length], curMax);
        prevMax = t;
      }
      result = Math.max(curMax, result);
      prevMax = 0;
      curMax = 0;
    }

    return result;
  }

  @Test
  public void test() {
    assertThat(this.rob(new int[]{1})).isEqualTo(1);
    assertThat(this.rob(new int[]{1, 2})).isEqualTo(2);
    assertThat(this.rob(new int[]{2, 1, 3, 8})).isEqualTo(9);
    assertThat(this.rob(new int[]{2, 7, 9, 3, 1})).isEqualTo(11);
    assertThat(this.rob(new int[]{2, 1, 1, 2})).isEqualTo(3);
  }
}
