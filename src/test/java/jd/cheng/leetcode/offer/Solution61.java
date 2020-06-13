package jd.cheng.leetcode.offer;

import static org.assertj.core.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;
import org.junit.Test;

/**
 * @author jucheng
 * @see <a href="https://leetcode-cn.com/problems/bu-ke-pai-zhong-de-shun-zi-lcof/">link</a>
 */
public class Solution61 {
  public boolean isStraight(int[] nums) {
    int countZero = 0;
    Set<Integer> set = new HashSet<>(5);
    Integer min = null, max = null;
    for(int num : nums) {
      if(0 == num) countZero++;
      else {
        set.add(num);
        if(min == null) {
          min = num;
        } else if(min > num) {
          min = num;
        }

        if(max == null) {
          max = num;
        } else if(max < num) {
          max = num;
        }
      }
    }

    if(set.size() + countZero < 5) return false;

    return max - min < 5;
  }

  @Test
  public void test() throws Exception {
    assertThat(isStraight(new int[]{3,4,0,5,6})).isTrue();
    assertThat(isStraight(new int[]{1,1,0,0,1})).isFalse();
    assertThat(isStraight(new int[]{3,4,0,5,7})).isTrue();
    assertThat(isStraight(new int[]{3,4,0,5,13})).isFalse();
  }
}
