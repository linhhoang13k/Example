package com.ctci.chapter4;

/**
 * Created by zambro on 5/7/17.
 *
 * Given a node find the next node based on inorder
 *
 * Tree used here is
 *
 *                     4
 *                3        5
 *             1    2    7   11
 *                N  10 8 N
 *
 *  N is null
 */
public class FindNextInOrderNode {
    private static class Node {
        int data;
        Node parent;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }

        public Node(int data, Node left, Node right){
            this.data = data;
            this.left = left;
            this.right = right;
        }

        public Node(int data, Node parent, Node left, Node right) {
            this.data = data;
            this.parent = parent;
            this.left = left;
            this.right = right;
        }
    }
    public static void printInOrder(Node root) {
        if(root == null)
            return;
        printInOrder(root.left);
        System.out.print(root.data+" ");
        printInOrder(root.right);
    }

    public static Node findNextInOrder(Node root) {
        if(root == null)
            return null;

        if(root.right != null) {
            Node node = root.right;
            while(node.left != null)
                node = node.left;
            return node;
        }

        Node child = root;
        Node parent = root.parent;
        while(parent != null && parent.left != child) {
            child = parent;
            parent = parent.parent;
        }

        return parent;
    }
    public static void main(String[] args) {
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(5);
        Node six = new Node(6);
        Node seven = new Node(7);
        Node eight = new Node(8);
        Node nine = new Node(9);
        Node ten = new Node(10);
        Node eleven = new Node(11);

        four.left = three;
        four.right = five;
        three.parent = four;
        five.parent = four;
        three.left = one;
        three.right = two;
        one.parent = three;
        two.parent = three;
        two.right = ten;
        ten.parent = two;


        Node root = four;
        printInOrder(root);
        System.out.println();
        System.out.println(findNextInOrder(root).data);
        System.out.println(findNextInOrder(one).data);
        System.out.println(findNextInOrder(ten).data);
        System.out.println(findNextInOrder(two).data);
        System.out.println(findNextInOrder(three).data);
        System.out.println(findNextInOrder(five));

        five.left = seven;
        five.right = eleven;
        seven.parent = five;
        eleven.parent = five;
        seven.left = eight;
        eight.parent = seven;

        System.out.println(findNextInOrder(eight).data);
        System.out.println(findNextInOrder(seven).data);
        System.out.println(findNextInOrder(eleven));
        System.out.println(findNextInOrder(five).data);
    }
}
