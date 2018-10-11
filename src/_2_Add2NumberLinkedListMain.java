package Medium._2_Add2NumberLinkedList; /**
 * Created by Trung on 3/17/2017.
 */

/**
 * Problem statement:
 * Given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and
 * each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * Assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Solution:
 *  - Sum the integer in each node as we go
 *  - If there is carry, save that and add it to the sum.
 *  - If the sum result in a number less than 10, reset the carry to 0.
 *  - If there is carry after exhausting one of the list, append 1.
 *
 */
public class _2_Add2NumberLinkedListMain {

    public static _2_ListNode addTwoNumbers(final _2_ListNode l1, final _2_ListNode l2) {
        _2_ListNode first = l1, second = l2;
        StringBuilder result = new StringBuilder();
        int carry = 0;
        while (first != null && second != null) {
            int sum = first.val + second.val + carry;
            if (sum > 9) {
                carry  = sum / 10;
                sum = sum % 10;
            } else {
                carry = 0;
            }
            result.append(sum);
            first = first.next;
            second = second.next;
        }
        _2_ListNode remain = first == null ? second : first;
        while (remain != null) {
            int sum = remain.val + carry;
            if (sum > 9) {
                carry  = sum / 10;
                sum = sum % 10;
            } else {
                carry = 0;
            }
            result.append(sum);
            remain = remain.next;

        }
        if (carry != 0) {
            result.append(1);
        }
        //Result is a string in order exactly as desired. So just need to construct a linked list out of it.
        return linkedListConstruct(result, 0);

    }
    /**
     * Recursively construct a linked list from given string from the specified non negative length (index).
     *
     * @param s the string
     * @param index the position to start constructing.
     * @return the new linked list
     */
    private static _2_ListNode linkedListConstruct(final StringBuilder s, int index) {
        _2_ListNode head = null;
            if (s.length() != 0 && index < s.length()) {
                    try {
                        head = new _2_ListNode(Integer.parseInt(s.substring(index, index + 1)));
                    } catch (NumberFormatException e) {
                        return head;
                    }
                    head.next = linkedListConstruct(s, ++index);
             }
         return head;
    }
    public static void main(String... args) {
        int a = 1000000000 * 9;
        _2_ListNode l1 = linkedListConstruct(new StringBuilder("98"), 0);
        _2_ListNode l2 = linkedListConstruct(new StringBuilder("1"), 0);
        _2_ListNode ans = addTwoNumbers(l1, l2);

    }

}
