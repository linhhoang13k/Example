package com.github.chen0040.codefights.trees;


/**
 * Created by xschen on 4/8/2017.
 *
 * Note: Your solution should have only one BST traversal and O(1) extra space complexity, since this is what you will be asked to accomplish in an interview.

 A tree is considered a binary search tree (BST) if for each of its nodes the following is true:

 The left subtree of a node contains only nodes with keys less than the node's key.
 The right subtree of a node contains only nodes with keys greater than the node's key.
 Both the left and the right subtrees must also be binary search trees.
 Given a binary search tree t, find the kth largest element in it.

 Note that kth largest element means kth element in increasing order. See examples for better understanding.

 Example

 For

 t = {
 "value": 3,
 "left": {
 "value": 1,
 "left": null,
 "right": null
 },
 "right": {
 "value": 5,
 "left": {
 "value": 4,
 "left": null,
 "right": null
 },
 "right": {
 "value": 6,
 "left": null,
 "right": null
 }
 }
 }
 and k = 2, the output should be
 kthLargestInBST(t, k) = 3.

 Here is what t looks like:

 3
 /   \
 1     5
 / \
 4   6
 The values of t are [1, 3, 4, 5, 6], and the 2nd element when the values are in sorted order is 3.

 For

 t = {
 "value": 1,
 "left": {
 "value": -1,
 "left": {
 "value": -2,
 "left": null,
 "right": null
 },
 "right": {
 "value": 0,
 "left": null,
 "right": null
 }
 },
 "right": null
 }

 and k = 1, the output should be
 kthLargestInBST(t, k) = -2.

 Here is what t looks like:

 1
 /
 -1
 / \
 -2   0
 The values of t are [-2, -1, 0, 1], and the 1st largest is -2.

 Input/Output

 [time limit] 3000ms (java)
 [input] tree.integer t

 A tree of integers. It is guaranteed that t is a BST.

 Guaranteed constraints:
 1 ≤ tree size ≤ 104,
 -105 ≤ node value ≤ 105.

 [input] integer k

 An integer.

 Guaranteed constraints:
 1 ≤ k ≤ tree size.

 [output] integer

 The kth largest value in t.
 */
public class KLargestInBST {
   public class Solution {
       class Tree<T> {
         Tree(T x) {
           value = x;
         }
         T value;
         Tree<T> left;
         Tree<T> right;
       }
      int d = 0;
      int selected = Integer.MIN_VALUE;
      int kthLargestInBST(Tree<Integer> t, int k) {
         d = 0;
         traverse(t, k);
         return selected;
      }

      void traverse(Tree<Integer> x, int k) {
         if(x == null) {
            return;
         }

         traverse(x.left, k);
         if(d == k - 1 && selected == Integer.MIN_VALUE) {
            selected = x.value;
            return;
         }

         d++;
         traverse(x.right, k);
      }

   }
}
