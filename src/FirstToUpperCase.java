package com.sleepsoft.tests;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

/**
 * Created by agermenos on 12/10/2016.
 */
public class FirstToUpperCase {
    public String capFirstToUppercase(String words){
        String arr_words[] = words.split(" ");
        List<String> capWords= Arrays.stream(arr_words).
                map(word -> {
                    char letters[] = word.toCharArray();
                    letters[0] = Character.toUpperCase(letters[0]);
                    return new String(letters);
                }).collect(Collectors.toList());
        StringBuffer sbCapWords = new StringBuffer();
        capWords.forEach(word -> sbCapWords.append(word + " "));
        return sbCapWords.toString().trim();
    }

    private void log(String text){
        System.out.println(text);
    }

    private void prepare(String original, String expected){
        log ("Expected:\t" + expected);
        log ("Result:\t" + capFirstToUppercase(original));
        assertEquals(expected, capFirstToUppercase(original));
    }

    @Test
    public void capWordsTest(){
        prepare("This is my little test", "This Is My Little Test");
    }
}
