package jd.cheng.leetcode.weekly;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;

/**
 * @author jucheng
 * @see <a href="https://leetcode-cn.com/contest/weekly-contest-196/problems/last-moment-before-all-ants-fall-out-of-a-plank/">link</a>
 */
public class Solution5453 {

  public int getLastMoment(int n, int[] left, int[] right) {
    int maxToLeft = 0;
    int maxToRight = 0;

    // to left
    for(int i=0; i<left.length; i++) {
      maxToLeft = Math.max(maxToLeft, left[i]-0);
    }

    // to right
    for(int i=0; i<right.length; i++) {
      maxToRight = Math.max(maxToRight, n-right[i]);
    }

    return Math.max(maxToLeft, maxToRight);
  }

  @Test
  public void test() throws Exception {
    assertThat(this.getLastMoment(4, new int[]{4,3}, new int[]{0,1})).isEqualTo(4);
    assertThat(this.getLastMoment(7, new int[]{}, new int[]{0,1,2,3,4,5,6,7})).isEqualTo(7);
    assertThat(this.getLastMoment(7, new int[]{0,1,2,3,4,5,6,7}, new int[]{})).isEqualTo(7);
    assertThat(this.getLastMoment(9, new int[]{5}, new int[]{4})).isEqualTo(5);
    assertThat(this.getLastMoment(6, new int[]{6}, new int[]{0})).isEqualTo(6);
  }
}
