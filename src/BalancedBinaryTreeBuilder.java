package com.ctci.chapter4;

import com.ctci.library.BTreeNode;

/**
 * Created by zambro on 4/23/17.
 * Given a sorted array, build a balanced binary tree
 */
public class BalancedBinaryTreeBuilder {

    public static  BTreeNode buildBalancedBinaryTree(int[] arr) {
        return buildBalancedBinaryTree(arr, 0, arr.length-1);
    }

    private static  BTreeNode buildBalancedBinaryTree(int[] arr, int start, int end) {
        if(start > end) return null;
        int mid = (start + end) / 2;
        BTreeNode left = buildBalancedBinaryTree(arr, start, mid-1);
        BTreeNode right = buildBalancedBinaryTree(arr, mid+1, end);
        BTreeNode root = new BTreeNode(arr[mid], left, right);

        return root;
    }

    public static void main(String[] args) {
        BTreeNode root = buildBalancedBinaryTree(new int[]{10,20,30,40,50,60,70});
        root.printInOrder();
        System.out.println();
        root = buildBalancedBinaryTree(new int[]{1});
        root.printInOrder();
        System.out.println();
        root = buildBalancedBinaryTree(new int[]{1,2});
        root.printInOrder();
        System.out.println();
        root = buildBalancedBinaryTree(new int[]{1,2,3});
        root.printInOrder();
        System.out.println();
        root = buildBalancedBinaryTree(new int[]{1,2,3,4});
        root.printInOrder();
    }
}
