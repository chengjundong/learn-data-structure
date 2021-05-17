package jd.cheng.leetcode.weekly;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;

/**
 * @author jucheng
 * @see <a href="https://leetcode-cn.com/contest/weekly-contest-202/problems/three-consecutive-odds/">link</a>
 */
public class Solution5185 {

  public boolean threeConsecutiveOdds(int[] arr) {
    if(arr == null) return false;
    int ctn = 0;
    for(int n : arr) {
      if(n % 2 == 0) {
        ctn = 0;
      } else {
        ctn++;
        if(ctn == 3) return true;
      }
    }
    return ctn == 3;
  }

  @Test
  public void test() throws Exception {
    int[] arr = new int[]{1,2,34,3,4,5,7,23,12};
    assertThat(this.threeConsecutiveOdds(arr)).isTrue();

    arr = new int[]{1,2,34,3,4,5,7,23};
    assertThat(this.threeConsecutiveOdds(arr)).isTrue();

    arr = new int[]{2,6,4,1};
    assertThat(this.threeConsecutiveOdds(arr)).isFalse();
  }
}
