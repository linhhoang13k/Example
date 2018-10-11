package com.pramp;

import java.util.*;

/**
 * Created by zambro on 5/10/17.
 * Implement a document scanning function wordCountEngine, which receives a string document and returns a list of all unique words in it and their number of occurrences,
 * sorted by the number of occurrences in a descending order. Assume that all letters are in english alphabet.
 * You function should be case-insensitive, so for instance, the words “Perfect” and “perfect” should be considered the same word.

 The engine should strip out punctuation (even in the middle of a word) and use whitespaces to separate words.

 Analyze the time and space complexities of your solution. Try to optimize for time while keeping a polynomial space complexity.

 Examples:

 input:  document = "Practice makes perfect. you'll only
 get Perfect by practice. just practice!"

 output: [ ["practice", "3"], ["perfect", "2"],
 ["makes", "1"], ["get", "1"], ["by", "1"],
 ["just", "1"], ["youll", "1"], ["only", "1"] ]

 */
public class WordCountEngine {

    public static String[][] getWordCount(String doc){
        String[][] words = null;
        String[] wordsInDoc = doc.split(" ");
        Map<String, Integer> map = new HashMap<>();
        int largestCount = 0;
        for(String word : wordsInDoc){
            word = removeFormat(word);
            if(!word.isEmpty()) {
                if(map.containsKey(word)){
                    map.put(word, map.get(word)+1);
                } else {
                    map.put(word, 1);
                }

                if(map.get(word) > largestCount)
                    largestCount = map.get(word);
            }
        }


        List<LinkedList<String>> list = new ArrayList<>(Collections.nCopies(largestCount+1,null));

        for(Map.Entry<String, Integer> entry:map.entrySet()) {
            String word = entry.getKey();
            int count = entry.getValue();
            if(list.get(count) == null) {
                LinkedList<String> linkedList = new LinkedList<>();
                linkedList.add(word);
                list.set(count, linkedList);
            } else {
                list.get(count).add(word);
            }
        }

        words = new String[map.size()][2];
        int pointer = 0;
        for(int i=list.size()-1;i>0;i--){
            LinkedList<String> linkedList = list.get(i);
            if(linkedList != null)
            while(!linkedList.isEmpty()){
                words[pointer][0]=linkedList.poll();
                words[pointer][1]=i+"";
                pointer++;
            }
        }

        return words;
    }

    private static String removeFormat(String s) {
        return  s.toLowerCase().replaceAll("[^a-z]","");
    }

    public static void main(String[] args) {
        String document = "Practice makes perfect. you'll only\n" +
                " get Perfect by practice. just practice!";
        System.out.println(Arrays.deepToString(getWordCount(document)));
    }
}
