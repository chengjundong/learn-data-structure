package jd.cheng.leetcode.offer;

import static org.assertj.core.api.Assertions.*;

import jd.cheng.leetcode.ListNode;
import org.junit.Test;

/**
 * @author jucheng
 * @see <a href="https://leetcode-cn.com/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof/">link</a>
 */
public class Solution25 {

  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

    if(l1 == null) {
      return l2;
    } else if(l2 == null) {
      return l1;
    }

    ListNode result = null;
    if(l1.val < l2.val) {
      result = l1;
      result.next = mergeTwoLists(l1.next, l2);
    } else {
      result = l2;
      result.next = mergeTwoLists(l1, l2.next);
    }

    return result;
  }

  @Test
  public void test() throws Exception {
    ListNode n1 = new ListNode(1);
    n1.next = new ListNode(2);
    n1.next.next = new ListNode(3);

    ListNode n2 = new ListNode(1);
    n2.next = new ListNode(2);
    n2.next.next = new ListNode(4);
    n2.next.next.next = new ListNode(5);
    n2.next.next.next.next = new ListNode(6);

    ListNode m = this.mergeTwoLists(n1, n2);
    assertThat(m.val).isEqualTo(1);
    assertThat(m.next.val).isEqualTo(1);
    assertThat(m.next.next.val).isEqualTo(2);
    assertThat(m.next.next.next.val).isEqualTo(2);
    assertThat(m.next.next.next.next.val).isEqualTo(3);
    assertThat(m.next.next.next.next.next.val).isEqualTo(4);
    assertThat(m.next.next.next.next.next.next.val).isEqualTo(5);
    assertThat(m.next.next.next.next.next.next.next.val).isEqualTo(6);
  }
}