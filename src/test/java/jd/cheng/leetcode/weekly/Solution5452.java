package jd.cheng.leetcode.weekly;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.Test;

/**
 * @author jucheng
 * @see <a href="https://leetcode-cn.com/contest/weekly-contest-196/problems/can-make-arithmetic-progression-from-sequence/">link</a>
 */
public class Solution5452 {

  public boolean canMakeArithmeticProgression(int[] arr) {
    if(arr == null || arr.length == 0) return true;

    List<Integer> list = new ArrayList<>(arr.length);
    for(int num : arr) {
      list.add(num);
    }
    Collections.sort(list);

    Integer delta = null;
    for(int i=0, j=1; i < list.size() && j < list.size(); i++, j++) {
      if(delta == null) {
        delta = list.get(j) - list.get(i);
      } else {
        if(delta != list.get(j) - list.get(i)) {
          return false;
        }
      }
    }

    return true;
  }

  @Test
  public void test() throws Exception {
    assertThat(this.canMakeArithmeticProgression(new int[]{1,2,4})).isFalse();
    assertThat(this.canMakeArithmeticProgression(new int[]{3,5,1})).isTrue();
    assertThat(this.canMakeArithmeticProgression(new int[]{1,2})).isTrue();
    assertThat(this.canMakeArithmeticProgression(new int[]{1})).isTrue();
  }
}
