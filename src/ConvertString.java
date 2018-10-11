package com.codefights.challenges;

/**
 * Created by zambro on 7/8/17.
 * https://codefights.com/challenge/DF6j9AcQSCGtLonyM/
 *
 * You are given the string s. Your friend just asked you if it's possible to change the string from s to a string t by removing some characters from it. You're a pro at programming, so you decided to create a program to determine this.

 Example

 For s = "ceoydefthf5iyg5h5yts" and t = "codefights", the output should be
 convertString(s, t) = true.
 For s = "addbyca" and t = "abcd", the output should be
 convertString(s, t) = false.
 */
public class ConvertString {

    static boolean convertString(String s, String t) {
        if(s.length() < t.length())
            return false;
        int main=0,sec=0;
        for(;main<t.length() && sec<s.length();sec++){
            if(t.charAt(main) == s.charAt(sec))
                main++;
        }

        return main == t.length();
    }

   static boolean convertStringBestSoln(String s, String t) {
       System.out.println(t.replace("",".*?"));
        return s.matches(t.replace("",".*?"));
    }

    public static void main(String[] args) {
//        System.out.println(convertString("ceoydefthf5iyg5h5yts","codefights"));
        System.out.println(convertStringBestSoln("ceoyodefthfo5ioyg5h5ytso","codefights"));
    }
}
