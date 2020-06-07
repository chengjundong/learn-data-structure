package jd.cheng.leetcode.offer;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;

/**
 * @author jucheng
 * @see <a href="https://leetcode-cn.com/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof/">link</a>
 */
public class Solution42 {

  public int maxSubArray(int[] nums) {
    int max = nums[0];
    int cur = nums[0];

    for(int i=1; i<nums.length; i++) {
      cur = Math.max(nums[i], cur + nums[i]);
      max = Math.max(cur, max);
    }

    return max;
  }

  @Test
  public void test() throws Exception {
    assertThat(this.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4})).isEqualTo(6);
  }
}
