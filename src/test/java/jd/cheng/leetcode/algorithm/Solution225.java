package jd.cheng.leetcode.algorithm;

import static org.assertj.core.api.Assertions.*;

import java.util.LinkedList;
import java.util.Queue;
import org.junit.Test;

/**
 * @author jucheng
 * @see <a href="https://leetcode-cn.com/problems/implement-stack-using-queues/">用队列实现栈</a>
 */
public class Solution225 {

    @Test
    public void test() throws Exception {
      MyStack s = new MyStack();
      s.push(10);
      s.push(20);
      assertThat(s.pop()).isEqualTo(20);
      assertThat(s.top()).isEqualTo(10);
      assertThat(s.empty()).isFalse();
      assertThat(s.pop()).isEqualTo(10);
      assertThat(s.empty()).isTrue();
      s.push(10);
      s.push(20);
      s.push(30);
      s.push(40);
      assertThat(s.pop()).isEqualTo(40);
      assertThat(s.top()).isEqualTo(30);
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
class MyStack {

  private final Queue<Integer> queue = new LinkedList<>();

  /** Initialize your data structure here. */
  public MyStack() {

  }

  /** Push element x onto stack. */
  public void push(int x) {
    queue.offer(x);
  }

  /** Removes the element on top of the stack and returns that element. */
  public int pop() {
    if(empty()) throw new IllegalStateException("empty stack");
    for(int i=0; i<queue.size()-1; i++) {
      queue.offer(queue.poll());
    }
    return queue.poll();
  }

  /** Get the top element. */
  public int top() {
    if(empty()) throw new IllegalStateException("empty stack");

    for(int i=0; i<queue.size()-1; i++) {
      queue.offer(queue.poll());
    }

    int result = queue.poll();
    queue.offer(result);

    return result;
  }

  /** Returns whether the stack is empty. */
  public boolean empty() {
    return queue.isEmpty();
  }
}
