package com.ctci.chapter5;

/**
 * Created by zambro on 7/19/17.
 */
public class BinaryToStringConverter {

    public static String printBinary(double num) {
       if(num <= 0 || num >= 1)
           return "ERROR";

       StringBuilder sb = new StringBuilder(".");
       while(num > 0) {
           if(sb.length() > 32)
               return "ERROR";
           double n  = num * 2;
           if(n >= 1) {
               sb.append("1");
               num = n - 1;
           } else {
               sb.append("0");
               num = n;
           }

       }

       return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(printBinary(0.125));
        System.out.println(printBinary(0.5));
        System.out.println(printBinary(0.72));
    }
}
