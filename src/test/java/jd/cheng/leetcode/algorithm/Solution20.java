package jd.cheng.leetcode.algorithm;

import static org.assertj.core.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Stack;
import org.junit.Test;

/**
 * @author jucheng
 * @since <a href="https://leetcode-cn.com/problems/valid-parentheses/">link</a>
 */
public class Solution20 {

  public boolean isValid(String s) {
    if(s == null) return false;

    Stack<Character> stack = new Stack<>();
    Map<Character, Character> parentheses = new HashMap<>();
    parentheses.put('(', ')');
    parentheses.put('[', ']');
    parentheses.put('{', '}');

    for(char c : s.toCharArray()) {
      if(parentheses.containsKey(c)) {
        // left
        stack.push(c);
      } else {
        // right
        if(stack.isEmpty()) return false;

        Character left = stack.pop();
        if(!Objects.equals(parentheses.get(left), c)) {
          return false;
        }
      }
    }

    return stack.isEmpty();
  }

  @Test
  public void test() throws Exception {
    assertThat(this.isValid("()")).isTrue();
    assertThat(this.isValid("([])")).isTrue();
    assertThat(this.isValid("([{}])")).isTrue();
    assertThat(this.isValid("([{])")).isFalse();
    assertThat(this.isValid(")")).isFalse();
    assertThat(this.isValid("{")).isFalse();
  }
}
