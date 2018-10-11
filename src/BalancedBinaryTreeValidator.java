package com.ctci.chapter4;

/**
 * Created by zambro on 4/30/17.
 */
public class BalancedBinaryTreeValidator {

    private static class Node{
        char data;
        Node left;
        Node right;
        private Node(char data) {
            this.data = data;
        }

        private Node(char data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public static void printDFS(Node root) {
        if(root == null)
            return;
        printDFS(root.left);
        System.out.print(root.data+" ");
        printDFS(root.right);
    }

    private static boolean isBalancedBinaryTree(Node root) {
        return  checkHeight(root) == Integer.MIN_VALUE ? false:true;
    }
    private static int checkHeight(Node root) {
        if(root == null)
            return -1;

        int left = checkHeight(root.left);
        if(left == Integer.MIN_VALUE)
            return Integer.MIN_VALUE;
        int right = checkHeight(root.right);
        if(right == Integer.MIN_VALUE)
            return  Integer.MIN_VALUE;

        if(Math.abs(left - right) > 1)
            return Integer.MIN_VALUE;
        else
            return Math.max(left,right) + 1;


    }

    public static void main(String[] args) {
        //Trees taken from http://stackoverflow.com/a/14712245/1664362
        Node left = new Node('B', new Node('D'), null);
        Node root = new Node('A', left, null);
        left = new Node('E', new Node('G'), null);
        Node right = new Node('C', left, new Node('F'));
        root.right = right;

        printDFS(root);
        System.out.println(isBalancedBinaryTree(root));
    }
}
