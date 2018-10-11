package com.ctci.chapter4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by zambro on 4/30/17.
 */
public class LinkedListCreator {

    private static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }

        public Node(int data, Node left, Node right) {
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

    public static void printBFS(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            Node node = queue.poll();
            System.out.print(node.data+" ");
            if(node.left != null)
                queue.add(node.left);
            if(node.right != null)
                queue.add(node.right);
        }
    }

    public static List<List<Node>> createLinkedListBFS(Node root) {
        List<List<Node>> list = new ArrayList<>();
        List<Node> current = new LinkedList<>();
        if(root != null)
            current.add(root);

        while(!current.isEmpty()) {
            list.add(current);
            List<Node> nextLevel = new LinkedList<>();
            for(Node node:current) {
                if(node.left != null)
                    nextLevel.add(node.left);
                if(node.right != null)
                    nextLevel.add(node.right);
            }
            current = nextLevel;
        }

        return list;
    }


    public static List<List<Node>> createLinkedListDFS(Node root) {
        return createLinkedListDFS(root, new ArrayList<List<Node>>(), 0);
    }

    private static List<List<Node>> createLinkedListDFS(Node root, List<List<Node>> result, int level) {
        if(root == null)
            return result;

        List<Node> list = null;
        if(result.size() == level) {
            list = new LinkedList<>();
            result.add(list);
        } else {
            list = result.get(level);
        }

        list.add(root);
        createLinkedListDFS(root.left, result, level+1);
        createLinkedListDFS(root.right, result, level+1);

        return result;
    }
    public static void main(String[] args) {
        Node left = new Node(53);
        Node right = new Node(20);
        Node root = new Node(11, left, right);
        left = root;
        right = new Node(4, new Node(6), null);
        root = new Node(10, left, right);

        System.out.print("DFS: ");
        printDFS(root);
        System.out.print("\nBFS: ");
        printBFS(root);


        System.out.println();
        List<List<Node>> result = createLinkedListBFS(root);
        for(List<Node> nodeList: result) {
            for(Node node: nodeList)
                System.out.print(node.data+" ");
            System.out.println();
        }


        System.out.println();
        result = createLinkedListDFS(root);
        for(List<Node> nodeList: result) {
            for(Node node: nodeList)
                System.out.print(node.data+" ");
            System.out.println();
        }
    }
}
