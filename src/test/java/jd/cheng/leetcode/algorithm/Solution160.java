package jd.cheng.leetcode.algorithm;

import static org.assertj.core.api.Assertions.*;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.junit.Test;

/**
 * @author jucheng
 * @see <a href="https://leetcode-cn.com/problems/intersection-of-two-linked-lists/">intersection of two linked lists</a>
 */
public class Solution160 {

  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    ListNode x = headA;
    ListNode y = headB;

    List<ListNode> l1 = new LinkedList<>();
    while(x != null) {
      l1.add(0, x);
      x = x.next;
    }

    List<ListNode> l2 = new LinkedList<>();
    while(y != null) {
      l2.add(0, y);
      y = y.next;
    }

    ListNode result = null;
    Iterator<ListNode> i1 = l1.iterator();
    Iterator<ListNode> i2 = l2.iterator();

    while(i1.hasNext() && i2.hasNext()) {
      ListNode n1 = i1.next();
      ListNode n2 = i2.next();
      if(n1== n2) {
        result = n1;
      } else {
        break;
      }
    }

    return result;
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
