package jd.cheng.leetcode.algorithm;

import static org.assertj.core.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

/**
 * @author jucheng
 * @see <a href="https://leetcode-cn.com/problems/contains-duplicate-ii/">存在重复元素 II</a>
 */
public class Solution219 {

  public boolean containsNearbyDuplicate(int[] nums, int k) {
    Map<Integer, Integer> map = new HashMap<>();

    for(int i=0; i<nums.length; i++) {
      if(map.containsKey(nums[i])) {
        int prevIndex = map.get(nums[i]);
        if(i - prevIndex <= k) {
          return true;
        } else {
          map.put(nums[i], i);
        }
      } else {
        map.put(nums[i], i);
      }
    }

    return false;
  }

  @Test
  public void test() throws Exception {
    assertThat(this.containsNearbyDuplicate(new int[]{1,2,3,1}, 3)).isTrue();
    assertThat(this.containsNearbyDuplicate(new int[]{1,0,1,1}, 1)).isTrue();
    assertThat(this.containsNearbyDuplicate(new int[]{1,2,3,1,2,3}, 2)).isFalse();
  }
}
