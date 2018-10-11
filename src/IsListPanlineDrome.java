package com.github.chen0040.codefights.linklists;


/**
 * Created by xschen on 3/8/2017.
 *
 * Note: Try to solve this task in O(n) time using O(1) additional space, where n is the number of elements in l, since this is what you'll be asked to do during an interview.

 Given a singly linked list of integers, determine whether or not it's a palindrome.

 Example

 For l = [0, 1, 0], the output should be
 isListPalindrome(l) = true;
 For l = [1, 2, 2, 3], the output should be
 isListPalindrome(l) = false.
 Input/Output

 [time limit] 3000ms (java)
 [input] linkedlist.integer l

 A singly linked list of integers.

 Guaranteed constraints:
 0 ≤ list size ≤ 5 · 105,
 -109 ≤ element value ≤ 109.

 [output] boolean

 Return true if l is a palindrome, otherwise return false.
 */
public class IsListPanlineDrome {
   public class Solution {
       class ListNode<T> {
         ListNode(T x) {
           value = x;
         }
         T value;
         ListNode<T> next;
       }

      boolean isListPalindrome(ListNode<Integer> l) {
         ListNode<Integer> x = l;

         ListNode<Integer> head = null;
         int index = 0;
         while(x != null) {

            ListNode<Integer> old = head;
            head = new ListNode<Integer>(x.value);
            head.next = old;

            x = x.next;
            index++;
         }

         ListNode<Integer> x2 = head;
         int index2 = 0;
         x = l;
         while(x != null) {
            if(index2 > index / 2) break;
            if(x.value.intValue() != x2.value.intValue()) {
               return false;
            }
            x = x.next;
            x2 = x2.next;
            index2++;
         }
         return true;
      }

   }
}
