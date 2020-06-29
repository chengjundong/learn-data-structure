package jd.cheng.leetcode.algorithm;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;

/**
 * @author jucheng
 * @see <a href="https://leetcode-cn.com/problems/add-digits/">link</a>
 */
public class Solution258 {

  public int addDigits(int num) {
    if (num < 10) {
      return num;
    }

    int result = 0;
    for (; num != 0; ) {
      result += num % 10;
      num /= 10;
    }
    return addDigits(result);
  }

  @Test
  public void test() throws Exception {
    assertThat(this.addDigits(38)).isEqualTo(2);
    assertThat(this.addDigits(100)).isEqualTo(1);
  }
}
