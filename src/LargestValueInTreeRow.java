package com.github.chen0040.codefights.depthfirst;


import java.util.HashMap;
import java.util.Map;


/**
 * Created by xschen on 4/8/2017.
 *
 * You have a binary tree t. Your task is to find the largest value in each row of this tree. In a tree, a row is a set of nodes that have equal depth. For example, a row with depth 0 is a tree root, a row with depth 1 is composed of the root's children, etc.

 Return an array in which the first element is the largest value in the row with depth 0, the second element is the largest value in the row with depth 1, the third element is the largest element in the row with depth 2, etc.

 Example

 For

 t = {
 "value": -1,
 "left": {
 "value": 5,
 "left": null,
 "right": null
 },
 "right": {
 "value": 7,
 "left": null,
 "right": {
 "value": 1,
 "left": null,
 "right": null
 }
 }
 }
 the output should be largestValuesInTreeRows(t) = [-1, 7, 1].

 The tree in the example looks like this:

 -1
 / \
 5   7
 \
 1
 In the row with depth 0, there is only one vertex - the root with value -1;
 In the row with depth 1, there are two vertices with values 5 and 7, so the largest value here is 7;
 In the row with depth 2, there is only one vertex with value 1.
 Input/Output

 [time limit] 3000ms (java)
 [input] tree.integer t

 A binary tree of integers.

 Guaranteed constraints:
 0 ≤ tree size ≤ 5 · 104,
 -1000 ≤ node value ≤ 1000.

 [output] array.integer

 An array of the largest values in each row of t.
 */
public class LargestValueInTreeRow {
   class Tree<T> {
      Tree(T x) {
        value = x;
      }
      T value;
      Tree<T> left;
      Tree<T> right;
    }
   int[] largestValuesInTreeRows(Tree<Integer> t) {
      Map<Integer, Integer> levels = new HashMap<Integer, Integer>();
      int depth = find(t, levels, 0);
      int[] result = new int[depth];
      for(int i=0; i < depth; ++i) {
         result[i] = levels.get(i);
      }
      return result;
   }

   int find(Tree<Integer> x, Map<Integer, Integer> levels, int d) {
      if(x == null) {
         return d;
      }
      if(levels.containsKey(d)) {
         levels.put(d, Math.max(levels.get(d), x.value));
      } else {
         levels.put(d, x.value);
      }

      int depth_left = find(x.left, levels, d+1);
      int depth_right = find(x.right, levels, d+1);

      return Math.max(depth_left, depth_right);
   }

}
