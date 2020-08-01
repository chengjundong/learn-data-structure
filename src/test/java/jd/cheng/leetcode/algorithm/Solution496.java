package jd.cheng.leetcode.algorithm;

import static org.assertj.core.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

/**
 * @author jucheng
 * @see <a href="https://leetcode-cn.com/problems/next-greater-element-i/">link</a>
 */
public class Solution496 {

  public int[] nextGreaterElement(int[] nums1, int[] nums2) {
    // get all index mapping
    Map<Integer, Integer> nums2Indexes = new HashMap<>(nums2.length);
    for (int i = nums2.length - 1; i >= 0; i--) {
      nums2Indexes.put(nums2[i], i);
    }

    int[] ans = new int[nums1.length];
    N1:
    for (int i = 0; i < nums1.length; i++) {
      // get index of nums
      int num1 = nums1[i];
      Integer k = nums2Indexes.get(num1);

      // find the 1st number bigger than num1
      N2:
      for (int j = k + 1; j < nums2.length; j++) {
        if (num1 < nums2[j]) {
          ans[i] = nums2[j];
          // found, skip to the N1 loop
          continue N1;
        }
      }
      // not found, set to -1
      ans[i] = -1;
    }

    return ans;
  }

  @Test
  public void test() throws Exception {
    int[] nums1 = new int[]{4, 1, 2};
    int[] nums2 = new int[]{1, 3, 4, 2};

    assertThat(this.nextGreaterElement(nums1, nums2)).containsExactly(-1, 3, -1);

    nums1 = new int[]{2, 4};
    nums2 = new int[]{1, 2, 3, 4};

    assertThat(this.nextGreaterElement(nums1, nums2)).containsExactly(3, -1);
  }
}
