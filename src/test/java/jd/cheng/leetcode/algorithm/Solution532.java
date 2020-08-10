package jd.cheng.leetcode.algorithm;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.Test;

/**
 * @author jucheng
 * @see <a href="https://leetcode-cn.com/problems/k-diff-pairs-in-an-array/">link</a>
 */
public class Solution532 {

  public int findPairs(int[] nums, int k) {
    if (null == nums) {
      return 0;
    }

    Set<Integer> set = new HashSet<>();
    Set<String> set2 = new HashSet<>();
    Arrays.sort(nums);

    int ans = 0;
    for(int num : nums) {
      String pair = String.format("%d,%d", num, num - k);
      if(set.contains(num-k) && !set2.contains(pair)) {
        ans++;
        set2.add(pair);
      }
      set.add(num);
    }

    return ans;
  }

  @Test
  public void test() throws Exception {
    int[] nums = new int[]{1, 2, 3, 4, 5};
    assertThat(this.findPairs(nums, 1)).isEqualTo(4);

    nums = new int[]{1, 3, 1, 5, 4};
    assertThat(this.findPairs(nums, 0)).isEqualTo(1);

    nums = new int[]{3, 1, 4, 1, 5};
    assertThat(this.findPairs(nums, 2)).isEqualTo(2);

    nums = new int[]{1, 1, 1, 1, 1};
    assertThat(this.findPairs(nums, 0)).isEqualTo(1);
  }
}
