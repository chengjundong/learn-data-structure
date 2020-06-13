package jd.cheng.leetcode.offer;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;

/**
 * @author jucheng
 * @see <a href="https://leetcode-cn.com/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof/">link</a>
 */
public class Solution59 {

  private int[] result;
  private int x = 0;

  public int[] maxSlidingWindow(int[] nums, int k) {
    if(nums == null || nums.length == 0 || k < 1) return nums;
    result = new int[nums.length-k+1];
    this.recur(nums, 0, k-1);
    return result;
  }

  private void recur(int[] nums, int start, int end) {
    if(end > nums.length-1) return;
    int max = nums[start];
    for(int i=start+1; i<=end; i++) {
      if(nums[i] > max) max = nums[i];
    }
    result[x++] = max;
    this.recur(nums, start+1, end+1);
  }

  @Test
  public void test() throws Exception {
    assertThat(this.maxSlidingWindow(new int[]{1,2,3,4}, 3)).containsExactly(3,4);
    assertThat(this.maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3)).containsExactly(3,3,5,5,6,7);
  }
}
