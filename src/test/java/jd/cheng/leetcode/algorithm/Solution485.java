package jd.cheng.leetcode.algorithm;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;

/**
 * @author jucheng
 * @see <a href="https://leetcode-cn.com/problems/max-consecutive-ones/">link</a>
 */
public class Solution485 {

  public int findMaxConsecutiveOnes(int[] nums) {
    int ans = 0;
    int ctn = 0;
    for(int i=0; i<nums.length; i++) {
      if(nums[i] == 1) {
        ctn++;
      } else {
        ans = Math.max(ans, ctn);
        ctn = 0;
      }
    }

    return Math.max(ans, ctn);
  }

  @Test
  public void test() throws Exception {
    int[] arr = new int[]{1,1,0,1,1,1};
    assertThat(this.findMaxConsecutiveOnes(arr)).isEqualTo(3);

    arr = new int[]{1,1,1,0,1,1};
    assertThat(this.findMaxConsecutiveOnes(arr)).isEqualTo(3);
  }
}
