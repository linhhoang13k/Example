package com.github.chen0040.codefights.depthfirst;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by xschen on 4/8/2017.
 *
 * Suppose we represent our file system as a string. For example, the string "user\n\tpictures\n\tdocuments\n\t\tnotes.txt" represents:

 user
 pictures
 documents
 notes.txt
 The directory user contains an empty sub-directory pictures and a sub-directory documents containing a file notes.txt.

 The string "user\n\tpictures\n\t\tphoto.png\n\t\tcamera\n\tdocuments\n\t\tlectures\n\t\t\tnotes.txt" represents:

 user
 pictures
 photo.png
 camera
 documents
 lectures
 notes.txt
 The directory user contains two sub-directories pictures and documents. pictures contains a file photo.png and an empty second-level sub-directory camera. documents contains a second-level sub-directory lectures containing a file notes.txt.

 We want to find the longest (as determined by the number of characters) absolute path to a file within our system. For example, in the second example above, the longest absolute path is "user/documents/lectures/notes.txt", and its length is 33 (not including the double quotes).

 Given a string representing the file system in this format, return the length of the longest absolute path to a file in the abstracted file system. If there is not a file in the file system, return 0.

 Example

 For fileSystem = "user\n\tpictures\n\tdocuments\n\t\tnotes.txt", the output should be

 longestPath(fileSystem) = 24.

 The longest path is "user/documents/notes.txt", and it consists of 24 characters.

 Input/Output

 [time limit] 3000ms (java)
 [input] string fileSystem

 File system in the format described above. It is guaranteed that:

 the name of a file contains at least a . and an extension;
 the name of a directory or sub-directory does not contain a ..
 Note: Due to system limitations, newline characters are given as carriage returns ('\r') in our test cases.

 Guaranteed constraints:

 1 ≤ fileSystem.length ≤ 6500.

 [output] integer


 */
public class LongestPath {
   int longestPath(String fileSystem) {
      List<String> parts = split(fileSystem);

      Node root = null;
      Node current = null;
      Node parent = null;
      Map<Integer, Node> levels = new HashMap<Integer, Node>();
      List<Node> roots = new ArrayList<Node>();
      for(int i=0; i < parts.size(); ++i) {
         String part = parts.get(i);

         if(i == 0) {
            root = new Node(part);
            parent = root;
            current = root;
            roots.add(root);
            levels.put(0, root);
         } else {
            int j = 0;
            while (part.indexOf("\\t") == 0) {
               part = part.substring(2, part.length());
               j++;
            }
            if(part.contains(" ")) {
               part = part.replace(" ", "");
               j++;
            }


            current = new Node(part);

            if(j == 0){
               roots.add(current);
            }

            levels.put(j, current);
            parent = levels.get(j-1);

            current.parent = parent;
            if(parent != null){
               parent.nodes.add(current);
               //System.out.println(j + ": " + parent.word + " => " + current.word);
            }
         }
      }


      int maxLength = 0;
      for(int i=0; i < roots.size(); ++i) {
         maxLength = Math.max(maxLength, getLongestFilePath(roots.get(i), 0));
      }
      return maxLength;
   }

   class Node {
      String word;
      Node parent;
      List<Node> nodes = new ArrayList<Node>();
      public Node(String w) {
         word = w;
      }
   }


   List<String> split(String text) {
      int index = text.indexOf("\\r");
      if(index == -1){
         index = text.indexOf("\\n");
      }
      List<String> result = new ArrayList();
      while(index != -1) {
         index = text.indexOf("\\r");
         if(index == -1){
            index = text.indexOf("\\n");
         }
         if(index != -1){
            result.add(text.substring(0, index));
            text = text.substring(index+2, text.length());
            if(text.length() == 0){
               break;
            }
         }
      }

      if(text.length() > 0) {
         result.add(text);
      }
      return result;
   }


   void print(Node x, String prefix) {
      if(x == null) {
         return;
      }
      prefix = prefix + "/"  + x.word;
      if(x.nodes.isEmpty()) {
         System.out.println(prefix);
      }
      for(int i = 0; i < x.nodes.size(); ++i) {
         print(x.nodes.get(i), prefix);
      }
   }

   int getLongestFilePath(Node x, int d) {
      if(x.nodes.isEmpty()) {
         if(x.word.contains(".")){
            return d + x.word.length() + (d == 0 ? 0 : 1);
         }
      }

      int maxLength = 0;
      for(int i=0; i < x.nodes.size(); ++i){
         maxLength = Math.max(maxLength, getLongestFilePath(x.nodes.get(i), x.word.length() + (x.parent == null ? 0 : 1) + d));
      }
      return maxLength;
   }

}
