package com.ctci.chapter4;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by zambro on 5/13/17.
 */
public class CommonAncestorFinder {

    public static class Wrapper {
        boolean hasNodeA;
        boolean hasNodeB;
        Node parent;
    }

    public static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    public static void printBFS(Node root) {
        Queue<Node> queue = new LinkedList<>();
        if (root != null)
            queue.add(root);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            System.out.print(node.data + " ");
            if (node.left != null)
                queue.add(node.left);
            if (node.right != null)
                queue.add(node.right);
        }
    }

    public static Node findCommonAncestor(Node root, Node nodeA, Node nodeB) {
        Wrapper wrapper = findCommonAncestorWrapper(root, nodeA, nodeB);
        if (wrapper.hasNodeA && wrapper.hasNodeB)
            return wrapper.parent;
        return null;
    }

    private static Wrapper findCommonAncestorWrapper(Node current, Node nodeA, Node nodeB) {
        if (current == null)
            return new Wrapper();

        Wrapper left = findCommonAncestorWrapper(current.left, nodeA, nodeB);
        if (left.hasNodeA && left.hasNodeB) {
            if (left.parent == null)
                left.parent = current;
            return left;
        }

        Wrapper right = findCommonAncestorWrapper(current.right, nodeA, nodeB);
        if (right.hasNodeA && right.hasNodeB) {
            if (right.parent == null)
                right.parent = current;
            return right;
        }

        Wrapper wrapper = new Wrapper();
        if (left.hasNodeA || right.hasNodeA) {
            wrapper.hasNodeA = true;
        }

        if (left.hasNodeB || right.hasNodeB) {
            wrapper.hasNodeB = true;
        }

        if (wrapper.hasNodeA && wrapper.hasNodeB)
            wrapper.parent = current;

        if (current == nodeA)
            wrapper.hasNodeA = true;
        if (current == nodeB)
            wrapper.hasNodeB = true;

        return wrapper;
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
        three.left = one;
        three.right = two;
        two.right = ten;
        five.left = seven;
        five.right = eleven;
        seven.left = eight;


        Node root = four;
        printBFS(root);
        System.out.println();

        Node commonAncestor = findCommonAncestor(root, three, five);
        System.out.println(commonAncestor.data);
        commonAncestor = findCommonAncestor(root, one, five);
        System.out.println(commonAncestor.data);
        commonAncestor = findCommonAncestor(root, two, five);
        System.out.println(commonAncestor.data);
        commonAncestor = findCommonAncestor(root, two, eleven);
        System.out.println(commonAncestor.data);
        commonAncestor = findCommonAncestor(root, two, eight);
        System.out.println(commonAncestor.data);
        commonAncestor = findCommonAncestor(root, one, eight);
        System.out.println(commonAncestor.data);
        commonAncestor = findCommonAncestor(root, two, ten);
        System.out.println(commonAncestor.data);
        commonAncestor = findCommonAncestor(root, one, ten);
        System.out.println(commonAncestor.data);
        commonAncestor = findCommonAncestor(root, one, three);
        System.out.println(commonAncestor.data);
        commonAncestor = findCommonAncestor(root, eight, seven);
        System.out.println(commonAncestor.data);
    }
}
