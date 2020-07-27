package jd.cheng.leetcode.algorithm;

import java.util.Arrays;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * @author jucheng
 * @see <a href="https://leetcode-cn.com/problems/heaters/">link</a>
 */
public class Solution475 {

  public int findRadius(int[] houses, int[] heaters) {
    Arrays.sort(houses);
    Arrays.sort(heaters);

    int ans = 0;
    for(int x=0,y=0; x<houses.length;x++) {
      int house = houses[x];

      while(y < heaters.length-1 && Math.abs(house - heaters[y]) >= Math.abs(house - heaters[y+1])) {
        y++;
      }

      ans = Math.max(ans, Math.abs(house - heaters[y]));
    }
    return ans;
  }

  @Test
  public void test() throws Exception {
    int[] houses = new int[]{1,2,3};
    int[] heaters = new int[]{2};
    assertThat(this.findRadius(houses, heaters)).isEqualTo(1);

    houses = new int[]{1,5};
    heaters = new int[]{2};
    assertThat(this.findRadius(houses, heaters)).isEqualTo(3);

    houses = new int[]{1,1,1,1,1,1,999,999,999,999,999};
    heaters = new int[]{499,500,501};
    assertThat(this.findRadius(houses, heaters)).isEqualTo(498);
  }
}
