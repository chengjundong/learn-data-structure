package jd.cheng.leetcode21;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Solution {

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if(l1 == null && l2 == null) {
			return null;
		} else if(l1 == null) {
			return l2;
		} else if(l2 == null) {
			return l1;
		}
		
		if(l1.val < l2.val) {
			l1.next = mergeTwoLists(l1.next, l2);
			return l1;
		} else {
			l2.next = mergeTwoLists(l1, l2.next);
			return l2;
		}
    }
	
	@Test
	public void test() {
		
		ListNode h1 = null;
		ListNode l1 = null;
		for (int i : new int[] {5}) {
			if(l1 == null) {				
				l1 = new ListNode(i);
				h1 = l1;
			} else {				
				l1.next = new ListNode(i);
				l1 = l1.next;
			}
		}
		
		ListNode h2 = null;
		ListNode l2 = null;
		for (int i : new int[] {1,3,4}) {
			if(l2 == null) {				
				l2 = new ListNode(i);
				h2 = l2;
			} else {				
				l2.next = new ListNode(i);
				l2 = l2.next;
			}
		}
		
		ListNode listNode = new Solution().mergeTwoLists(h1, h2);
		
		for (int i : new int[] {1,3,4,5}) {
			assertEquals(i, listNode.val);
			listNode = listNode.next;
		}
	}
}
