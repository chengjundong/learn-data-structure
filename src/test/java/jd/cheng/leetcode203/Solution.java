package jd.cheng.leetcode203;

public class Solution {

	public ListNode removeElements(ListNode head, int val) {
		// no head, empty list
		if(head == null) {
			return null;
		}
		
		ListNode result = null;
		ListNode current = null;
		
		for(ListNode n = head; n != null; n = n.next) {
			if(n.val != val) {
				if(result == null) {
					result = new ListNode(n.val);
					current = result;
				} else {
					current.next = new ListNode(n.val);
					current = current.next;
				}
			}
		}
		
		return result;
	}
	
	// 输入: 1->2->6->3->4->5->6, val = 6
	// 输出: 1->2->3->4->5
	public static void main(String[] args) {
		// create a linked list
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		n1.next = n2;
		ListNode n3 = new ListNode(6);
		n2.next = n3;
		ListNode n4 = new ListNode(3);
		n3.next = n4;
		ListNode n5 = new ListNode(4);
		n4.next = n5;
		ListNode n6 = new ListNode(5);
		n5.next = n6;
		ListNode n7 = new ListNode(6);
		n6.next = n7;
		
//		ListNode n1 = new ListNode(6);
//		ListNode n2 = new ListNode(6);
//		n1.next = n2;
		
		// try remove
		ListNode r1 = new Solution().removeElements(n1, 6);
		
		// print
		for(ListNode n = r1; n != null; n = n.next) {
			System.out.print(n.val+",");
		}
	}
}
