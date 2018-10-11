
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codefighter.happynewyear;

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
//import java.sql.*; // Disble incase of Connection Class conflict

/**
 *
 * @author raliclo
 * @Java : java version "1.8.0_65"
 */
public class CodeFighterHappyNewYear {

    private static final Logger LOG = Logger.getLogger(CodeFighterHappyNewYear.class.getName());

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            /**
             * @param speedX to monitor program runtime
             */
            // TODO code application logic here
            long speedX = System.currentTimeMillis();
            runexec("pwd");
            String[] answer = happyNewYear("Happy New Year and CodeFight On in 2016!");
            Stream.of(answer).forEach(System.out::println);
            System.out.println("Time spent :" + (System.currentTimeMillis() - speedX) + "msec");
        } catch (IOException ex) {
            Logger.getLogger(CodeFighterHappyNewYear.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static String[] happyNewYear(String wish) {
        String[] wishes = wish.split(" ");

        /**
         * @Goal : Filter a String array with length >= x
         * @Input :String [] names , elements with different length
         * @Ouput : String[] names , all elements with length >= x
         * @Status : Completed
         */
        int x = 6;
        String[] names = {"Sam", "Pamela", "Dave", "Pascal", "Erik"};
        IntStream.range(0, names.length)
                .filter(i -> names[i].length() >= x)
                .mapToObj(i -> names[i])
                .collect(Collectors.toList()).forEach(System.out::println);
        /**
         * @Goal : Print elements in a column , originally spaced by " "
         * @Input : String
         * @Ouput : Print formated result.
         * @Status : Done
         */

        final int roomN = Stream.of(wishes)
                .max((String s, String t) -> (Integer.compare(s.length(), t.length())))
                .get().length();
        IntStream.range(0, roomN + 4).forEach(g -> System.out.print("*"));
        System.out.println();
        Stream.of(wishes).forEach(
                (p) -> {
                    System.out.print("* ");
                    System.out.print(p);
                    IntStream.range(0, (roomN - p.length())).forEach(k -> System.out.print(" "));
                    System.out.println(" *");
                });
        IntStream.range(0, roomN + 4).forEach(g -> System.out.print("*"));
        System.out.println();

        /**
         * @Goal : Print elements in a column , originally spaced by " "
         * @Input : String
         * @Ouput : String [], ready for print
         * @Status : Java8 way -- done
         */
        System.out.println();
        /*
        final int max = Stream.of(wishes)
                .max((String s, String t) -> (Integer.compare(s.length(), t.length())))
                .get().length(); // find max string length
        //ex. System.out.println(String.format("%0" + 10 + "d", 0).replace("0", "b")); // print b * 10 times.
        String[] wishes2 = Stream.of(wishes).map((s) -> {
            return "*" + s + String.format("%0" + (max + 1 - s.length()) + "d", 0).replace("0", " ") + "*";
        }).toArray(String[]::new);
        return wishes2
         */
        /**
         * @Goal : Print elements in a column , originally spaced by " "
         * @Input : String
         * @Ouput : The framed version of your wish in String[]
         * @Status : Java 1.7 Done
         */
        int max = 0;
        int i = 0;
        for (i = 0; i < wishes.length; i++) {
            if (wishes[i].length() > max) {
                max = wishes[i].length();
            }
        }
        String[] ans = new String[wishes.length + 1];
        String stars = String.format("%0" + (max + 4) + "d", 0).replace("0", "*");
        ans[0] = stars;
        ans[ans.length - 1] = stars;
        for (i = 1; i < wishes.length; i++) {
            ans[i] = ("* " + wishes[i] + String.format("%0" + (max - wishes[i].length() + 1) + "d", 0).replace("0", " ") + "*");
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
        try {
            while ((line = input.readLine()) != null) {
                System.out.println(line);
                //   For Octave integration only 
                //   if (line.startsWith("ans =")) {
                //    System.out.println(line.split("=")[1].trim());
                //     ans = line.split("=")[1].trim();
                // }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            p.waitFor();

        } catch (InterruptedException ex) {
            Logger.getLogger(CodeFighterHappyNewYear.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return ans;
    }
}
