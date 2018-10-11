package com.sleepsoft.tests;

import java.util.Date;

/**
 * Created by agermenos on 6/8/16.
 */
public class PrimeNumbers {
    public static void main (String args[]){
        Integer suspects[] = new Integer[]{1,2,3,7,11,13,17,22};
        for (int testValue:suspects){
            Date beforeTest=new Date();
            System.out.println("RECURSIVE: Is " + testValue + " prime? " + isPrime(testValue));
            Date afterTest=new Date();
            System.out.println("RECURSIVE: Time logged = " + (afterTest.getTime() - beforeTest.getTime()) + " ms");
            System.out.println();
            beforeTest=new Date();
            System.out.println("LINEAR: Is " + testValue + " prime? " + isPrimeToo(testValue));
            afterTest=new Date();
            System.out.println("LINEAR: Time logged = " + (afterTest.getTime() - beforeTest.getTime()) + " ms");
            System.out.println();
            beforeTest=new Date();
            System.out.println("PANDORA: Is " + testValue + " prime? " + method(testValue));
            afterTest=new Date();
            System.out.println("PANDORA: Time logged = " + (afterTest.getTime() - beforeTest.getTime()) + " ms");
            System.out.println("--------------------------------------------");
        }
    }

    private static boolean isPrime(Integer testValue, Integer currentValue) {
        if (testValue<=2 || --currentValue==1) return true;
        if (testValue%currentValue!=0) return isPrime(testValue, currentValue);
        else return false;
    }

    public static boolean isPrime(Integer testValue) {
        return isPrime(testValue, testValue);
    }

    private static boolean isPrimeToo(Integer testValue) {
        for (int k = testValue - 1; k > 1; k--) {
            if (testValue % k == 0) {
                return false;
            }
        }
        return true;
    }

    static boolean method(int n)  {
        if (n < 2) return false;
        for (int i = 2; i < n; i++) {
            if (n%i == 0) {
                return false;
            }
        }
        return true;
    }
}
