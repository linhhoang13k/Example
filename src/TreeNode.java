package com.ctci.library;

/**
 * Created by zambro on 4/16/17.
 */
public class TreeNode {
    public int data;
    public TreeNode left;
    public TreeNode right;


    public TreeNode(int data) {
        this.data = data;
    }

    public TreeNode(int data, TreeNode left,  TreeNode right) {
        this.data = data;
        this.right = right;
        this.left = left;
    }

}
