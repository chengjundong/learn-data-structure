package jd.cheng.leetcode.offer;

import static org.assertj.core.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;
import jd.cheng.leetcode.ListNode;
import org.junit.Test;

/**
 * @author jucheng
 * @see <a href="https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/"></a>
 */
public class Solution22 {

  public ListNode getKthFromEnd(ListNode head, int k) {
    ListNode former = head, later = head;

    for(int i=0; i<k; i++) {
      former = former.next;
    }

    while(former != null) {
      former = former.next;
      later = later.next;
    }

    return later;
  }

  @Test
  public void test() throws Exception {
    ListNode n = new ListNode(1);
    n.next = new ListNode(2);
    n.next.next = new ListNode(3);
    n.next.next.next = new ListNode(4);
    n.next.next.next.next = new ListNode(5);

    ListNode result = this.getKthFromEnd(n, 2);
    assertThat(result.val).isEqualTo(4);
    assertThat(result.next.val).isEqualTo(5);
  }
}
