package edu.learning.codefights.tree;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Arrays;

/**
 * Created by duchuunguyen on 10/15/17.
 */
public class removeFromBST {
    static public Tree<Integer> deleteFromBST(Tree<Integer> t, int[] queries) {
        for (int value : queries) {
            Tree<Integer>[] pair = search(t, value);
            t = remove(t, pair);
        }
        return t;
    }

    static public Tree<Integer> remove(Tree<Integer> t, Tree<Integer>[] pair) {
        if (pair[0] == null) {
            return t;
        }
        Tree<Integer> cTree = pair[0];
        Tree<Integer> pTree = pair[1];

        //dont have left sub tree
        if (cTree.left == null) {
            if (pTree == null) {
                t = cTree.right;
            } else {
                if (pTree.value < cTree.value) {
                    pTree.right = cTree.right;
                } else {
                    pTree.left = cTree.right;
                }
            }
        } else {
            // find the right most and re-link
            Tree<Integer>[] rightPair = findRightMost(cTree.left, cTree);
            Tree<Integer> rmcTree = rightPair[0];
            Tree<Integer> rmpTree = rightPair[1];
            cTree.value = rmcTree.value;
            if (rmcTree.left != null) {
                if (rmpTree.value < rmcTree.value) {
                    rmpTree.right = rmcTree.left;
                } else {
                    rmpTree.left = rmcTree.left;
                }
            } else {
                if (rmpTree.value < rmcTree.value) {
                    rmpTree.right = null;
                } else {
                    rmpTree.left = null;
                }
            }
        }
        return t;
    }

    static public Tree<Integer>[] findRightMost(Tree<Integer> tree, Tree<Integer> pTree) {
        if (tree == null || (tree.right == null)) {
            Tree<Integer>[] arr = new Tree[2];
            arr[0] = tree; arr[1] = pTree;
            return arr;
        }

        return findRightMost(tree.right, tree);
    }

    static public Tree<Integer>[] search(Tree<Integer> tree, Integer value) {
        Tree<Integer> cTree = tree;
        Tree<Integer> pTree = null;
        while (true) {
            if (cTree != null) {
                if (cTree.value.equals(value)) {
                    Tree<Integer>[] arr = new Tree[2];
                    arr[0] = cTree; arr[1] = pTree;
                    return arr;
                }
                pTree = cTree;
                if (cTree.value < value) {
                    cTree = cTree.right;
                } else {
                    cTree = cTree.left;
                }
            } else {
                Tree<Integer>[] arr = new Tree[2];
                Arrays.fill(arr, null);
                return arr;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        String treeStr = "{\n" +
                "    \"value\": 3,\n" +
                "    \"left\": {\n" +
                "        \"value\": 2,\n" +
                "        \"left\": null,\n" +
                "        \"right\": null\n" +
                "    },\n" +
                "    \"right\": null\n" +
                "}";

        ObjectMapper mapper = new ObjectMapper();
        Tree<Integer> tree = mapper.readValue(treeStr, Tree.class);
        System.out.println(deleteFromBST(tree, new int[]{1,2,3,5}));
        System.out.println();
    }
}
