package jd.cheng.leetcode.algorithm;

import static org.assertj.core.api.Assertions.*;

import jd.cheng.leetcode.ListNode;
import org.junit.Test;

/**
 * @author jucheng
 * @see <a href="https://leetcode-cn.com/problems/intersection-of-two-linked-lists/">intersection of two linked lists</a>
 */
public class Solution160 {

  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    if(headA == null || headB == null) {
      return null;
    }

    ListNode pA = headA;
    ListNode pB = headB;

    for(;pA != pB;) {
      pA = pA == null ? headB : pA.next;
      pB = pB == null ? headA : pB.next;
    }

    return pA;
  }

  @Test
  public void test() throws Exception {
    ListNode n01 = new ListNode(0);
    n01.next = new ListNode(1);
    ListNode n02 = new ListNode(3);
    n02.next = n01.next;

    assertThat(this.getIntersectionNode(n01, n02)).isNotNull().extracting(n -> n.val).isEqualTo(1);

    ListNode n11 = new ListNode(0);
    n01.next = new ListNode(4);
    ListNode n12 = new ListNode(3);
    n02.next = new ListNode(1);

    assertThat(this.getIntersectionNode(n01, n02)).isNull();
  }
}
