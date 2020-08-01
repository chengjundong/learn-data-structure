package jd.cheng.leetcode.algorithm;

import static org.assertj.core.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;
import org.junit.Test;

/**
 * @author jucheng
 * @see <a href="https://leetcode-cn.com/problems/construct-the-rectangle/">link</a>
 */
public class Solution492 {

  public int[] constructRectangle(int area) {

    int l = area;
    int w = 1;
    Set<Integer> lengths = new HashSet<>();

    for(int i=2; i<area; i++) {
      if(area % i == 0) {
        int _l = Math.max(i, area/i);
        int _w = Math.min(i, area/i);

        if(lengths.contains(_l)) break;
        else lengths.add(_l);

        if(l - w > _l - _w) {
          l = _l;
          w = _w;
        }
      }
    }

    return new int[]{l, w};
  }

  @Test
  public void test() throws Exception {
    assertThat(this.constructRectangle(4)).containsExactly(2,2);
    assertThat(this.constructRectangle(7)).containsExactly(7,1);
    assertThat(this.constructRectangle(12)).containsExactly(4,3);
  }
}
