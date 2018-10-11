package com.sleepsoft.challenges;

import org.junit.Test;

/**
 * Created by agerm on 10/29/2016.
 * Given an integer n, your task is to calculate the sum of digits in n! and return the answer modulo 9.

 Example

 For n = 4, the output should be
 digitSumFactorial(n) = 24.

 n! = 24, the sum of digits is 2 + 4 = 6, and 6 % 9 = 6. Thus, the output should be 6.

 Input/Output

 [time limit] 3000ms (java)
 [input] integer n

 Constraints:
 1 ≤ n ≤ 109.

 [output] integer

 The sum of digits in n! modulo 9.
 */
public class DigitSumFactorialClass {
    int digitSumFactorial(int n){
        int f=factorial(n);
        int sum=f;
        int ds=0;
        for (int pos = 10; pos <= f*10; pos *= 10) {
            int k = (sum%pos)/(pos/10);
            ds+=k;
            sum-=k*pos/10;
        }
        return ds%9;
    }

    private int factorial(int x) {
        if (x==0) return 0;
        int fact=1;
        while (x>0) {
            fact*=x--;
        }
        return fact;
    }

    @Test
    public void test1(){prepare(4,6);}
    @Test
    public void test2(){prepare(3,6);}
    @Test
    public void test3(){prepare(5,3);}
    @Test
    public void test4(){prepare(1,1);}
    @Test
    public void test5(){prepare(25,0);}

    private void prepare(int n, int m) {
        System.out.format ("Expected: %d\tOutput: %d", m, digitSumFactorial(n));
        assert(digitSumFactorial(n)==m);
    }
}
