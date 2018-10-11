package com.il.training.hackerrank.ctci;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * Created by cesaregb on 12/2/16.
 */
@SuppressWarnings("Duplicates")
public class TriesContacts {

  public static void main(String[] args) {
    TriesContacts s = new TriesContacts();
    Node root = new Node('0');
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    for (int a0 = 0; a0 < n; a0++) {
      String op = in.next();
      String contact = in.next();
      if (op.equalsIgnoreCase("add")) {
        s.addWord(contact, 0, root);
      } else {
        System.out.println(s.getCount(contact, root, 0));
      }

    }
  }

  public void addWord(String s, int index, Node n) {
    if (s.length() == index) {
      n.putIfAbsent('~');
    } else {
      char c = s.charAt(index);
      n.putIfAbsent(c);
      addWord(s, ++index, n.get(c));
    }
  }

  public int getCount(String str, Node root, Integer index) {
    if (root == null) return 0;
    if (index == (str.length())) { //last char
      return root.nWords;
//			return getCount(root.get(str.charAt(index)));
    } else {
      return getCount(str, root.get(str.charAt(index)), ++index);
    }
  }
}

class Node {
  char value;
  HashMap<Character, Node> nodes = new HashMap<>();
  int nWords = 0;

  public Node(char c) {
    this.value = c;
  }

  public char getValue() {
    return value;
  }

  public HashMap<Character, Node> getNodes() {
    return nodes;
  }

  public Node get(char c) {
    return nodes.get(c);
  }

  public Node putIfAbsent(char c) {
    nWords++;
    nodes.putIfAbsent(c, new Node(c));
    return nodes.get(c);
  }

  public List<Node> getActualNodes() {
    List<Node> nds = new ArrayList<>();
    this.nodes.forEach((k, v) -> {
      nds.add(v);
    });

    return nds;
  }
}