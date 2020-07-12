package jd.cheng.leetcode.algorithm;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;

/**
 * @author jucheng
 * @see <a href="https://leetcode-cn.com/problems/add-strings/">link</a>
 */
public class Solution415 {

  public String addStrings(String num1, String num2) {
    StringBuilder res = new StringBuilder("");
    int i = num1.length() - 1, j = num2.length() - 1, carry = 0;
    while(i >= 0 || j >= 0){
      int n1 = i >= 0 ? num1.charAt(i) - '0' : 0;
      int n2 = j >= 0 ? num2.charAt(j) - '0' : 0;
      int tmp = n1 + n2 + carry;
      carry = tmp / 10;
      res.append(tmp % 10);
      i--; j--;
    }
    if(carry == 1) res.append(1);
    return res.reverse().toString();
  }

  @Test
  public void test() throws Exception {
    assertThat(this.addStrings("15", "126")).isEqualTo("141");
    assertThat(this.addStrings("1", "1")).isEqualTo("2");
    assertThat(this.addStrings("6913259244", "71103343")).isEqualTo("6984362587");
    assertThat(this.addStrings("498828660196", "840477629533")).isEqualTo("1339306289729");
  }
}
