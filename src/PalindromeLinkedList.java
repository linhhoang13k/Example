/**
Given a singly linked list, determine if it is a palindrome.

Example 1:

Input: 1->2
Output: false
Example 2:

Input: 1->2->2->1
Output: true

 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        
        Stack<Integer> stack = new Stack<>();
        
        while(fast != null && fast.next != null){
            stack.push(slow.val);
            slow = slow.next;
            fast = fast.next.next;
        }
        
        if(fast != null){
            slow = slow.next;
        }
        
        while(slow != null){
            int top = stack.pop();
            if(top != slow.val){
                return false;
            }
            slow = slow.next;
        }
        return true;
    }
}