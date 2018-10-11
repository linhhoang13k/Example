package com.il.training.codefights.asana;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by cesaregb on 11/28/16.
 */
@SuppressWarnings("Duplicates")
public class HtmlTags2 {
  public static void main(String[] args) {
    HtmlTags2 t = new HtmlTags2();
    System.out.println(t.generateHTML("<div><p><img /></p><b></b></div>"));
  }

  public String generateHTML(String input) {
    Queue<Integer> queue = new LinkedList<>();
    int[] validaterCounter = new int[4];
    int i = 0;
    // constant time for creating the map...
    // this can be done static and avoid recreation, if this is going to run several times.
    Node root = rootNode;
    Node node = root;

    StringBuilder result = new StringBuilder();
    int open = 0;
    int last = 0;
    while (i < input.length()) {
      Character c = input.charAt(i);
      node = node.nodes.get(c);
      if (node == null) {
        return "";
      } // error

      if (node.nodes.size() == 0) {
        queue.offer(node.val);
        if (node.val <= 2) {
          if (open >= 1 && last == 2) {
            result.append(", ");
          }
          last = 1;
          open++;
          validaterCounter[node.val]++;
        } else if (node.val < 6) {
          open--;
          last = 2;
          validaterCounter[node.val - 3]--;
        }

        result.append(getEncodedTag(node.val));
        node = root;
      }
      i++;
    }
    // constant time
    if ((validaterCounter[0] + validaterCounter[1] + validaterCounter[2]) > 0) {
      return "";
    } // error
    return result.toString();
  }

  static class Node {
    int val;
    Character c;
    HashMap<Character, Node> nodes = new HashMap<>();

    public Node(Character c, int val) {
      this.c = c;
      this.val = val;
    }
  }

  static String getEncodedTag(int val) {
    if (val == 0) {
      return "DIV([";
    }
    if (val == 1) {
      return "P([";
    }
    if (val == 2) {
      return "B([";
    }
    if (val > 2 && val < 6) {
      return "])";
    }
    if (val == 6) {
      return "IMG({})";
    }
    return null;
  }

  static Node rootNode = createInitialMap();

  static Node createInitialMap() {
    Node n = new Node('~', 0);
    createNode(0, n, "<div>", 0);
    createNode(0, n, "<p>", 1);
    createNode(0, n, "<b>", 2);
    createNode(0, n, "</div>", 3);
    createNode(0, n, "</p>", 4);
    createNode(0, n, "</b>", 5);
    createNode(0, n, "<img />", 6);
    return n;
  }

  static Node createNode(int pos, Node root, String inp, int val) {
    if (pos == inp.length()) return null;

    Character c = inp.charAt(pos);
    Node n = root.nodes.get(c);
    if (n == null) {
      n = new Node(c, 0);
    }
    if (pos + 1 == inp.length()) {
      n.val = val;
    } else {
      n.nodes.put(inp.charAt(pos + 1), createNode(pos + 1, n, inp, val));
    }
    root.nodes.put(c, n);
    return n;
  }

}
