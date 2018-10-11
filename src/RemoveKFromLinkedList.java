package com.github.chen0040.codefights.linklists;


/**
 * Created by xschen on 3/8/2017.
 *
 * Note: Try to solve this task in O(n) time using O(1) additional space, where n is the number of elements in the list, since this is what you'll be asked to do during an interview.

 Given a singly linked list of integers l and an integer k, remove all elements from list l that have a value equal to k.

 Example

 For l = [3, 1, 2, 3, 4, 5] and k = 3, the output should be
 removeKFromList(l, k) = [1, 2, 4, 5];
 For l = [1, 2, 3, 4, 5, 6, 7] and k = 10, the output should be
 removeKFromList(l, k) = [1, 2, 3, 4, 5, 6, 7].
 Input/Output

 [time limit] 3000ms (java)
 [input] linkedlist.integer l

 A singly linked list of integers.

 Guaranteed constraints:
 0 ≤ list size ≤ 105,
 -1000 ≤ element value ≤ 1000.

 [input] integer k

 An integer.

 Guaranteed constraints:
 -1000 ≤ k ≤ 1000.

 [output] linkedlist.integer

 Return l with all the values equal to k removed.
 */
public class RemoveKFromLinkedList {
   public class Solution {

       class ListNode<T> {
         ListNode(T x) {
           value = x;
         }
         T value;
         ListNode<T> next;
       }

      ListNode<Integer> removeKFromList(ListNode<Integer> l, int k) {
         ListNode<Integer> x = l;
         ListNode<Integer> prev = null;
         while(x != null) {
            ListNode<Integer> x_next = x.next;
            if(x.value == k) {
               if(prev != null) {
                  prev.next = x_next;
               } else {
                  l = x_next;
               }
            } else {
               prev = x;
            }
            x = x_next;
         }

         return l;
      }

   }
}
