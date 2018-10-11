package com.il.training.topics.graphTheory;

import com.google.common.base.Joiner;

import java.util.*;

/**
 * Created by cesaregb on 6/27/17.
 */
public class AlienLanguage {

  public static void main(String[] args) {
    System.out.println("hola");

    String words[] = new String[]{"baa", "abcd", "abca", "cab", "cad"};
    String[] words2 = new String[]{"caa", "aaa", "aab"};

    List<Character> result = getAlphabet(words2);

    System.out.println(Joiner.on(",").join(result));

  }


  public static List<Character> getAlphabet(String[] words) {
    // iterate thru the words. taking 2 at a time.

    HashMap<Character, Node> map = new HashMap<>();
    HashSet<Character> lChars = new HashSet<>();
    for (int i = 1; i < words.length; i++) {
      compareWords(map, words[i - 1], words[i]);
      lChars.addAll(getCharsOfWord(words[i - 1]));
      lChars.addAll(getCharsOfWord(words[i]));
    }

    // iterate thru the chars to generate the topological sort
    Set<Character> visited = new HashSet<>();
    Stack<Character> stack = new Stack<>();
    for (Character c : lChars) {
      topologicalSort(visited, stack, map.get(c));
    }

    List<Character> list = new ArrayList<>();
    while (!stack.isEmpty()) {
      list.add(stack.pop());

    }
    return list;
  }


  private static void topologicalSort(Set<Character> visited, Stack<Character> result, Node n) {
    if (visited.contains(n.myChar)) {
      return;
    }
    visited.add(n.myChar);
    for (Node itm : n.nexts) {
      topologicalSort(visited, result, itm);
    }
    result.push(n.myChar);
  }

  private static HashSet<Character> getCharsOfWord(String word) {
    HashSet<Character> result = new HashSet<>();
    for (int i = 0; i < word.length(); i++) {
      result.add(word.charAt(i));
    }
    return result;
  }


  private static void compareWords(HashMap<Character, Node> map, String a, String b) {
    int min = Math.min(a.length(), b.length());
    int i = 0;
    while (i < min && a.charAt(i) == b.charAt(i)) {
      i++;
    }
    if (i >= min) {
      return;
    }
    map.putIfAbsent(a.charAt(i), new Node(a.charAt(i)));
    Node n = map.get(a.charAt(i));
    map.putIfAbsent(b.charAt(i), new Node(b.charAt(i)));
    n.addNext(map.get(b.charAt(i)));
  }


  private static class Node {
    public Node(char c) {
      this.myChar = c;
    }

    char myChar;
    List<Node> nexts = new ArrayList<>();

    public void addNext(Node next) {
      nexts.add(next);
    }
  }

}
