package com.sleepsoft.tests;

/**
 * Created by agermenos on 6/7/16.
 */
public class FibonacciNumber {
    private Integer getFNumber(Integer k){
        if (k>1) {
            return (getFNumber(k-1)+getFNumber(k-2));
        }
        else if (k.equals(1)) {
            return 1;
        }
        else {
            return 0;
        }

    }

    public static void main(String args[]) {
        FibonacciNumber fn = new FibonacciNumber();
        for (int k=0; k<1000; k++) {
            System.out.print (fn.getFNumber(k) + " ");
        }
    }
}
