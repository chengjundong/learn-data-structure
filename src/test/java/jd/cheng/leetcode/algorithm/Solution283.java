package jd.cheng.leetcode.algorithm;

import static org.assertj.core.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;
import org.junit.Test;

/**
 * @author jucheng
 * @see <a href="https://leetcode-cn.com/problems/move-zeroes/">link</a>
 */
public class Solution283 {

  public void moveZeroes(int[] nums) {
    int k = 0;
    for(int i=0; i<nums.length; i++) {
      int num = nums[i];
      if(num != 0) {
        nums[k++] = num;
      }
    }

    for(int i=k; i<nums.length; i++) {
      nums[i] = 0;
    }
  }

  @Test
  public void test() throws Exception {
    int[] nums = new int[]{0,1,0,3,12};
    this.moveZeroes(nums);
    assertThat(nums).containsExactly(1,3,12,0,0);
  }
}
