package jd.cheng.leetcode.algorithm;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;

/**
 * @author jucheng
 * @see <a href="https://leetcode-cn.com/problems/nim-game/">link</a>
 */
public class Solution292 {

  public boolean canWinNim(int n) {
    return (n % 4) != 0;
  }

  @Test
  public void test() throws Exception {
    assertThat(this.canWinNim(4)).isFalse();
    assertThat(this.canWinNim(5)).isTrue();
    assertThat(this.canWinNim(1)).isTrue();
  }
}
