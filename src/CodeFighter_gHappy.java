/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codefighter_ghappy;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author raliclo
 */
public class CodeFighter_gHappy {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        long speedX = System.currentTimeMillis();
        String str = "gg0gg3gg0gg00gg";

//        String str = "adsfas3";
        System.out.println(gHappy(str));
        System.out.println("Time spent :" + (System.currentTimeMillis() - speedX));
    }

    public static boolean gHappy(String str) {
        String[] xx = str.split("gg");
        int j = 0;
        for (String x : xx) {
            if (x.contains("g")) {
                j++;
            }
        }
        return j == 0;
    }

    public static boolean gHappy2(String str) {
        Matcher m1 = Pattern.compile("g").matcher(str);
        int i = 0, j = 0, k;

        while (m1.find() == true) {
//                System.out.print(m1.start() + " ");
//                System.out.println(m1.end());
            k = m1.end() - 1;
            i++;
            if (k == 0) {
                if (str.charAt(k) == str.charAt(k + 1)) {
                    j++;
//                        System.out.println("Yes");
                }

            }
            if (k > 0 && k != str.length() - 1) {
//                    System.out.println(str.charAt(k - 1) + " " + str.charAt(k) + " " + str.charAt(k + 1));
                if (str.charAt(k) == str.charAt(k + 1)
                        || str.charAt(k) == str.charAt(k - 1)) {
                    j++;
//                        System.out.println("Yes");
                }
            }
            if (k == str.length() - 1) {
                if (str.charAt(k) == str.charAt(k - 1)) {
                    j++;
//                        System.out.println("Yes");
                }
            }
        }

//        System.out.println("//" + i + " " + j);
        return i == j ? true : false;
    }

}
/*
Let's say that 'g' is happy in the given string,
if there is another 'g' immediately to the right or to the left of it.
Find out if all 'g's in the given string are happy.

Example:
gHappy("gg0gg3gg0gg") = true

[input] string str

A random string of Latin letters.
[output] boolean

true if all 'g's are happy, false otherwise.
 */
