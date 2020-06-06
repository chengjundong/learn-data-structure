package jd.cheng.leetcode.algorithm;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;

/**
 * @author jucheng
 * @see <a href="https://leetcode-cn.com/problems/find-the-duplicate-number/">寻找重复数</a>
 */
public class Solution287 {

  public int findDuplicate(int[] nums) {
    int slow = nums[0];
    int fast = nums[nums[0]];
    // 寻找相遇点
    while (slow != fast) {
      slow = nums[slow];
      fast = nums[nums[fast]];
    }
    // slow从起点开始，fast从相遇点开始
    slow = 0;
    while (slow != fast) {
      slow = nums[slow];
      fast = nums[fast];
    }
    return slow;
  }

  @Test
  public void test() throws Exception {
    assertThat(this.findDuplicate(new int[]{3, 1, 3, 4, 2})).isEqualTo(3);
    assertThat(this.findDuplicate(new int[]{1, 4, 6, 6, 6, 2, 3})).isEqualTo(6);
  }
}
