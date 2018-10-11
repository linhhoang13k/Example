package com.sleepsoft.tests;

import java.util.StringTokenizer;

/**
 * Created by Alejandro on 6/19/16.
 */
public class WordCounter {
    public static void main(String args[]){
        WordCounter wordCounter = new WordCounter();
        wordCounter.count("This is a test of the word counter");
        wordCounter.count("     ");
        wordCounter.count("This,my sweet pumpkin,is another test");
    }

    private void count(String s) {
        StringTokenizer stringTokenizer = new StringTokenizer(s, " ,;.");
        System.out.println ("String {" + s + "} has " + stringTokenizer.countTokens() + " words");
    }
}
