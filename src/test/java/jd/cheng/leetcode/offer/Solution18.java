package jd.cheng.leetcode.offer;

import static org.assertj.core.api.Assertions.*;

import jd.cheng.leetcode.ListNode;
import org.junit.Test;

/**
 * @author jucheng
 */
public class Solution18 {

  public ListNode deleteNode(ListNode head, int val) {
    if(head == null) {
      return null;
    } else if(head.val == val) {
      return head.next;
    } else {
      head.next = this.deleteNode(head.next, val);
      return head;
    }
  }

  @Test
  public void test() throws Exception {
    ListNode n = new ListNode(4);
    n.next = new ListNode(1);
    n.next.next = new ListNode(5);
    n.next.next.next = new ListNode(9);

    ListNode result = this.deleteNode(n, 5);

    assertThat(result.val).isEqualTo(4);
    assertThat(result.next.val).isEqualTo(1);
    assertThat(result.next.next.val).isEqualTo(9);
  }
}
