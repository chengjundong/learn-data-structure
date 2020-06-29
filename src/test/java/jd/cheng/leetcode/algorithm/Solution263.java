package jd.cheng.leetcode.algorithm;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;

/**
 * @author jucheng
 * @see <a href="https://leetcode-cn.com/problems/ugly-number/">link</a>
 */
public class Solution263 {

  public boolean isUgly(int num) {
    if(num == 0) return false;
    num = extract(num, 2);
    num = extract(num, 3);
    num = extract(num, 5);
    return num == 1;
  }

  private int extract(int num, int factor) {
    while(true) {
      int remain = num % factor;
      if(remain == 0) {
        num /= factor;
      } else {
        break;
      }
    }
    return num;
  }

  @Test
  public void test() throws Exception {
    assertThat(this.isUgly(6)).isTrue();
    assertThat(this.isUgly(8)).isTrue();
    assertThat(this.isUgly(14)).isFalse();
  }
}
