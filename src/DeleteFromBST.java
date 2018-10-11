package com.github.chen0040.codefights.trees;


/**
 * Created by xschen on 4/8/2017.
 *
 * A tree is considered a binary search tree (BST) if for each of its nodes the following is true:

 The left subtree of a node contains only nodes with keys less than the node's key.
 The right subtree of a node contains only nodes with keys greater than the node's key.
 Both the left and the right subtrees must also be binary search trees.
 Removing a value x from a BST t is done in the following way:

 If there is no x in t, nothing happens;
 Otherwise, let t' be a subtree of t such that t'.value = x.
 If t' has a left subtree, remove the rightmost node from it and put it at the root of t';
 Otherwise, remove the root of t' and its right subtree becomes the new t's root.
 For example, removing 4 from the following tree has no effect because there is no such value in the tree:

 5
 / \
 2   6
 / \   \
 1   3   8
 /
 7
 Removing 5 causes 3 (the rightmost node in left subtree) to move to the root:

 3
 / \
 2   6
 /     \
 1       8
 /
 7
 And removing 6 after that creates the following tree:

 3
 / \
 2   8
 /   /
 1   7
 You're given a binary search tree t and an array of numbers queries. Your task is to remove queries[0], queries[1], etc., from t, step by step, following the algorithm above. Return the resulting BST.

 Example

 For

 t = {
 "value": 5,
 "left": {
 "value": 2,
 "left": {
 "value": 1,
 "left": null,
 "right": null
 },
 "right": {
 "value": 3,
 "left": null,
 "right": null
 }
 },
 "right": {
 "value": 6,
 "left": null,
 "right": {
 "value": 8,
 "left": {
 "value": 7,
 "left": null,
 "right": null
 },
 "right": null
 }
 }
 }
 and queries = [4, 5, 6], the output should be

 deleteFromBST(t, queries) = {
 "value": 3,
 "left": {
 "value": 2,
 "left": {
 "value": 1,
 "left": null,
 "right": null
 },
 "right": null
 },
 "right": {
 "value": 8,
 "left": {
 "value": 7,
 "left": null,
 "right": null
 },
 "right": null
 }
 }
 Input/Output

 [time limit] 3000ms (java)
 [input] tree.integer t

 A tree of integers.

 Guaranteed constraints:
 0 ≤ t size ≤ 1000,
 -109 ≤ node value ≤ 109.

 [input] array.integer queries

 An array that contains the numbers to be deleted from t.

 Guaranteed constraints:
 1 ≤ queries.length ≤ 1000,
 -109 ≤ queries[i] ≤ 109.

 [output] tree.integer

 The tree after removing all the numbers in queries, following the algorithm above.


 */
public class DeleteFromBST {
    class Tree<T> {
      Tree(T x) {
        value = x;
      }
      T value;
      Tree<T> left;
      Tree<T> right;
    }
   Tree<Integer> deleteFromBST(Tree<Integer> t, int[] queries) {
      for(int i=0; i < queries.length; ++i) {
         t = deleteFromBST2(t, queries[i]);
      }
      return t;
   }

   Tree<Integer> min(Tree<Integer> x){
      while(x.left != null) {
         x = x.left;
      }
      return x;
   }

   Tree<Integer> max(Tree<Integer> x){
      while(x.right != null) {
         x = x.right;
      }
      return x;
   }

   Tree<Integer> delMin(Tree<Integer> x) {
      if(x.left == null) {
         return x.right;
      }
      x.left = delMin(x.left);
      return x;
   }

   Tree<Integer> delMax(Tree<Integer> x) {
      if(x.right == null) {
         return x.left;
      }
      x.right = delMax(x.right);
      return x;
   }

   Tree<Integer> deleteFromBST2(Tree<Integer> t, int key) {
      if(t == null) {
         return null;
      }
      if(t.value == key) {
         if(t.left == null) {
            return t.right;
         } else {
            Tree<Integer> m = max(t.left);
            m.left = delMax(t.left);
            m.right = t.right;
            return m;
         }
      } else {
         t.left = deleteFromBST2(t.left, key);
         t.right = deleteFromBST2(t.right, key);
      }

      return t;
   }





}
