package jd.cheng.leetcode.algorithm;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.StringJoiner;
import jd.cheng.leetcode.ListNode;
import org.junit.Test;

/**
 * @author jucheng
 * @see <a href="https://leetcode-cn.com/problems/palindrome-linked-list/">link</a>
 */
public class Solution234 {

  public boolean isPalindrome(ListNode head) {
    if(head == null || head.next == null) return true;
    // 2-size list
    if(head.next.next == null) {
        return head.val == head.next.val;
    }

    ListNode mid = this.findMind(head);
    ListNode second = this.reverse(mid);

    boolean result = true;

    while(second != null) {
      if(head.val != second.val) return false;
      head = head.next;
      second = second.next;
    }

    return result;
  }

  private ListNode reverse(ListNode n) {
    ListNode x = n;
    ListNode y = n.next;

    while(y != null) {
      n.next = y.next;
      y.next = x;
      if(n.next != null) {
        x = y;
        y = n.next;
      } else {
        break;
      }
    }
    n.next = null;

    return y;
  }

  private ListNode findMind(ListNode n) {
    ListNode fast = n.next.next;
    ListNode slow = n.next;

    while(fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;
    }

    return slow;
  }

  @Test
  public void test() throws Exception {
    ListNode n1 = new ListNode(1);
    n1.next = new ListNode(2);
    n1.next.next = new ListNode(3);
    n1.next.next.next = new ListNode(4);
    n1.next.next.next.next = new ListNode(5);

    assertThat(this.isPalindrome(n1)).isFalse();

    ListNode n2 = new ListNode(1);
    n2.next = new ListNode(2);
    n2.next.next = new ListNode(3);
    n2.next.next.next = new ListNode(2);
    n2.next.next.next.next = new ListNode(1);

    assertThat(this.isPalindrome(n2)).isTrue();

    ListNode n3 = new ListNode(1);
    n3.next = new ListNode(2);
    n3.next.next = new ListNode(2);
    n3.next.next.next = new ListNode(1);

    assertThat(this.isPalindrome(n3)).isTrue();

    ListNode n4 = new ListNode(1);
    n4.next = new ListNode(2);

    assertThat(this.isPalindrome(n4)).isFalse();
  }
}
