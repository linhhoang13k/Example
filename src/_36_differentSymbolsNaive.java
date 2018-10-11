package Arcade_Intro;

import java.util.ArrayList;

public class _36_differentSymbolsNaive {
    int differentSymbolsNaive(String s) {
        ArrayList<Character> uniqueChars = new ArrayList<>();
        for(char currentChar : s.toCharArray()){
            if(!uniqueChars.contains(currentChar)) uniqueChars.add(currentChar);
        }
        return uniqueChars.size();
    }

    int differentSymbolsNaiveOneLiner(String s) {
        return (int) s.chars().distinct().count();
    }
}
