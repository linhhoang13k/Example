



package Easy._21_MergeTwoSortedLists;
/**
 * Created by Trung on 4/1/2017.
 */

/**
 * Problem Statement:
 *      <p>Given two sorted linked lists, merge them in correct order.</p>
 *
 * <p>Solution:
 *      <p> Own:
 *          - Insert each node into new linked list one at a time.
 *          - Insert the remaining nodes of either given lists to the new list.</p>
 *          Optimal (at bottom)
 *          - Recursively merge.</p>
 * </p>
 */
public class _21_MergeTwoSortedListsMain {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode itr1 = l1, itr2 = l2, dummy = new ListNode(0), back = dummy.next;
        while (itr1 != null && itr2 != null) {
            int a = itr1.val, b = itr2.val;
            dummy = insert(a, dummy);
            dummy = insert(b, dummy);
            itr1 = itr1.next;
            itr2 = itr2.next;
        }
        ListNode remain = (itr1 == null) ? itr2 : itr1;
        while (remain != null) {
            dummy = insert(remain.val, dummy);
            remain = remain.next;
        }
        dummy = dummy.next; //Remove the dummy node from the beginning of this method
       return dummy;
    }

    private static ListNode insert(int number, ListNode dummy) {
        ListNode curr = dummy;
        if (curr == null) return new ListNode(number);
        while (curr.next != null && curr.next.val < number) {
            curr = curr.next;
        }
        //At this point, curr points to the node that has value greater than number
        ListNode newNode = new ListNode(number);
        newNode.next = curr.next;
        curr.next = newNode;
        return dummy;
    }

    /**
     * Recursively construct a linked list from given aray from the specified non negative length (index).
     *
     * @param data the array
     * @return the new linked list
     */
    private static ListNode linkedListConstruct(final int[] data) {
        ListNode head = new ListNode(0);
        ListNode curr = head;
        int index = 0;
        while (index < data.length) {
            curr.next = new ListNode(data[index]);
            index++;
            curr = curr.next;
        }
        head = head.next;
        return head;
    }



    public static void main(String...args) {
        ListNode l1 = linkedListConstruct(new int[]{0, 1});
        ListNode l2 = linkedListConstruct(new int[]{2});
        ListNode ans = mergeTwoLists(l1, l2);
        printList(ans);

    }


    private static void printList(ListNode ans) {
        ListNode curr = ans;
        while (curr != null) {
            System.out.print(curr.val + "->");
            curr = curr.next;
        }
    }

    /**
     * One of many optimal solution. elegant
     *
     * KEY: recursively merge the two list.
     *
     *
     */
    ListNode _solution_mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;

        if(l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l2.next, l1);
            return l2;
        }
    }

}
