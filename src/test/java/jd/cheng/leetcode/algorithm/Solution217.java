package jd.cheng.leetcode.algorithm;

import static org.assertj.core.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;
import org.junit.Test;

/**
 * @author jucheng
 * @see <a href="https://leetcode-cn.com/problems/contains-duplicate/">存在重复元素</a>
 */
public class Solution217 {

  public boolean containsDuplicate(int[] nums) {
    Set<Integer> set = new HashSet<>();
    for(int n : nums) {
      if(set.contains(n)) {
        return true;
      } else {
        set.add(n);
      }
    }
    return false;
  }

  @Test
  public void test() throws Exception {
    assertThat(this.containsDuplicate(new int[]{1,2,3,1})).isTrue();
    assertThat(this.containsDuplicate(new int[]{1,1,1,3,3,4,3,2,4,2})).isTrue();
    assertThat(this.containsDuplicate(new int[]{1,2,3,4})).isFalse();
  }
}
