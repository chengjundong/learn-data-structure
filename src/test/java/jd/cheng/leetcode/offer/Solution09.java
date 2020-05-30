package jd.cheng.leetcode.offer;

import static org.assertj.core.api.Assertions.*;

import java.util.Stack;
import org.junit.Test;

/**
 * @author jucheng
 * @see <a href="https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/">用两个栈实现队列</a>
 */
public class Solution09 {

  @Test
  public void test() throws Exception {
    CQueue queue = new CQueue();
    queue.appendTail(1);
    queue.appendTail(2);
    queue.appendTail(3);
    assertThat(queue.deleteHead()).isEqualTo(1);
    assertThat(queue.deleteHead()).isEqualTo(2);
    assertThat(queue.deleteHead()).isEqualTo(3);
  }
}

/**
 * Your CQueue object will be instantiated and called as such: CQueue obj = new CQueue();
 * obj.appendTail(value); int param_2 = obj.deleteHead();
 */
class CQueue {

  private final Stack<Integer> s1 = new Stack<>();
  private final Stack<Integer> s2 = new Stack<>();
  private int size = 0;

  public CQueue() {

  }

  public void appendTail(int value) {
    s1.push(value);
    size++;
  }

  public int deleteHead() {

    if(size == 0) {
      throw new RuntimeException();
    }

    while(!s1.isEmpty()) {
      s2.push(s1.pop());
    }

    int result = s2.pop();
    size--;

    while(!s2.isEmpty()) {
      s1.push(s2.pop());
    }

    return result;
  }
}
