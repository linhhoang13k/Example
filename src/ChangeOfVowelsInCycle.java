package com.codefights.challenges;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zambro on 5/4/17. https://codefights.com/challenge/CA2ShAfLkb5D5JHCG
 * Given a text, reverse its characters and shift all of the vowels in a cycle.

 The vowels are 'a', 'e', 'i', 'o', and 'u' and can be upper- and lowercase.

 Example

 For cycle = 1 and text = "potato", the output should be
 changeOfVowelsInCycle(cycle, text) = "ototap".

 Reversed, the text becomes "otatop". The vowels in the text are 'o', 'a' and 'o' (in this exact order). When shifted by one, they become 'o', 'o' and 'a', so the final answer is "ototap".
 "cadmium" would invert to "muimdac", then after one cycle would be "maumdic".

 */
public class ChangeOfVowelsInCycle {

    public static String changeOfVowelsInCycle(int cycle, String t) {
        List<Character> list = new ArrayList<>();
        for(char c:t.toCharArray())
            if(isVowel(c))
                list.add(c);
        char[] arr = t.toCharArray();
        if(!list.isEmpty())
        for(int i=0;i<arr.length;i++) {
            cycle = cycle % list.size();
            if(isVowel(arr[i])) {
                arr[i] = list.get(cycle);
                cycle++;
            }
        }
        return new StringBuilder().append(arr).reverse().toString();
    }

    public static boolean isVowel(char c) {
        return "AEIOUaeiou".indexOf(c) != -1;
    }

    //Same logic as above but reduced char count for the challenge - 315 char count
    public static String changeOfVowelsInCycleGolfingIt(int c, String t) {
        String s = "AEIOUaeiou";
        List<Character> l = new ArrayList<>();
        char[] a = t.toCharArray();
        for(char x:a)
            if(s.indexOf(x) != -1)
                l.add(x);

        if(!l.isEmpty())
            for(int i=0;i<a.length;i++) {
                c = c % l.size();
                if(s.indexOf(a[i]) != -1)
                    a[i] = l.get(c++);
            }
        return new StringBuilder().append(a).reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(changeOfVowelsInCycle(1,"cadmium"));
        System.out.println(changeOfVowelsInCycle(1,"potato"));
        System.out.println(changeOfVowelsInCycle(7,"N vwls hr"));
    }

}
