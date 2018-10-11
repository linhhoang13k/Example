package codefights.linkedlist;

/*
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * 
 * k = length of sub-arrays to flip over.
 * k >= 1
 * 
 * 
 *  
 * return new list
 * 
 * Given a linked list l, reverse its nodes k at a time and return the modified list. k is a positive integer that is less than or equal to 
 * the length of l. 
 * If the number of nodes in the linked list is not a multiple of k, then the nodes that are left out at the end should remain as-is.
 * 
 * 
 * IE [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11]  where k = 3 -> [3, 2, 1, 6, 5, 4, 9, 8, 7, 10, 11]
 * or 
 * ++++++++++++++++++++++++++++++++
 * l: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12] 
 * k: 4
 * [4, 3, 2, 1, 8, 7, 6, 5, 12, 11, 10, 9]
 */

public class CopyListNode {

	public static void main(String[] args) {
		ListNode<Integer> a = new ListNode<Integer>(1);
		ListNode<Integer> a2 = new ListNode<Integer>(2);
		ListNode<Integer> a3 = new ListNode<Integer>(3);
		ListNode<Integer> a4 = new ListNode<Integer>(4);
		ListNode<Integer> a5 = new ListNode<Integer>(5);
		ListNode<Integer> a6 = new ListNode<Integer>(6);
		ListNode<Integer> a7 = new ListNode<Integer>(7);
		ListNode<Integer> a8 = new ListNode<Integer>(8);
		ListNode<Integer> a9 = new ListNode<Integer>(9);
		a.next = a2;
		a2.next = a3;
		a3.next = a4;
		a4.next = a5;
		a5.next = a6;
		a6.next = a7;
		a7.next = a8;
		a8.next = a9;

		// a.printListNodes(a);

		ReverseNodesInKGroups s = new ReverseNodesInKGroups();
		ListNode<Integer> reservedList = s.reverseNodesInKGroups(a, 3);

		ListNode.printListNodes(reservedList);

	}

	ListNode<Integer> reverseNodesInKGroups(ListNode<Integer> l, int k) {
		
		ListNode<Integer> returnHead = null;
		ListNode<Integer> previousNode = null;
		while (l != null) {

			//create new node
			ListNode<Integer> newNode = new ListNode<Integer>(l.value);

			//attach to previous node if it exists
			if (previousNode != null) {
				previousNode.next = newNode;
			}
			
			//set return head only once
			if (returnHead == null) {
				returnHead = newNode;
			}
			
			//iterate
			previousNode = newNode;
			l = l.next;
		}
			
		return returnHead;
	}

}
