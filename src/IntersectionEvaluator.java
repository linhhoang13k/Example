package com.ctci.chapter2;

import com.ctci.library.Node;

/**
 * Created by zambro on 4/11/17.
 */
public class IntersectionEvaluator {

    public static Node findIntersection(Node list1, Node list2) {
        if(list1 == null || list2 == null) {
            return null;
        }

        int list1Length = 0, list2Length = 0;
        Node tail1, tail2;
        Node current = list1;
        while(current.next != null) {
            list1Length++;
            current = current.next;
        }
        list1Length++;
        tail1 = current;

        current = list2;
        while(current.next != null) {
            list2Length++;
            current = current.next;
        }
        list2Length++;
        tail2 = current;

        if(tail1 != tail2) {
            return null;
        }

        Node shortList = list1Length < list2Length ? list1 : list2;
        Node biggerList = list1Length < list2Length ? list2 : list1;
        int difference = Math.abs(list1Length - list2Length);

        while(difference > 0) {

            biggerList = biggerList.next;
            difference--;
        }

        while(biggerList != null && shortList != null) {
            if(biggerList == shortList)
                return biggerList;
            biggerList = biggerList.next;
            shortList = shortList.next;
        }
        return null;
    }

    public static void main(String[] args) {
        {
            Node n = new Node(1);
            n = new Node(2, n);
            n = new Node(3, n);
            Node intersect = n;
            n = new Node(10, n);
            n = new Node(12, n);
            n = new Node(4, n);
            n = new Node(5, n);
            Node list1 = n;
            list1.printAll();

            n = new Node(20, intersect);
            n = new Node(1, n);
            Node list2 = n;
            list2.printAll();

            System.out.println(intersect);
            System.out.println(findIntersection(list1,list2));
        }
        {
            Node n = new Node(8);
            Node intersect = n;
            n = new Node(2, n);
            n = new Node(3, n);
            n = new Node(10, n);
            n = new Node(12, n);
            n = new Node(4, n);
            n = new Node(5, n);
            Node list1 = n;
            list1.printAll();

            n = new Node(20, intersect);
            n = new Node(1, n);
            Node list2 = n;
            list2.printAll();

            System.out.println(intersect);
            System.out.println(findIntersection(list1,list2));
        }
        {
            Node n = new Node(8);
            n = new Node(2, n);
            n = new Node(3, n);
            n = new Node(10, n);
            n = new Node(12, n);
            n = new Node(4, n);
            n = new Node(5, n);
            Node list1 = n;
            list1.printAll();

            n = new Node(20, null);
            n = new Node(1, n);
            Node list2 = n;
            list2.printAll();

            System.out.println(findIntersection(list1,list2));
        }
    }
}
