package com.ctci.chapter4;

/**
 * Created by zambro on 5/31/17.
 *
 * Check if T2 is a subtree of T1.
 */
public class SubTreeValidator {

    public static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    public static boolean isSubTreeRecursive(Node t1, Node t2) {
        if(t2 == null)
            return true;

        if(t1 == null)
            return false;

        if(t1.data == t2.data && isSubTreeHelper(t1, t2))
                return true;

        return isSubTreeRecursive(t1.left, t2) || isSubTreeRecursive(t1.right, t2);
    }

    private static boolean isSubTreeHelper(Node t1, Node t2) {
        if(t1 == null && t2 == null)
            return true;

        //One of the trees have reach an end and the other hasn't
        if(t1 == null || t2 == null)
            return false;

        //Data of the node doesnt match
        if(t1.data != t2.data)
            return false;

        return isSubTreeHelper(t1.left, t2.left) && isSubTreeHelper(t1.right, t2.right);
    }

    public static boolean isSubTreePreOrderParser(Node t1, Node t2) {
        String s1 = getPreOrder(t1, new StringBuilder()).toString();
        String s2 = getPreOrder(t2, new StringBuilder()).toString();
        System.out.println(s1);
        System.out.println(s2);
        return s1.contains(s2);
    }

    private static StringBuilder getPreOrder(Node t, StringBuilder s) {
        if(t == null){
            s.append("n");
        } else {
            s.append(t.data);
            getPreOrder(t.left, s);
            getPreOrder(t.right, s);
        }
        return s;
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

        three.left = five;
        three.right = seven;
        five.left = two;
        five.right = one;
        seven.left = six;
        six.left = eight;
        six.right = nine;
        nine.right = four;

        Node t1 = three;

        Node six2 = new Node(6);
        Node eight2 = new Node(8);
        Node nine2 = new Node(9);
        Node four2 = new Node(4);
        six2.left = eight2;
        six2.right = nine2;
        nine2.right = four2;

        System.out.println(isSubTreeRecursive(t1,six2));
        System.out.println(isSubTreePreOrderParser(t1,six2));
        System.out.println(isSubTreeRecursive(t1,four2));
        System.out.println(isSubTreePreOrderParser(t1,four2));
        System.out.println(isSubTreeRecursive(t1,nine2));
        System.out.println(isSubTreePreOrderParser(t1,nine2));
        System.out.println(isSubTreeRecursive(t1,eight2));
        System.out.println(isSubTreePreOrderParser(t1,eight2));
        System.out.println(isSubTreeRecursive(t1,null));
        System.out.println(isSubTreePreOrderParser(t1,null));
        Node ten = new Node(10);
        four.right = ten;
        System.out.println(isSubTreeRecursive(t1,six2));
        System.out.println(isSubTreePreOrderParser(t1,six2));
        System.out.println(isSubTreeRecursive(t1,nine2));
        System.out.println(isSubTreePreOrderParser(t1,nine2));
    }
}
