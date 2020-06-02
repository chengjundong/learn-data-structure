package jd.cheng.leetcode.offer;

import static org.assertj.core.api.Assertions.*;

import java.util.Stack;
import jd.cheng.leetcode.ListNode;
import org.junit.Test;

/**
 * @author jucheng
 * @see <a href="https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof/">link</a>
 */
public class Solution24 {

  public ListNode reverseList(ListNode head) {
    if(head == null) return null;

    ListNode cur = head;
    while(head.next != null) {
      ListNode temp = head.next.next;
      head.next.next = cur;
      cur = head.next;
      head.next = temp;
    }

    return cur;
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
  }
}
