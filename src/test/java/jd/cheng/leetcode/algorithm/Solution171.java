package jd.cheng.leetcode.algorithm;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;

/**
 * @author jucheng
 * @see <a href="https://leetcode-cn.com/problems/excel-sheet-column-number/">Excel sheet column number</a>
 */
public class Solution171 {

  public int titleToNumber(String s) {
    int result = 0;
    for(int i=s.length()-1; i >= 0; i--) {
      char c = s.charAt(i);
      int k = (int)c - 64;
      if(s.length()-1 == i) {
        result += k;
      } else {
        int x = s.length()-1 - i;
        result += Math.pow(26, x) * k;
      }
    }

    return result;
  }

  @Test
  public void test() throws Exception {
    assertThat(this.titleToNumber("A")).isEqualTo(1);
    assertThat(this.titleToNumber("Z")).isEqualTo(26);
    assertThat(this.titleToNumber("AA")).isEqualTo(27);
    assertThat(this.titleToNumber("AZ")).isEqualTo(52);
    assertThat(this.titleToNumber("ZY")).isEqualTo(701);
    assertThat(this.titleToNumber("BA")).isEqualTo(53);
    assertThat(this.titleToNumber("AAA")).isEqualTo(703);
  }
}
