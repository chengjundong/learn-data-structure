package jd.cheng.leetcode.algorithm;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import org.junit.Test;

/**
 * @author jucheng
 * @see <a href="https://leetcode-cn.com/problems/assign-cookies/">link</a>
 */
public class Solution455 {

  public int findContentChildren(int[] g, int[] s) {

    Arrays.sort(g);
    Arrays.sort(s);

    int ans = 0;
    for(int i = 0, j=0; i < g.length && j < s.length; j++) {
      int gi = g[i];
      int sj = s[j];

      if(gi <= sj) {
        ans++;
        i++;
      }
    }

    return ans;
  }

  @Test
  public void test() throws Exception {
    int[] g = new int[]{1,2,3};
    int[] s = new int[]{1,1};

    assertThat(this.findContentChildren(g, s)).isEqualTo(1);

    g = new int[]{1,2};
    s = new int[]{1,2,3};
    assertThat(this.findContentChildren(g, s)).isEqualTo(2);

    g = new int[]{1,2,3};
    s = new int[]{100};
    assertThat(this.findContentChildren(g, s)).isEqualTo(1);

    g = new int[]{2,2,2};
    s = new int[]{1,1,2};
    assertThat(this.findContentChildren(g, s)).isEqualTo(1);
  }
}
