package jd.cheng.leetcode.algorithm;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;

/**
 * @author jucheng
 * @see <a href="https://leetcode-cn.com/problems/missing-number/">link</a>
 */
public class Solution268 {
  public int missingNumber(int[] nums) {
    int n = nums.length + 1;
    int sum = n * (n-1) / 2;
    for(int num : nums) {
      sum -= num;
    }
    return sum;
  }

  @Test
  public void test() throws Exception {
    assertThat(this.missingNumber(new int[]{9,6,4,2,3,5,7,0,1})).isEqualTo(8);
  }
}
