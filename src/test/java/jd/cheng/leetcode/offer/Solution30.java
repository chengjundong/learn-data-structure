package jd.cheng.leetcode.offer;

import static org.assertj.core.api.Assertions.*;

import java.util.Stack;
import org.junit.Test;

/**
 * @author jucheng
 * @see <a href="https://leetcode-cn.com/problems/bao-han-minhan-shu-de-zhan-lcof/">link</a>
 */
public class Solution30 {

  @Test
  public void test() throws Exception {
    MinStack minStack = new MinStack();
    minStack.push(-2);
    minStack.push(0);
    minStack.push(-3);
    assertThat(minStack.min()).isEqualTo(-3);
    minStack.pop();
    assertThat(minStack.top()).isEqualTo(0);
    assertThat(minStack.min()).isEqualTo(-2);
    minStack.pop();
    minStack.pop();

    MinStack ms2 = new MinStack();
    ms2.push(0);
    ms2.push(1);
    ms2.push(0);
    assertThat(ms2.min()).isEqualTo(0);
    ms2.pop();;
    assertThat(ms2.min()).isEqualTo(0);
  }
}

class MinStack {

  private final Stack<Integer> s = new Stack<>();
  private final Stack<Integer> min = new Stack<>();

  /**
   * initialize your data structure here.
   */
  public MinStack() {

  }

  public void push(int x) {
    s.push(x);
    if(min.isEmpty() || min.peek() >= x) {
      min.push(x);
    }
  }

  public void pop() {
    if(s.pop() == min.peek()) {
      min.pop();
    }
  }

  public int top() {
    return s.peek();
  }

  public int min() {
    return min.peek();
  }
}
