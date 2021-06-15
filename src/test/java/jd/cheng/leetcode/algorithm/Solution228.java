package jd.cheng.leetcode.algorithm;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * @author jucheng
 */
public class Solution228 {

  public List<String> summaryRanges(int[] nums) {
    List<String> result = new ArrayList<>();
    if (null == nums || nums.length == 0) {
      return result;
    }

    long prev = nums[0];
    long start = nums[0];
    for (int i = 0; i < nums.length; i++) {
      long x = nums[i];
      if (prev < x - 1) {
        result.add(concat(start, prev));
        start = x;
      }
      if (i == nums.length - 1) {
        result.add(concat(start, x));
      }
      prev = x;
    }

    return result;
  }

  private String concat(long prev, long now) {
    return prev == now ? "" + prev : prev + "->" + now;
  }

  @Test
  public void test() {
    int[] nums = new int[]{};
    assertThat(summaryRanges(nums)).isEmpty();

    nums = new int[]{0};
    assertThat(summaryRanges(nums)).containsExactly("0");

    nums = new int[]{0, 1};
    assertThat(summaryRanges(nums)).containsExactly("0->1");

    nums = new int[]{-2, 3, 6, 9};
    assertThat(summaryRanges(nums)).containsExactly("-2", "3", "6", "9");

    nums = new int[]{0, 1, 2, 4, 5, 7};
    assertThat(summaryRanges(nums)).containsExactly("0->2", "4->5", "7");

    nums = new int[]{0, 2, 3, 4, 6, 8, 9};
    assertThat(summaryRanges(nums)).containsExactly("0", "2->4", "6", "8->9");

    nums = new int[]{-2147483648,-2147483647,2147483647};
    assertThat(summaryRanges(nums)).containsExactly("-2147483648->-2147483647","2147483647");
  }
}
