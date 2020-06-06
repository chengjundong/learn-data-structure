package jd.cheng.leetcode.offer;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;

/**
 * @author jucheng
 */
public class Solution64 {

  public int sumNums(int n) {
    boolean x = n > 1 && (n += sumNums(n-1)) > 0;
    return n;
  }

  @Test
  public void test() throws Exception {
    assertThat(this.sumNums(9)).isEqualTo(45);
  }
}
