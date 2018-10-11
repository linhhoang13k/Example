/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codefighter_supercup;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author raliclo
 */
public class CodeFighter_SuperCup {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String[] s = {"zalamalehkly", // win
            "altahzamalqyek", // loss
            "aahzamalekalahly", // > win
            "aahlzamalekalahly",
            "aahlyzamalekalahly",
            "aahyzamalekalahly",
            "aalzamalekalahly",
            "aalyzamalekalahly",
            "aayzamalekalahly",
            "ahzamalekalahly",
            "ahlzamalekalahly",
            "ahlyzamalekalahly",
            "ahyzamalekalahly",
            "alzamalekalahly",
            "alazamalekalahly",
            "alahzamalekalahly",
            "alahlzamalekalahly",
            "alahyzamalekalahly",
            "alalzamalekalahly",
            "alalyzamalekalahly",
            "alayzamalekalahly",
            "alhzamalekalahly",
            "alhlzamalekalahly",
            "alhlyzamalekalahly",
            "alhyzamalekalahly",
            "allzamalekalahly",
            "allyzamalekalahly",
            "alyzamalekalahly",
            "ayzamalekalahly",
            "hlzamalekalahly",
            "hlyzamalekalahly",
            "hyzamalekalahly",
            "lazamalekalahly",
            "lahzamalekalahly",
            "lahlzamalekalahly",
            "lahlyzamalekalahly",
            "lahyzamalekalahly",
            "lalzamalekalahly",
            "lalyzamalekalahly",
            "layzamalekalahly",
            "lhzamalekalahly",
            "lhlzamalekalahly",
            "lhlyzamalekalahly",
            "lhyzamalekalahly",
            "llzamalekalahly",
            "llyzamalekalahly",
            "lyzamalekalahly",};

        long b = System.currentTimeMillis();
        for (int i = 0; i < s.length; i++) {
            SuperCup(s[i]);
//            System.out.println("SuperCup result of " + s[i] + "-->" + i + " :" + SuperCup(s[i]));
        }
        System.out.println("Time Spent:" + (System.currentTimeMillis() - b));

        long c = System.currentTimeMillis();
        for (int i = 0; i < s.length; i++) {
            SuperCup2(s[i]);
//            System.out.println("SuperCup2 result of " + s[i] + "-->" + i + " :" + SuperCup2(s[i]));

        }
        System.out.println("Time Spent:" + (System.currentTimeMillis() - c));

        long d = System.currentTimeMillis();
        for (int i = 0; i < s.length; i++) {
            SuperCup3(s[i]);
//            System.out.println("SuperCup3 result of " + s[i] + "-->" + i + " :" + SuperCup3(s[i]));
        }
        System.out.println("Time Spent:" + (System.currentTimeMillis() - d));

    }

    //    BEST SOLUTION AND FASTEST
    public static String SuperCup(String s) {
        int z = 0, a = 0, i = 0;
        while (z < 7 & a < 6) {
//            System.out.print("i=" + i + "//");
            char c = s.charAt(i++);
            z += "zamalek".charAt(z) == c ? 1 : 0;
            a += "alahly".charAt(a) == c ? 1 : 0;
        }
        return z > 6 ? "win" : "loss";
    }

    public static String SuperCup4(String s) {

        class H {

            int d;

            H(String b) {
                Matcher m = Pattern.compile(b).matcher(s);
                m.find();
                d = m.end();
            }
        }
        return new H("a.*h.*y").d > new H("z.*?a*k").d ? "win" : "loss";
    }

    // SUBMITTED && FASTEST
    public static String SuperCup3(String s) {
        Matcher a = Pattern.compile("a*l*a.*h*l.*y").matcher(s);
        Matcher b = Pattern.compile("z*a*m.*?a*l*e*k").matcher(s);
        a.find();
        b.find();
        return a.end() > b.end() ? "win" : "loss";
    }

    // ORIGINAL SUBMITTED FOR DEBUG
    public static String SuperCup2(String s) {

//       String REGEX = "z\\ba\\bm\\ba\\bl\\be\\bk";
        //alahly        //zamalek
//        s.subSequence(beginIndex, endIndex);
        String REGEX1 = "a.*?l.*?a.*?h.*?l.*?y"; // \w?a\w?h\w?l\w?y\\b?"
        String REGEX2 = "z.*?a.*?m.*?a.*?l.*?e.*?k"; // \w?a\w?h\w?l\w?y\\b?"
//        boolean test = Pattern.matches("z*a*l*a*m*a*l*e*h*k*l*y", s);
//        Pattern p = Pattern.compile(REGEX);
//        Pattern p2 = Pattern.compile(REGEX2);
        Matcher m1 = Pattern.compile(REGEX1).matcher(s);
        Matcher m2 = Pattern.compile(REGEX2).matcher(s);

//        boolean test = Pattern.matches(REGEX, s);
//        boolean test2 = Pattern.matches(REGEX2, s);
//        System.out.println(test + " " + test2);
        try {
            if (s.contains("y") && s.contains("h")) {
                m1.find();
            } else {
                return "win";
            }
            if (s.contains("z") && s.contains("m") && s.contains("k") && s.contains("e")) {
                m2.find();
            } else {
                return "loss";
            }
            return (m1.end() > m2.end()) ? "win" : "loss";
        } catch (Exception e) {
            return "Error";
        }
//        int count = 0, count2 = 0;
//        while (m1.find()) {
//            //            String result1 = m.group(0);
//            //            System.out.println(":" + result1);
//            count++;
//            System.out.print("Match1 number :" + count + "@" + REGEX1);
//            if (count != 0) {
//                System.out.print(" >> start(): " + m1.start());
//                System.out.println(" -> end(): " + m1.end());
//            }
//        }
//        while (m2.find()) {
//            //            String result2 = m.group(0);
//            //            System.out.println(":" + result2);
//            count2++;
//            System.out.print("Match2 number :" + count + "@" + REGEX2);
//            if (count != 0) {
//                System.out.print(" >> start(): " + m2.start());
//                System.out.println(" -> end(): " + m2.end());
//            }
//        }
//        System.out.println(m1.start() + " " + m2.start());
//        System.out.println(m1.end() + " " + m2.end());

    }
}
/*
Tomorrow is SAIB Egyptian Super Cup, match between El_Zamalek :) and Alahly -_-.
Given a string of lowercase latin letters, return "win" if Zamalek wins.
Otherwise return "loss".
Zamalek wins if in the given string the last element of subsequence
"z", "a", "m", "a", "l", "e", "k" appears before the last element of subsequense
"a", "l", "a", "h", "l", "y".

It is guaranteed that both subsequences are present in the given string.

Example:

SuperCup("zalamalehkly") = "win"

Lets mark letters from word "zamalek" in bold, and letters from word "alahly" in italic.
z a l a m a l e h k l y.
Zamalek finishes before Alahly, so Zamalek wins.

[input] string s

A string of lowercase Latin letters with two aforementioned subsequences. |s| < 50.
[output] string

Either "win" or "loss".
 */
