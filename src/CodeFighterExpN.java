
/*
 * Student Info: Name=Lo,WeiShun , ID= 13108
 * Subject: CourseNo_HWNo_Summer_2015
 * Author: raliclo
 * Filename: CodeFighterExpN.java
 * Date and Time: Feb 4, 2016 2:09:23 PM
 * Project Name: CodeFighter-exp_n_
 */

 /*
You are given a decimal number n as a string. Transform it into an array of numbers (given as strings again), such that each number has only one nonzero digit and their sum equals n.

Each number in the output array should be written without any leading and trailing zeros.

Example

For n = "7970521.5544" the output should be
exp(n) = ["7000000", "900000", "70000", "500", "20", "1", ".5", ".05", ".004", ".0004"]

For n = "7496314" the output should be
exp(n) = ["7000000", "400000", "90000", "6000", "300", "10", "4"]

exp("0") = []

[input] string n

A non-negative number, 1 ≤ n.length ≤ 13.
[output] array.string

Elements in the array should be sorted in descending order.
 */
package codefighter.exp.n;

import java.io.*;
import java.net.*;
import java.security.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.lang.*;
import java.time.*;
import java.applet.*;
import java.nio.*;
import java.beans.*;
import java.rmi.*;
import java.util.regex.*;
import java.util.logging.*;
import java.util.concurrent.*;
import java.util.stream.*;
import java.util.function.*;
import java.nio.file.*;
import java.nio.charset.*;
import java.nio.file.spi.*;
import java.nio.file.attribute.*;
import java.nio.channels.*;
import java.nio.channels.spi.*;
//import import java.awt.*; // Disabled, because of List Class conflict
//import java.sql.*; // Disbled, because of Connection Class conflict

/**
 *
 * @author raliclo
 * @Java : java version "1.8.0_65"
 */
public class CodeFighterExpN {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /**
         * @param speedX to monitor program runtime
         */
        // TODO code application logic here
        String n1 = "7970521.5544";
        String n2 = "7496314";
        long speedX = System.currentTimeMillis();
        expn(n1);
        expn(n2);
//        Stream.of(expn(n1)).forEach(System.out::println);
        Stream.of(expn(n2)).forEach(System.out::println);
        System.out.println("Time spent :" + (System.currentTimeMillis() - speedX) + "msec");

    }

    public static String[] expn(String n) {
        if (n == "0") {
            String[] ans = {};
            return ans;
        }
        int k = 0;
        int i;
        int nums = n.length();
        for (i = 0; i < n.length(); i++) {
            if (n.charAt(i) == '.') {
                k = i;
            }
        }
        class Helper {

            String zero(int n
            ) {
                String x = "";
                if (n > 0) {
                    for (int i = 0; i < n; i++) {
                        x += "0";
                    }
                }
                if (n < 0) {
                    for (int i = n; i < 0; i++) {
                        x += "0";
                    }
                }
                return x;
            }
        }
        Helper h = new Helper();
        LinkedList<String> llx = new LinkedList();
        int m = 0;
        for (i = 0; i < nums; i++) {
            char c = n.charAt(i);
            if (c == '0' || c == '.') {
                m++;
            }
            if (k == 0) {
                if (c != '0' && c != '.') {
                    llx.add(String.valueOf(c) + h.zero(nums - i - 1));
                }
            }
            if (k != 0) {
                if (i < k) {
                    if (c != '0' && c != '.') {
                        llx.add(String.valueOf(c) + h.zero(nums - i - k + 1));
                    }
                }
                if (i > k) {
                    if (c != '0' && c != '.') {
                        llx.add("." + h.zero(i - k - 1) + String.valueOf(c));
                    }
                }
            }
        }
        int size = llx.size();
        String[] ans = new String[size];
        for (i = 0; i < size; i++) {
            ans[i] = llx.get(i);
        }
        return ans;
    }

    /**
     * @param x for command line
     * @throws java.io.IOException
     */
    public static Object runexec(String x) throws IOException {
        Process p = Runtime.getRuntime().exec(x, null, null);
        Object ans = null;
        BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String line = null;
        while ((line = input.readLine()) != null) {
            System.out.println(line);
        }
        return ans;
    }
}
