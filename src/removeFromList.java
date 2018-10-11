/*
Given a singly linked list of integers l and an integer k, remove all elements from list l that have a value equal to k.

Example

For l = [3, 1, 2, 3, 4, 5] and k = 3, the output should be
removeKFromList(l, k) = [1, 2, 4, 5];
For l = [1, 2, 3, 4, 5, 6, 7] and k = 10, the output should be
removeKFromList(l, k) = [1, 2, 3, 4, 5, 6, 7].
*/

// Definition for singly-linked list:
// class ListNode<T> {
//   ListNode(T x) {
//     value = x;
//   }
//   T value;
//   ListNode<T> next;
// }
//
ListNode<Integer> removeKFromList(ListNode<Integer> l, int k) {

    if (l == null) {
        return l;
    }

    while (l != null && l.value == k) {
        l = l.next;
    }

    if (l != null) {
        ListNode curr = l;
        ListNode temp = curr.next;

        while (temp != null) {
            if (temp.value.equals(k)) {
                curr.next = temp.next;
                temp = curr.next;
            } else {
                temp = temp.next;
                curr = curr.next;
            }
        }
    }

    return l;

}
