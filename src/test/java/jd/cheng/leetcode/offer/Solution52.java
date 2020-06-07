package jd.cheng.leetcode.offer;

import static org.assertj.core.api.Assertions.*;

import jd.cheng.leetcode.ListNode;
import org.junit.Test;

/**
 * @author jucheng
 * @see <a href="https://leetcode-cn.com/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof/">link</a>
 */
public class Solution52 {

  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    ListNode p1 = headA;
    ListNode p2 = headB;
    boolean p1Changed = false;
    boolean p2Changed = false;
    boolean found = false;

    while (p1 != null && p2 != null) {
      if (p1 == p2) {
        found = true;
        break;
      }

      p1 = p1.next;
      if (p1 == null && !p1Changed) {
        p1 = headB;
        p1Changed = true;
      }

      p2 = p2.next;
      if (p2 == null && !p2Changed) {
        p2 = headA;
        p2Changed = true;
      }
    }

    return found ? p1 : null;
  }

  @Test
  public void test() throws Exception {
    ListNode n = new ListNode(3);
    n.next = new ListNode(4);

    ListNode n1 = new ListNode(1);
    n1.next = new ListNode(2);
    n1.next.next = n;

    ListNode n2 = new ListNode(1);
    n2.next = n;

    assertThat(this.getIntersectionNode(n1, n2)).isEqualTo(n);

    ListNode n3 = new ListNode(1);
    n3.next = new ListNode(2);

    assertThat(this.getIntersectionNode(n1, n3)).isNull();
    assertThat(this.getIntersectionNode(n1, null)).isNull();
  }
}
