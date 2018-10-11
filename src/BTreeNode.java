package com.ctci.library;

/**
 * Created by zambro on 4/23/17.
 */
public class BTreeNode {
    public int data;
    public BTreeNode left;
    public BTreeNode right;

    public BTreeNode(int data) {
        this.data = data;
    }

    public BTreeNode(int data, BTreeNode left, BTreeNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public void insert(int value) {
        if(value <= data) {
            if(left == null) {
                left = new BTreeNode(value);
            } else {
                left.insert(value);
            }
        } else {
            if(right == null) {
                right = new BTreeNode(value);
            } else {
                right.insert(value);
            }
        }
    }

    public boolean contains(int value) {
        if(value == data) {
            return true;
        } else if(value < data) {
            if(left == null)
                return false;
            else
                return left.contains(value);
        } else {
            if(right == null)
                return false;
            else
                return right.contains(value);
        }
    }

    public void printInOrder() {
        if(left != null)
            left.printInOrder();
        System.out.print(data+" ");
        if(right != null)
            right.printInOrder();
    }

    public static void main(String[] args) {
        BTreeNode bt = new BTreeNode(10);
        bt.insert(5);
        bt.insert(15);
        bt.insert(8);
        System.out.println("InOrder: ");
        bt.printInOrder();
        System.out.println("\nContains 10? "+bt.contains(10));
        System.out.println("Contains 3? "+bt.contains(3));
        System.out.println("Contains 8? "+bt.contains(8));
    }
}
