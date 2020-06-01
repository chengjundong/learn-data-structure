package jd.cheng.leetcode.offer;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;

/**
 * @author jucheng
 * @see <a href="https://leetcode-cn.com/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof/">link</a>
 */
public class Solution21 {

  public int[] exchange(int[] nums) {

    int[] odd = new int[nums.length];
    int oddSize = 0;
    int[] even = new int[nums.length];
    int evenSize = 0;

    for(int num : nums) {
      if(num % 2 == 0) {
        even[evenSize] = num;
        evenSize++;
      } else {
        odd[oddSize] = num;
        oddSize++;
      }
    }

    for(int i=0; i < oddSize; i++) {
      nums[i] = odd[i];
    }

    for(int i=oddSize; i<nums.length; i++) {
      nums[i] = even[i-oddSize];
    }

    return nums;
  }

  @Test
  public void test() throws Exception {
    assertThat(this.exchange(new int[]{1,2,3,4})).containsExactly(1,3,2,4);
  }
}
