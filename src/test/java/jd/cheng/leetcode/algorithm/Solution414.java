package jd.cheng.leetcode.algorithm;

import static org.assertj.core.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;
import org.junit.Test;

/**
 * @author jucheng
 * @see <a href="https://leetcode-cn.com/problems/third-maximum-number/">link</a>
 */
public class Solution414 {
  Integer first = null;
  Integer second = null;
  Integer third = null;

  public int thirdMax(int[] nums) {
    Set<Integer> set = new HashSet<>();
    for(int n : nums) {
      if(set.contains(n)) {
        continue;
      } else {
        set.add(n);
        insert(n);
      }
    }

    return third == null ? first : third;
  }

  private void insert(int n) {
    if(first == null || n > first) {
      third = second;
      second = first;
      first = n;
    } else if(second == null || n > second) {
      third = second;
      second = n;
    } else if(third == null || n > third) {
      third = n;
    }
  }

  @Test
  public void test() throws Exception {
    assertThat(this.thirdMax(new int[]{2, 2, 3, 1})).isEqualTo(1);
  }
}
