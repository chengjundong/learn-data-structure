package jd.cheng.leetcode.interview;

import static org.assertj.core.api.Assertions.*;

import java.util.LinkedHashSet;
import java.util.Set;
import org.junit.Test;

/**
 * @author jucheng
 * @see <a href="https://leetcode-cn.com/problems/diving-board-lcci/">link</a>
 */
public class Solution16 {

  public int[] divingBoard(int shorter, int longer, int k) {
    if(k == 0) return new int[0];

    Set<Integer> set = new LinkedHashSet<>();
    for(int ks = k, kl=0;kl<=k;ks--,kl++) {
      set.add(shorter*ks + longer*kl);
    }

    int[] result = new int[set.size()];
    int i = 0;
    for(Integer n : set) {
      result[i++] = n;
    }

    return result;
  }

  @Test
  public void test() throws Exception {
    assertThat(this.divingBoard(1,2,3)).containsExactly(3,4,5,6);
    assertThat(this.divingBoard(1,1,100000)).containsExactly(100000);
  }
}
