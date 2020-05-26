package jd.cheng.leetcode.algorithm;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.Stack;
import org.junit.Test;

/**
 * @author jucheng
 * @see <a href="https://leetcode-cn.com/problems/reverse-linked-list/">反转链表</a>
 */
public class Solution206 {

  public ListNode reverseList(ListNode head) {
    ListNode prev = null;
    ListNode cur = head;

    while(cur != null) {
      ListNode temp = cur.next;
      cur.next = prev;
      prev = cur;
      cur = temp;
    }

    return prev;
  }

  @Test
  public void test() throws Exception {
    ListNode n = new ListNode(1);
    n.next = new ListNode(2);
    n.next.next = new ListNode(3);

    ListNode r = this.reverseList(n);
    assertThat(r.val).isEqualTo(3);
    assertThat(r.next.val).isEqualTo(2);
    assertThat(r.next.next.val).isEqualTo(1);
    assertThat(r.next.next.next).isNull();
  }
}
