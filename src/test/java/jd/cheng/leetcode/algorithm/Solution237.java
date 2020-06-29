package jd.cheng.leetcode.algorithm;

import static org.assertj.core.api.Assertions.*;

import jd.cheng.leetcode.ListNode;
import org.junit.Test;

/**
 * @author jucheng
 * @see <a href="https://leetcode-cn.com/problems/delete-node-in-a-linked-list/">link</a>
 */
public class Solution237 {

  public void deleteNode(ListNode node) {
    while(node.next != null) {
      node.val = node.next.val;
      if(node.next.next == null) {
        node.next = null;
        break;
      } else {
        node = node.next;
      }
    }
  }

  @Test
  public void test() throws Exception {
    ListNode n1 = new ListNode(1);
    n1.next = new ListNode(2);
    n1.next.next = new ListNode(3);

    this.deleteNode(n1.next);
    assertThat(n1.val).isEqualTo(1);
    assertThat(n1.next.val).isEqualTo(3);
    assertThat(n1.next.next).isNull();
  }
}
