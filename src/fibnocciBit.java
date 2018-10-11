package com.codefights.challenges;

/**
 * Created by zambro on 7/8/17.
 */
public class fibnocciBit {

    static int fibonacciWord(int n, String p) {
        String prev = "0";
        String curr = "1";

        if(n==0)
            curr = "0";
        String temp = "";
        while (n > 1) {
            temp = curr + prev;
            prev = curr;
            curr = temp;
            n--;
            System.out.println(curr);
        }

        System.out.println(curr);
        System.out.println(curr.length());
        String replaced = curr.replaceAll(p,"");
        System.out.println(replaced);
        System.out.println(replaced.length());
        System.out.println(curr.length() - replaced.length());

        int x = (curr.length() - replaced.length()) / p.length();
        return x;
    }

    public static void main(String[] args) {
        System.out.println(fibonacciWord(10,"110101101"));
    }
}
