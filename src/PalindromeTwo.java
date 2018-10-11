package com.sleepsoft.challenges;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by agermenos on 3/12/2017.
 */
public class PalindromeTwo {

    private String reverse(String text){
      char[] rvrsChr=new char[text.length()];
      for (int k=0;k<text.length();k++){
          rvrsChr[k]=text.charAt(text.length()-k-1);
      }
      return new String(rvrsChr);
    }

    private boolean isPalindrome(String word){
       return (word.equals(reverse(word)));
    }

    public String pickLongest(List<String>palindromes){
        Collections.sort(palindromes, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
               return o1.length()-o2.length();
            }

            @Override
            public boolean equals(Object obj) {
                if (obj instanceof String){
                    String s = (String) obj;
                    return this.equals(s);
                }
                return false;
            }
        });
        return palindromes.get(palindromes.size()-1);
    }

    public List<String> getPalindromes(String text){
        List<String> palindromeList = new ArrayList<>();
        char[] chrText = text.toCharArray();
        for (int start=0; start<=text.length()-2; start++){
            for (int end=text.length()-1; end>start; end--) {
                if (isPalindrome(text.substring(start, end+1))){
                    palindromeList.add(text.substring(start, end+1));
                    break;
                }
            }
        }
        //return null;
        System.out.println(palindromeList);
        return palindromeList;
    }

    @Test
    public void testPalindrome(){
        String word="thisisaracecar";
        List<String> expectedPalindromes=new ArrayList<>();
        expectedPalindromes.add("racecar");
        assertEquals("racecar", pickLongest(getPalindromes(word)));
    }

}
