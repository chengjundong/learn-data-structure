package jd.cheng.leetcode.algorithm;

import static org.assertj.core.api.Assertions.*;

import java.util.Stack;
import org.junit.Test;

/**
 * @author jucheng
 * @see <a href="https://leetcode-cn.com/problems/excel-sheet-column-title/">excel sheet column title</a>
 */
public class Solution168 {

  public String convertToTitle(int n) {

    Stack<Integer> stack = new Stack<>();
    _convert(n, stack);

    StringBuffer sb = new StringBuffer();
    char[] chars = new char[stack.size()];

    for(int i=0; !stack.isEmpty(); i++) {
      char c = (char)stack.pop().intValue();
      chars[i] = c;
    }

    return new String(chars);
  }

  private void _convert(int n, Stack<Integer> stack) {
    if(n < 27) {
      stack.push(n + 64);
    } else {
      int m = n % 26 == 0 ? 26 : n % 26;
      int k = n % 26 == 0 ? n / 26 - 1 : n / 26;
      stack.push(m + 64);
      _convert(k, stack);
    }
  }

  @Test
  public void test() throws Exception {
    assertThat(this.convertToTitle(1)).isEqualTo("A");
    assertThat(this.convertToTitle(2)).isEqualTo("B");
    assertThat(this.convertToTitle(25)).isEqualTo("Y");
    assertThat(this.convertToTitle(26)).isEqualTo("Z");
    assertThat(this.convertToTitle(27)).isEqualTo("AA");
    assertThat(this.convertToTitle(701)).isEqualTo("ZY");
    assertThat(this.convertToTitle(52)).isEqualTo("AZ");
  }
}
