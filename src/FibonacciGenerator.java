package com.ctci.misc.examples;

/**
 * Created by zambro on 2/19/17.
 */
public class FibonacciGenerator {

    public static int getFibonacciByRecursion(int n) {
        if(n == 0) {
            return 0;
        } else if(n == 1) {
            return 1;
        } else {
            int number = getFibonacciByRecursion(n-1) + getFibonacciByRecursion(n-2);
            return number;
        }
    }

    public static int getFibonacciByRecurionMemoryStorage(int n, int[] memory) {
        if(n == 0) {
            return 0;
        } else if(n == 1) {
            return 1;
        } else if(memory[n] != 0) {
            return  memory[n];
        } else {
            memory[n] = getFibonacciByRecursion(n-1) + getFibonacciByRecursion(n-2);
            return memory[n];
        }
    }

    public static int getFibonacci(int n) {
        if(n == 0) {
            return 0;
        } else if(n == 1) {
            return 1;
        } else {
            int previous = 0;
            int current = 1;
            int sum = 0;
            for(int i=2;i<=n;i++) {
                sum = previous + current;
                previous = current;
                current = sum;
            }

            return sum;
        }
    }

    public static void main(String[] args) {
        System.out.println(getFibonacciByRecursion(10));

        int[] memory = new int[100];
        System.out.println(getFibonacciByRecurionMemoryStorage(9,memory));

        System.out.println(getFibonacci(8));
    }
}
