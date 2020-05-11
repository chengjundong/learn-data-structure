package jd.cheng.leetcode.algorithm;

import java.util.StringJoiner;

import org.junit.Test;

/**
 * 
 * @author jucheng
 * @see <a href="https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/">remove duplicates from sorted list</a>
 *
 */
public class Solution83 {

	public ListNode deleteDuplicates(ListNode head) {
		ListNode n = head;
		
		while(null != head) {
			ListNode next = n.next;
			if(next == null) {
				break;
			} else if(n.val == next.val) {
				// remove next
				n.next = next.next;
				next.next = null;
			} else {
				n = n.next;
			}
			
			if(n == null || n.next == null) {
				break;
			}
		}
		
		return head;
	}
	
	@Test
	public void test() {
		ListNode n = new ListNode(1);
		n.next = new ListNode(1);
		n.next.next = new ListNode(1);
		n.next.next.next = new ListNode(3); 
		n.next.next.next.next = new ListNode(3);
		
		ListNode nn = this.deleteDuplicates(n);
		
		StringJoiner sj = new StringJoiner(",");
		while(nn != null) {
			sj.add(String.valueOf(nn.val));
			nn = nn.next;
		}
		System.out.println(sj.toString());
	}
}
