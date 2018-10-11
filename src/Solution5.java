package com.il.training.hackerrank.sad_examples.oct;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by cesaregb on 10/11/16.
 */
public class Solution5 {

  public static void main(String[] args) {
    Solution5 s5 = new Solution5();
    Node root = new Node('0');
    s5.addWord("hack", 0, root);
    s5.addWord("hackerrank", 0, root);

    System.out.println("--> " + s5.getCount("hac", root, 0));
    System.out.println("--> " + s5.getCount("hak", root, 0));
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

  public int getCount(Node root) {
    int result = 0;
    if (root != null) {
      if (root.get('~') != null) {
        result++;
      }
      result += root.getActualNodes().stream().mapToInt(n -> {
        return getCount(n);
      }).sum();
    }
    return result;
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
