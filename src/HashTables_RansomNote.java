package HackerRank;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 * A kidnapper wrote a ransom note but is worried it will be traced back to him. He found a magazine and wants to know
 * if he can cut out whole words from it and use them to create an untraceable replica of his ransom note.
 * The words in his note are case-sensitive and he must use whole words available in the magazine, meaning he cannot
 * use substrings or concatenation to create the words he needs.

 Given the words in the magazine and the words in the ransom note, print Yes if he can replicate his ransom note
 exactly using whole words from the magazine; otherwise, print No.

 Input Format

 The first line contains two space-separated integers describing the respective values of m (the number of words
 in the magazine) and n (the number of words in the ransom note).
 The second line contains m space-separated strings denoting the words present in the magazine.
 The third line contains n space-separated strings denoting the words present in the ransom note.
 */
public class HashTables_RansomNote {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        String magazine[] = new String[m];
        for(int magazine_i=0; magazine_i < m; magazine_i++){
            magazine[magazine_i] = in.next();
        }
        String ransom[] = new String[n];
        for(int ransom_i=0; ransom_i < n; ransom_i++){
            ransom[ransom_i] = in.next();
        }

        HashMap<String, Integer> mappy = new HashMap<>();

        // Build map
        for (String word : magazine) {
            if (!mappy.containsKey(word)) {
                mappy.put(word, 1);
            } else {
                mappy.put(word, mappy.get(word) + 1);
            }
        }

        // Check if message passes
        boolean failed_yet = false;
        for (String word : ransom) {
            if (!mappy.containsKey(word) || mappy.get(word) == 0) {
                System.out.println("No");
                failed_yet = true;
                break;
            } else {
                mappy.put(word, mappy.get(word) - 1);
            }
        }
        if (!failed_yet)
            System.out.println("Yes");
    }
}
