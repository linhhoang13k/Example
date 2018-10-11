package com.ctci.chapter4;

/**
 * Created by zambro on 4/30/17.
 */
public class BSTValidator {

    private static class Wrapper {
        Integer min;
        Integer max;
        boolean isValid;
        public Wrapper(boolean isValid){
            this.isValid = isValid;
        }

        public Wrapper(boolean isValid, Integer min, Integer max) {
            this.isValid = isValid;
            this.min = min;
            this.max = max;
        }
    }
    private static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data){
            this.data = data;
        }

        public Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public static void printDFS(Node root) {
        if(root==null)
            return;

        printDFS(root.left);
        System.out.print(root.data+" ");
        printDFS(root.right);
    }

    public static Wrapper isBSTWithWrapper(Node root) {
        if(root==null)
            return new Wrapper(true);

        if(root.left != null){
            if(root.left.data > root.data)
                return new Wrapper(false);
        }

        if(root.right != null){
            if(root.right.data < root.data)
                return new Wrapper(false);
        }

        Wrapper left = isBSTWithWrapper(root.left);
        if(!left.isValid)
            return left;
        Wrapper right = isBSTWithWrapper(root.right);
        if(!left.isValid)
            return right;

        //Find max from left
        if(left.max != null && left.max > root.data)
            return new Wrapper(false);

        //Find min from right. Assumption: duplicates should be placed on left. right side values are always greater than root
        if(right.max != null && right.min <= root.data)
            return new Wrapper(false);

        return new Wrapper(true, left.min == null?root.data:left.min, right.max == null?root.data:right.min);
    }

    public static boolean isBST(Node root) {
        return  isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    private static boolean isBST(Node root, int min, int max) {
        if(root == null)
            return true;

        if(root.data<=min || root.data>max)
            return false;

        return isBST(root.left, min, root.data) && isBST(root.right, root.data, max);

    }

    public static boolean checkBST(Node n, Integer min, Integer max) {
        if (n == null) {
            return true;
        }
        if ((min != null && n.data <= min) || (max != null && n.data > max)) {
            return false;
        }
        if (!checkBST(n.left, min, n.data) ||
                !checkBST(n.right, n.data, max)) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Node right = new Node(17, new Node(13), new Node(19));
        Node left = new Node(10, null, right);
        right = new Node(25, null, new Node(35,null, new Node(45)));
        Node root = new Node(20, left, right);
        printDFS(root);
        System.out.println("\n"+isBSTWithWrapper(root).isValid);
        System.out.println(isBST(root));
        Node x = new Node(20, new Node(20), new Node(21));
        System.out.println(isBST(x));
        Node x1 = new Node(20, new Node(20), new Node(21));
        System.out.println(checkBST(x1, null, null));
    }
}
