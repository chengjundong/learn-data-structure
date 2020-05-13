package jd.cheng.leetcode.algorithm;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;

/**
 * @author jucheng
 * @see <a href="https://leetcode-cn.com/problems/min-stack/">min stack</a>
 */
public class Solution155 {

  @Test
  public void test() throws Exception {
    MinStack stack = new MinStack();
    stack.push(1);
    stack.push(2);
    stack.push(-1);
    stack.push(3);
    assertThat(stack.getMin()).isEqualTo(-1);
    stack.pop();
    stack.pop();
    assertThat(stack.getMin()).isEqualTo(1);
    assertThat(stack.top()).isEqualTo(2);
  }
}

class MinStack {

  // two-directions linked list
  private static class Node {
    int val;
    Node prev;
    Node next;

    public Node(int val) {
      this.val = val;
    }
  }

  private Node head;
  private Node tail;
  private int size;

  /** initialize your data structure here. */
  public MinStack() {

  }

  public void push(int x) {
    Node n = new Node(x);

    // if no head, use it as head
    if(head == null) {
      head = n;
    }

    // link the node
    if(tail != null) {
      n.prev = tail;
      tail.next = n;
    }
    // use the input as the new tail
    tail = n;
    size++;
  }

  public void pop() {
    if(0 == size) throw new UnsupportedOperationException("stack is empty!");

    if(head == tail) {
      head = null;
      tail = null;
    } else {
      Node nextTail = tail.prev;
      tail.prev = null;
      nextTail.next = null;
      tail = nextTail;
    }
    size--;
  }

  public int top() {
    if(0 == size) {
      throw new UnsupportedOperationException("stack is empty!");
    } else {
      return tail.val;
    }
  }

  public int getMin() {
    if(0 == size) throw new UnsupportedOperationException("stack is empty!");

    Node n = head;
    Integer result = n.val;
    while(n != null) {
      if(result > n.val) {
        result = n.val;
      }
      n = n.next;
    }
    return result;
  }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
