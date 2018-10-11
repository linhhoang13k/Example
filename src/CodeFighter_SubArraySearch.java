/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codefighter_subarraysearch;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author raliclo
 */
public class CodeFighter_SubArraySearch {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String array = "ABCdefgadsfsaiqwoerjvakls;dfjasdh";
        String subarray = "bsdh";
        //["ABCdefgh","bCf"]
        long b = System.currentTimeMillis();
        System.out.println(subarraysearch3(array, subarray));
        System.out.println("Time spent :" + (System.currentTimeMillis() - b));

        long c = System.currentTimeMillis();
        System.out.println(subarraysearch2(array, subarray));
        System.out.println("Time spent :" + (System.currentTimeMillis() - c));

        long d = System.currentTimeMillis();
        System.out.println(subarraysearch(array, subarray));
        System.out.println("Time spent :" + (System.currentTimeMillis() - d));

    }

    // SORTEST SOLUTION BUT SLOWER
    public static boolean subarraysearch3(String a, String s) {
        return a.matches(s.replace("", "(?i).*"));
    }

    // BEST SOLUTION AND FASTEST
    public static boolean subarraysearch2(String array, String subarray) {
        int i, j = 0;
        for (i = 0; i < subarray.length(); i++) {
            if (array.toLowerCase().indexOf(subarray.toLowerCase().charAt(i)) != -1) {
                j++;
            }
        }
        return j == subarray.length();
    }

    public static boolean subarraysearch(String array, String subarray) {
        String regex = "";
        for (int i = 0; i < subarray.length(); i++) {
            if (i != 0) {
                regex += ".*";
            }
            regex += subarray.toLowerCase().charAt(i);
        }
//        System.out.println(regex);
        Matcher a = Pattern.compile(regex).matcher(array.toLowerCase());
        return a.find();
    }
}
/*
Determine if the given subarray is a subarray of the given array.
A string is a subarray of another string if the first string is not longer than the second,
and all its letters are present in the second string in the exact same order,
but not necessarily consecutive. Cases of the letters do not matter.

Example:

subarraysearch("ABCdefgh", "bCf) = true
subarraysearch("ABCdefgh", 'i') = false

[input] string array

Input string, 2 < array < 10.
[input] string subarray

A subarray.
[output] boolean

true if subarray is a subarray of the array, false otherwise.
 */
