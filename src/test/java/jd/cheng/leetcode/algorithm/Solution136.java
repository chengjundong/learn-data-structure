package jd.cheng.leetcode.algorithm;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;

/**
 * @author jucheng
 * @see <a href="https://leetcode-cn.com/problems/single-number/">single number</a>
 */
public class Solution136 {

  public int singleNumber(int[] nums) {
    int a = 0;
    for (int i : nums) {
      a ^= i;
    }
    return a;
  }

  @Test
  public void test() throws Exception {
    assertThat(singleNumber(new int[]{2,2,1})).isEqualTo(1);
    assertThat(singleNumber(new int[]{4,1,2,1,2})).isEqualTo(4);
  }
}
