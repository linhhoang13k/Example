package com.github.chen0040.codefights.trees;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by xschen on 4/8/2017.
 */
public class FindSubstrings {
   static class Node {
      Node[] nodes = new Node[256];
      boolean bit;
   }

   static class Tries {
      Node root = null;
      void put(String word) {
         root = _put(root, word, 0);
      }

      Node _put(Node x, String word, int d) {


         if(x == null){
            x = new Node();
         }

         if(d == word.length()) {
            x.bit = true;
            return x;
         }

         int c = (int)word.charAt(d);

         x.nodes[c] = _put(x.nodes[c], word, d+1);
         return x;
      }

      Map<String, String> getWords(String part) {
         Map<String, String> queue = new HashMap<String, String>();
         collect(root, part, "", "", 0, queue);
         return queue;
      }

      void collect(Node x, String part, String prefix, String prefix2, int d, Map<String, String> queue) {

         if(x == null) {
            return;
         }

         if(x.bit && part.length() == d) {
            queue.put(prefix, prefix2);
         }


         for(int i=0; i < 256; ++i) {
            if(d <= part.length()-1 && i == part.charAt(d)){
               String p = prefix + (char) i;
               String p2 = prefix2 + (char)i;
               if(d == 0){
                  p2 = prefix2 + "[" + (char)i;
               }

               if(d == part.length()-1) {
                  p2 = p2 + "]";
               }

               collect(x.nodes[i], part, p, p2, d+1, queue);
            } else if(d <= part.length()-1) {
               collect(x.nodes[i], part, prefix + (char) i, prefix + (char)i, 0, queue);
            } else {
               collect(x.nodes[i], part, prefix + (char) i, prefix2 + (char)i, d, queue);
            }
         }
      }
   }


   static String[] findSubstrings(String[] words, String[] parts) {

      Tries t = new Tries();
      for(String word : words) {
         t.put(word);
      }

      Map<String, String> selected = new HashMap<String, String>();

      for(String w : words) {
         selected.put(w, w);
      }

      for(String p : parts) {
         Map<String, String> found = t.getWords(p);
         for(Map.Entry<String, String> f : found.entrySet()) {
            String word = f.getKey();
            String formatted = f.getValue();
            if(selected.containsKey(word)) {
               if(selected.get(word).length() < formatted.length()) {
                  selected.put(word, formatted);
               }
            } else {
               selected.put(word, formatted);
            }
         }
      }

      String[] result = new String[selected.size()];
      int index = 0;
      for(Map.Entry<String, String> entry : selected.entrySet()) {
         result[index++] = entry.getValue();
      }
      return result;



   }

   public static void main(String[] args) {
      String[] words = new String[]{"Apple", "Melon", "Orange", "Watermelon"};
      String[] parts = new String[] {"a", "mel", "lon", "el", "An"};

      String[] found = findSubstrings(words, parts);
      for(String w : found){
         System.out.println(w);
      }
   }

}
