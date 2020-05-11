package jd.cheng.leetcode.algorithm;

import static org.assertj.core.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;
import org.junit.Test;

/**
 * @author jucheng
 * @see <a href="https://leetcode-cn.com/problems/linked-list-cycle/">linked list cycle</a>
 */
public class Solution141 {

  public boolean hasCycle(ListNode head) {

    Set<ListNode> set = new HashSet<>();

    ListNode node = head;

    while(node != null) {
      if(set.contains(node)) {
        return true;
      } else {
        set.add(node);
        node = node.next;
      }
    }

    return false;
  }

  @Test
  public void test() throws Exception {
    ListNode n1 = buildListNode(new int[]{3, 2, 0, -4}, 1);
    assertThat(hasCycle(n1)).isTrue();
  }

  private ListNode buildListNode(int[] vals, int pos) {
    ListNode node = new ListNode(vals[0]);

    ListNode x = node;
    for(int i=1; i < vals.length; i++) {
      x.next = new ListNode(vals[i]);
      x = x.next;
    }

    // x is the end, link back if pos >= 0
    if(pos >= 0) {
      ListNode y = node;
      for(int i=0; i <= pos; i++) {
        y = node.next;
      }
      x.next = y;
    }

    return node;
  }
}
