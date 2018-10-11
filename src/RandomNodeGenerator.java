package com.ctci.chapter4;

import java.util.Random;

/**
 * Created by zambro on 7/2/17.
 */
public class RandomNodeGenerator {

    public static class TreeNode{
        int data;
        TreeNode left;
        TreeNode right;
        int size;

        public TreeNode(int data) {
            this.data = data;
            size++;
        }

        public static void printDFS(TreeNode node) {
            if(node.left != null)
                printDFS(node.left);
            System.out.print(node.data + " ");
            if(node.right != null)
                printDFS(node.right);
        }

        public void insert(int data) {
            if(data < this.data) {
                if(this.left != null)
                    this.left.insert(data);
                else
                    this.left = new TreeNode(data);
            } else {
                if(this.right != null)
                    this.right.insert(data);
                else
                    this.right = new TreeNode(data);
            }
            size++;
        }

        public TreeNode getRandomNode(){
            Random random = new Random();
            int n = random.nextInt(size);
            int leftSize = left == null?0:left.size;
            if(n<leftSize)
                return left.getRandomNode();
            else if(n==leftSize)
                return this;
            else
                return right.getRandomNode();
        }
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(20);
        root.insert(10);
        root.insert(5);
        root.insert(15);
        root.insert(30);
        root.insert(3);
        root.insert(7);
        root.insert(17);
        root.insert(35);
        TreeNode.printDFS(root);
    }
}
