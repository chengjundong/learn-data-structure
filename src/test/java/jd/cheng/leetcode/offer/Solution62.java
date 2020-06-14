package jd.cheng.leetcode.offer;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;

/**
 * @author jucheng
 * @see <a href="https://leetcode-cn.com/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof/">link</a>
 */
public class Solution62 {

  public int lastRemaining(int n, int m) {
    int result = 0;
    for(int i=2; i<=n; i++) {
      result = (result + m)%i;
    }

    return result;
  }

  @Test
  public void test() throws Exception {
    assertThat(this.lastRemaining(5,3)).isEqualTo(3);
    assertThat(this.lastRemaining(10,17)).isEqualTo(2);
    assertThat(this.lastRemaining(70866, 116922)).isEqualTo(64165);
  }
}
