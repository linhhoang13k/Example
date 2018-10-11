package com.paigeruppel.codefights.bots;

import java.util.ArrayList;
import java.util.List;

public class JustifyText {

    String[] textJustification(String[] words, int l) {
        List<String> justified = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        int charCount = 0, wordCount = 0;

        for (int i = 0 ; i < words.length; i++) {
            int length = words[i].length() + 1;
            if (charCount + length > l) {
                int spaces = l - charCount;
                charCount = length;
                justified.add(sb.toString());
                wordCount = 1;
            } else {
                charCount += length;
                wordCount++;
                if (wordCount != 0)
                    sb.append(" ");
                sb.append(words[i]);
            }
        }
        justified.add(sb.toString());
        String[] justifiedArray = new String[justified.size()];
        for (int i = 0; i < justified.size(); i++) {
            justifiedArray[i] = justified.get(i);
        }
        return justifiedArray;

    }

}
