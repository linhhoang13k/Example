package com.sleepsoft.challenges;

import java.util.*;

/**
 * Created by agermenos on 2/5/2017.
 */
public class MapOfWordsThree {
    public static void main(String args[]) {
        MapOfWordsThree mapOfWordsThree = new MapOfWordsThree();
        Map<String, Integer> mappedWords = mapOfWordsThree.mapNumberOfWords("Today, I say, today, is a beautiful day to die. They say so everywhere I go and everywhere I see there's a 'die here' sign");
        for (String word : mappedWords.keySet()) {
            System.out.println("\t" + word + (word.length() <= 3 ? "\t" : "") + (word.length() < 7 ? "\t" : "") + "\t--->\t" + mappedWords.get(word));
        }
    }

    private Map<String,Integer> mapNumberOfWords(String s) {
        String[] words = s.toLowerCase().split("\\W+");
        Map<String, Integer> returnMap = new TreeMap<>();
        Arrays.sort(words);
        String previousWord = words[0];
        int count=1;
        for (int k=1;k<words.length;k++){
            if (previousWord.equals(words[k])) count++;
            else {
                returnMap.put(previousWord, count);
                count=1;
                previousWord=words[k];
            }
        }
        return returnMap;
    }
}
