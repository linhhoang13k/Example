package com.ctci.chapter2;

import com.ctci.library.Node;

/**
 * Created by zambro on 4/9/17.
 */
public class SumLists {

    public static Node sumList(Node list1, Node list2) {
        Node head = null, tail = null;

        int sum, carry = 0;
        while(list1 != null && list2 != null) {
            sum = list1.data + list2.data + carry;
            carry = sum / 10;
            Node n = new Node(sum % 10);
            if(head == null) {
                head = n;
            } else {
                tail.next = n;
            }
            tail = n;
            list1 = list1.next;
            list2 = list2.next;
        }

        Node n = (list1 == null) ? list2 : list1;
        while(n != null) {
            sum = n.data+carry;
            carry = sum/10;
            Node m = new Node(sum % 10);
            if(head == null) {
                head = m;
            } else {
                tail.next = m;
            }
            tail = m;
            n = n.next;
        }

        if(carry != 0) {
            Node m = new Node(carry);
            if(head == null) {
                head = m;
            } else {
                tail.next = m;
            }
            tail = m;
        }

        return head;
    }

    public static Node sumListRecursion(Node list1, Node list2, int carry) {
        if(list1 == null && list2 == null && carry != 0) {
            return new Node(carry);
        } else if(list1 == null) {
            if(carry != 0 && list2 != null)
                list2.data += carry;
            return list2;
        } else if(list2 == null) {
            if(carry != 0 && list1 != null)
                list1.data += carry;
            return  list1;
        }

        int sum = list1.data + list2.data + carry;
        Node n = new Node(sum % 10);
        n.next = sumListRecursion(list1.next, list2.next, sum/10);

        return n;
    }
    public static void main(String[] args) {

        {
            Node n = new Node(6);
            n = new Node(6, n);
            n = new Node(1, n);
            n = new Node(7, n);
            n = new Node(8, n);
            n = new Node(2, n);
            n = new Node(3, n);
            Node list1 = n;
            list1.printAll();

            n = new Node(7);
            n = new Node(9, n);
            n = new Node(5, n);
            Node list2 = n;
            list2.printAll();

            Node h = sumList(list1, list2);
            h.printAll();
        }

        {
            Node n = new Node(8);
            n = new Node(2, n);
            n = new Node(3, n);
            Node list1 = n;
            list1.printAll();

            n = new Node(7);
            n = new Node(9, n);
            n = new Node(5, n);
            Node list2 = n;
            list2.printAll();

            Node h = sumList(list1, list2);
            h.printAll();
        }

        {
            Node n = new Node(6);
            n = new Node(6, n);
            n = new Node(1, n);
            n = new Node(7, n);
            n = new Node(8, n);
            n = new Node(2, n);
            n = new Node(3, n);
            Node list1 = n;
            list1.printAll();

            n = new Node(7);
            n = new Node(9, n);
            n = new Node(5, n);
            Node list2 = n;
            list2.printAll();

            Node h = sumListRecursion(list1, list2, 0);
            h.printAll();
        }

        {
            Node n = new Node(8);
            n = new Node(2, n);
            n = new Node(3, n);
            Node list1 = n;
            list1.printAll();

            n = new Node(7);
            n = new Node(9, n);
            n = new Node(5, n);
            Node list2 = n;
            list2.printAll();

            Node h = sumListRecursion(list1, list2, 0);
            h.printAll();
        }
    }
}
