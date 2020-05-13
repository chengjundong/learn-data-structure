package jd.cheng.leetcode.algorithm;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;

/**
 * @author jucheng
 * @see <a href="https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/">two sum</a>
 */
public class Solution167 {

  public int[] twoSum(int[] numbers, int target) {

    int i = 0;
    int j = numbers.length - 1;

    for(;i < numbers.length && j >= 0;) {
      if(target == numbers[i] + numbers[j]) {
        break;
      } else if(target < numbers[i] + numbers[j]) {
        j--;
      } else {
        i++;
      }
    }

    return new int[] {i+1, j+1};
  }

  @Test
  public void test() throws Exception {
    assertThat(twoSum(new int[]{2,7,11,13}, 9)).containsExactly(1,2);
  }
}
