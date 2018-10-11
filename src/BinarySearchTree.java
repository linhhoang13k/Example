package HackerRank;

import java.util.HashSet;
import java.util.Set;

/**
 * Problem description: https://www.hackerrank.com/challenges/ctci-is-binary-search-tree
 *
 * In a nutshell, determine whether a tree is a binary search tree. duplicate values not allowed.
 */
public class BinarySearchTree {

    // Hidden stub code will pass a root argument to the function below. Complete the function to solve the challenge. Hint: you may want to write one or more helper functions.

    //The Node class is defined as follows:
    class Node {
        int data;
        Node left;
        Node right;
     }

    // Root level call
    boolean checkBST(Node root) {

        // Handle empty trees
        if (root == null)
            return true;

        HashSet<Integer> foundValues = new HashSet<>();

        return checkSubtree(root, foundValues, null, null);
    }

    // Inner recursive call
    boolean checkSubtree(Node root, HashSet<Integer> vals, Integer min, Integer max) {

        // Make sure BST conforms to higher up tree ranges
        if (min != null && root.data < min)
            return false;
        if (max != null && root.data > max)
            return false;

        // handle duplicate values (not sure this is needed)
        if (vals.contains(root.data))
            return false;
        else
            vals.add(root.data);

        boolean leftValid = true;
        boolean rightValid = true;
        if (root.left != null) {
            if (!(root.left.data < root.data))
                return false;
            else
                // pass down this node's value as new stricter max
                leftValid = checkSubtree(root.left, vals, min, root.data);
        }
        if (root.right != null) {
            if (!(root.right.data > root.data))
                return false;
            else
                rightValid = checkSubtree(root.right, vals, root.data, max);
        }
        return leftValid && rightValid;
    }
}
