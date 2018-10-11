package com.ctci.chapter4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by zambro on 5/21/17.
 */
public class BSTSequence {

    public static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    public static List<List<Integer>> getPossbileArray(Node root) {
        List<List<Integer>> resultList = new ArrayList<>();
        if(root == null) {
            resultList.add(new ArrayList<>());
            return resultList;
        }


        List<Integer> prefix = new ArrayList<>();
        prefix.add(root.data);

        List<List<Integer>> leftList = getPossbileArray(root.left);
        List<List<Integer>> rightList = getPossbileArray(root.right);


        for(List<Integer> left:leftList)
            for(List<Integer> right:rightList) {
                List<List<Integer>> result = getAllCombinations(left, right, prefix);
                resultList.addAll(result);
            }

        return resultList;
    }

    private static List<List<Integer>> getAllCombinations(List<Integer> list1, List<Integer> list2, List<Integer> prefix) {
        List<List<Integer>> resultList = new ArrayList<>();
        if(list1.isEmpty() || list2.isEmpty()) {
            List<Integer> result = new ArrayList<>();
            result.addAll(prefix);
            result.addAll(list2.isEmpty()?list1:list2);

            resultList.add(result);
        } else {

            int removedHead = list1.remove(0);
            prefix.add(removedHead);
            List<List<Integer>> leftOneRemoved = getAllCombinations(list1, list2, prefix);
            prefix.remove(prefix.size()-1);
            list1.add(0, removedHead);


            removedHead = list2.remove(0);
            prefix.add(removedHead);
            List<List<Integer>> rightOneRemoved = getAllCombinations(list1, list2, prefix);
            prefix.remove(prefix.size()-1);
            list2.add(0, removedHead);
            resultList.addAll(leftOneRemoved);
            resultList.addAll(rightOneRemoved);
        }

        return resultList;
    }


    private static List<List<Integer>> getAllCombinationsUsingLinkedList(LinkedList<Integer> list1, LinkedList<Integer> list2, LinkedList<Integer> prefix) {
        List<List<Integer>> resultList = new ArrayList<>();
        if(list1.isEmpty() || list2.isEmpty()) {
            List<Integer> result = new ArrayList<>();
            result.addAll(prefix);
            result.addAll(list2.isEmpty()?list1:list2);

            resultList.add(result);
        } else {

            int removedHead = list1.removeFirst();
            prefix.addLast(removedHead);
            List<List<Integer>> leftOneRemoved = getAllCombinations(list1, list2, prefix);
            prefix.removeLast();
            list1.addFirst(removedHead);


            removedHead = list2.removeFirst();
            prefix.addLast(removedHead);
            List<List<Integer>> rightOneRemoved = getAllCombinations(list1, list2, prefix);
            prefix.removeLast();
            list2.addFirst(removedHead);
            resultList.addAll(leftOneRemoved);
            resultList.addAll(rightOneRemoved);
        }

        return resultList;
    }

    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);

        List<Integer> list2 = new ArrayList<>();
        list2.add(3);
        list2.add(4);

        //Validate the lists are created successfully.
        List<List<Integer>> result = getAllCombinations(list1, list2, new ArrayList<>());
        System.out.println(result);

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
        Node twenty = new Node(20);

        five.left = one;
        five.right = six;
        result = getPossbileArray(five);
        System.out.println(result);

        seven.left = five;
        result = getPossbileArray(seven);
        System.out.println(result);

        seven.right = ten;
        result = getPossbileArray(seven);
        System.out.println(result);

        ten.right = twenty;
        ten.left = eight;
        result = getPossbileArray(seven);
        System.out.println(result);

    }


    /**
     *
     * base case:
     * if one of the list is empty add other list to the prefix
     * and return the result
     *
     * pop one from first list and add to prefix, then call the same method.
     * pop one from second list and add to prefix, then call the same method.
     *
     * add the two results and return
     *
     */
}
