package jd.cheng.leetcode.offer;

import static org.assertj.core.api.Assertions.*;

import java.util.Stack;
import org.junit.Test;

/**
 * @author jucheng
 * @see <a href="https://leetcode-cn.com/problems/fan-zhuan-dan-ci-shun-xu-lcof/">link</a>
 */
public class Solution58 {

  public String reverseWords(String s) {
    if(s == null) return s;

    String[] str = s.trim().split(" ");
    StringBuffer sb = new StringBuffer();
    for(int i=str.length-1; i>=0; i--) {
      if("".equals(str[i])) continue;
      else sb.append(str[i]).append(" ");
    }

    return sb.toString().trim();
  }

  @Test
  public void test() throws Exception {
    assertThat(this.reverseWords("the sky is blue")).isEqualTo("blue is sky the");
    assertThat(this.reverseWords("hello world!")).isEqualTo("world! hello");
    assertThat(this.reverseWords("  hello   world!   ")).isEqualTo("world! hello");
    assertThat(this.reverseWords("a good   example")).isEqualTo("example good a");
  }
}
