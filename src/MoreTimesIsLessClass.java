package com.sleepsoft.challenges;

import org.junit.Test;

/**
 * Created by agermenos on 10/22/2016.
 */
/*
Some positive integers can be written as the difference of the squares of 2 positive integers, i.e., n = a² - b².

For instance, 3 can be written as 2² - 1².

Some numbers can be written in that format in more than one way. For example, 15 can be written as 4² - 1² or 8² - 7².

Your task is, given a positive integer n, to calculate the number of such pairs (a, b), where n = a² - b² and both a and b are positive integers.

Example

For n = 1, the output should be
MoreTimesLess(n) = 0.

It is impossible to write 1 as a difference of two squares.

For n = 3, the output should be
MoreTimesLess(n) = 1.

3 = 22 - 12.

For n = 15, the output should be
MoreTimesLess(n) = 2.

15 = 42 - 12 = 82 - 72.

Input/Output

[time limit] 3000ms (java)
[input] string n

Constraints:
1 ≤ n ≤ 1013.

[output] integer

The number of pairs (a, b) such that n = a² - b², where a and b are positive integers.
 */
public class MoreTimesIsLessClass {
    int MoreTimesLess(String n) {
        int incidence=0;
        int b = Integer.valueOf(n);//(int)Math.ceil(Float.valueOf(n)/2);
        while (b>0){
            int a =(int) Math.sqrt(b*b-Integer.valueOf(n));
            if (a!=0 && (a+b) * (b-a) == Integer.valueOf(n)) {
                incidence++;
            }
            b-=1;
        }
        return incidence;
    }

    public void prepare(String n, int expected){
        System.out.println("\tn: " + n + "\tExpected: "+ expected + "\t Result: " + MoreTimesLess(n));
        assert(expected==MoreTimesLess(n));
    }

    @Test
    public void test1(){prepare("1", 0);}
    @Test
    public void test2(){prepare("3",1);}
    @Test
    public void test3(){prepare("15",2);}
    @Test
    public void test4(){prepare("41",1);}
    @Test
    public void test5(){prepare("77",2);}
    @Test
    public void test6(){prepare("91",2);}
    @Test
    public void test7(){prepare("45",3);}
    @Test
    public void test8(){prepare("689",2);}
    @Test
    public void test9(){prepare("477",3);}
}
