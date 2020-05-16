package jd.cheng.leetcode.algorithm;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;

/**
 * @author jucheng
 * @see <a href="https://leetcode-cn.com/problems/majority-element/">majority elements</a>
 */
public class Solution169 {

  public int majorityElement(int[] nums) {

    int count = 0;
    Integer candidate = null;

    for(int num : nums) {
      if(count == 0) {
        candidate = num;
      }
      count += (num == candidate) ? 1 : -1;
    }

    return candidate;
  }

  @Test
  public void test() throws Exception {
    assertThat(this.majorityElement(new int[]{3,2,3})).isEqualTo(3);
    assertThat(this.majorityElement(new int[]{1})).isEqualTo(1);
    assertThat(this.majorityElement(new int[]{2,2,1,1,1,2,2})).isEqualTo(2);
  }
}
