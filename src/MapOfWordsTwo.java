package com.sleepsoft.challenges;

import java.util.*;
import java.util.function.Function;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

/**
 * Created by agermenos on 2/5/2017.
 */
public class MapOfWordsTwo {
    public static void main(String args[]) {
        MapOfWordsTwo mapOfWordsTwo = new MapOfWordsTwo();
        Map<String, Long> mappedWords = mapOfWordsTwo.mapNumberOfWords("Today, I say, today, is a beautiful day to die. They say so everywhere I go and everywhere I see there's a 'die here' sign");
        for (String word : mappedWords.keySet()) {
            System.out.println("\t" + word + (word.length() <= 3 ? "\t" : "") + (word.length() < 7 ? "\t" : "") + "\t--->\t" + mappedWords.get(word));
        }
    }

    private Map<String, Long> mapNumberOfWords(String words) {
        Map<String, Long> returnMap =
                Arrays.stream(words.
                        toLowerCase().
                        split("\\W+")).
                        sorted().
                        collect(groupingBy(Function.identity(), counting()));
        TreeMap<String, Long> sortedMap = new TreeMap<>(returnMap);
        return sortedMap;
    }
}

