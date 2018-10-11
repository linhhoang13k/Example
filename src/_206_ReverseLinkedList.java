package Easy;

import java.util.Stack;

/**
 * Created by Trung on 10/13/2017.
 */
public class _206_ReverseLinkedList {

    public static void main(String...args) {
        int[] data = {1, 2, 3, 4};
        int index = 1;
        ListNode head = new ListNode(data[0]);
        ListNode curr = head;
        while (index < data.length) {
            curr.next = new ListNode(data[index]);
            index++;
            curr = curr.next;
        }
        System.out.println(printList(reverse(head)));
    }
	
	//Alternative version with time O(n) and space O(n).
	
	/* public static ListNode reverse(ListNode head) {
		Stack<Integer> stack = new Stack<>();
		ListNode curr = head;
		while (curr != null) {
			stack.push(curr.val);
			curr = curr.next;
		}
        ListNode newHead = new ListNode(0);
        curr = newHead;
        while (!stack.isEmpty()) {
            curr.next = new ListNode(stack.pop());
            curr = curr.next;
        }
        return newHead.next;
	} */

	//Runtime: O(n) Space: O(1)
    public static ListNode reverse(ListNode head) {
        ListNode curr = head;
        ListNode next;
        ListNode prev = null;
        while (curr != null) {
            next = curr.next;       //preserve the next node in the list.
            curr.next = prev;       //reserve. if head > point to null
            prev = curr;            //current node is done > become previous node
            curr = next;            //move to next node.
        }
        return prev;
    }

    private static class ListNode {
            int data;
            ListNode next;
            ListNode(int x) {data = x;}
            public int getData() {
                return data;
            }
    }

    private static String printList(ListNode list) {
        StringBuilder sb = new StringBuilder();
        ListNode curr = list;
        while (curr != null) {
            sb.append(curr.getData() + " ");
            curr = curr.next;
        }
        return sb.toString();
    }
	
	
	
}
