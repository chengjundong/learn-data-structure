package jd.cheng.leetcode.algorithm;

import static org.assertj.core.api.Assertions.*;

import java.util.LinkedList;
import org.junit.Test;

/**
 * @author jucheng
 * @see <a href="https://leetcode-cn.com/problems/decode-string/">字符串解码</a>
 */
public class Solution394 {

  public String decodeString(String s) {
    StringBuilder res = new StringBuilder();
    int multi = 0;
    LinkedList<Integer> stack_multi = new LinkedList<>();
    LinkedList<String> stack_res = new LinkedList<>();
    for (Character c : s.toCharArray()) {
      if (c == '[') {
        stack_multi.addLast(multi);
        stack_res.addLast(res.toString());
        multi = 0;
        res = new StringBuilder();
      } else if (c == ']') {
        StringBuilder tmp = new StringBuilder();
        int cur_multi = stack_multi.removeLast();
        for (int i = 0; i < cur_multi; i++) {
          tmp.append(res);
        }
        res = new StringBuilder(stack_res.removeLast() + tmp);
      } else if (c >= '0' && c <= '9') {
        multi = multi * 10 + Integer.parseInt(c + "");
      } else {
        res.append(c);
      }
    }
    return res.toString();
  }

  @Test
  public void test() throws Exception {
    assertThat(this.decodeString("3[a]2[bc]")).isEqualTo("aaabcbc");
    assertThat(this.decodeString("3[a2[c]]")).isEqualTo("accaccacc");
    assertThat(this.decodeString("2[abc]3[cd]ef")).isEqualTo("abcabccdcdcdef");
    assertThat(this.decodeString("10[a]")).isEqualTo("aaaaaaaaaa");
  }
}
