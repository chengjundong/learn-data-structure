package jd.cheng.leetcode.weekly;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;

/**
 * @author jucheng
 * @see <a href="https://leetcode-cn.com/contest/weekly-contest-194/problems/xor-operation-in-an-array/">link</a>
 */
public class Solution5440 {

  public int xorOperation(int n, int start) {
    int result = start;
    for(int i=1; i<n; i++) {
      result = result ^ (start + 2*i);
    }
    return result;
  }

  @Test
  public void test() throws Exception {
    assertThat(this.xorOperation(5,0)).isEqualTo(8);
    assertThat(this.xorOperation(4,3)).isEqualTo(8);
    assertThat(this.xorOperation(10,5)).isEqualTo(2);
  }
}
