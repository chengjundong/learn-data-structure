package jd.cheng.leetcode.interview;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;

/**
 * @author jucheng
 * @see <a href="https://leetcode-cn.com/problems/magic-index-lcci/">link</a>
 */
public class Solution0803 {

  public int findMagicIndex(int[] nums) {
    for(int i=0; i<nums.length; i++) {
      if(nums[i] == i) return i;
    }
    return -1;
  }

  @Test
  public void test() throws Exception {
    int[] arr = new int[]{0, 2, 3, 4, 5};
    assertThat(this.findMagicIndex(arr)).isEqualTo(0);

    arr = new int[]{1,1,1};
    assertThat(this.findMagicIndex(arr)).isEqualTo(1);

    arr = new int[]{3,2,1};
    assertThat(this.findMagicIndex(arr)).isEqualTo(-1);
  }
}
