package com.il.training.codefights.varios;

import java.util.*;

/**
 * Created by cesaregb on 3/18/17.
 */

//Question:
// https://codefights.com/interview/EDaACHNYHyH6qQFAL
//Solutions Ref:
// http://www.programcreek.com/2012/12/leetcode-word-ladder/
// http://www.programcreek.com/2014/06/leetcode-word-ladder-ii-java/

public class WordLadder {

  public static void main(String[] args) {
    System.out.println(wordLadder("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log", "cog"}));
    System.out.println(wordLadder("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log"}));
  }

  static int wordLadder(String beginWord, String endWord, String[] wordList) {
    if (beginWord.length() != endWord.length()) return 0;
    if (wordList.length == 0) return 0;

    Set<String> dictionary = new HashSet<>(wordList.length);
    Collections.addAll(dictionary, wordList);
    Queue<Word> queue = new LinkedList<>();
    queue.add(new Word(beginWord, 1, new HashSet<>()));

    final int wLength = beginWord.length();
    while (queue.size() > 0) {
      Word tmp = queue.remove();
      if (tmp.word.equals(endWord)) return tmp.steps;
      for (int i = 1; i <= wLength; i++) {
        for (int j = 'a'; j <= 'z'; j++) {
          StringBuilder sb = new StringBuilder();
          sb.append(tmp.word.substring(0, i - 1)).append((char) j).append(tmp.word.substring(i, wLength));
          if (dictionary.contains(sb.toString()) && !tmp.visitedPath.contains(sb.toString())) {
            tmp.visitedPath.add(sb.toString());
            queue.add(new Word(sb.toString(), tmp.steps + 1, tmp.visitedPath));
          }
        }
      }
    }
    return 0;
  }

  static class Word {
    String word;
    int steps;
    Set<String> visitedPath = new HashSet<>();

    Word(String word, int steps, Set<String> visitedPath) {
      this.word = word;
      this.steps = steps;
      this.visitedPath = visitedPath;
    }
  }
}

