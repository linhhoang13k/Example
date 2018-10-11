package com.paigeruppel.codefights.challenges;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BestFriendPredictor {

    public boolean bestFriendNames(String name1, String name2) {
        return total(name1) == total(name2);
    }
    private int total(String s) {
        Map<Character, Integer> a = new HashMap<>();
        a.put(' ', 0);
        int v = 1, f=0;
        for (char ch = 'a'; ch <= 'z'; ++ch)
            a.put(ch, v++);
        char[] c = s.toLowerCase().toCharArray();
        for (char x:c)
            f+=a.get(x);
        return f;
    }


}
