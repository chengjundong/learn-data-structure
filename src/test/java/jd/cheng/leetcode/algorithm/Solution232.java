package jd.cheng.leetcode.algorithm;

import static org.assertj.core.api.Assertions.*;

import java.util.Stack;
import org.junit.Test;

/**
 * @author jucheng
 * @see <a href="https://leetcode-cn.com/problems/implement-queue-using-stacks/">link</a>
 */
public class Solution232 {

  @Test
  public void test() throws Exception {
   MyQueue obj = new MyQueue();
   obj.push(1);
   obj.push(2);
   obj.push(3);
   assertThat(obj.pop()).isEqualTo(1);
   assertThat(obj.peek()).isEqualTo(2);
   assertThat(obj.empty()).isFalse();

    MyQueue q1 = new MyQueue();
    assertThat(q1.empty()).isTrue();
  }
}

class MyQueue {

  private final Stack<Integer> s1 = new Stack<>();
  private final Stack<Integer> s2 = new Stack<>();

  /** Initialize your data structure here. */
  public MyQueue() {

  }

  /** Push element x to the back of queue. */
  public void push(int x) {
    s1.push(x);
  }

  /** Removes the element from in front of queue and returns that element. */
  public int pop() {
    if(s1.isEmpty()) return 0;
    int result = 0;

    // dump all from s1
    while(!s1.isEmpty()) {
      s2.push(s1.pop());
    }
    // dequeue
    result = s2.pop();
    // put the rest back to s1
    while(!s2.isEmpty()) {
      s1.push(s2.pop());
    }

    return result;
  }

  /** Get the front element. */
  public int peek() {
    if(s1.isEmpty()) return 0;
    int result = 0;

    // dump all from s1
    while(!s1.isEmpty()) {
      s2.push(s1.pop());
    }
    // peek
    result = s2.peek();
    // put the rest back to s1
    while(!s2.isEmpty()) {
      s1.push(s2.pop());
    }

    return result;
  }

  /** Returns whether the queue is empty. */
  public boolean empty() {
    return s1.isEmpty();
  }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
