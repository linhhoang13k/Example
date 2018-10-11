/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codefighter_summer;

/**
 *
 * @author raliclo
 */
public class CodeFighter_Summer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        long b = System.currentTimeMillis();
        int count = 9999999;
        for (int i = 0; i <= count; i++) {
            Summer(i);
//            System.out.println(i + " Result: " + Summer(i));
        }
        System.out.println("Time spent :" + (System.currentTimeMillis() - b));

        long c = System.currentTimeMillis();

        for (int i = 0; i <= count; i++) {
            Summer2(i);
//            System.out.println(i + " Result: " + Summer(i));
        }
        System.out.println("Time spent :" + (System.currentTimeMillis() - c));

    }

    // Best solution to count numbers in bit. FAST !
    public static int Summer(int n) {
        return Long.bitCount(n);

    }

    public static int Summer2(int n) {
        return n < 2 ? 1 : 1 + Summer2(n / 2);
    }

    // Solution to count numbers in bit. Slow.
    public static int Summer3(int n) {

        if (n < 2) {
            return n % 2;
        } else {
            return n % 2 + Summer3(n / 2);
        }

    }
}
/*
Any number can be represented as the sum of unique powers of 2.
For example, 15 = 1 + 2 + 4 + 8 = 20 + 21 + 22 + 23.
There's a function called Summer, which calculates the number of powers of two
it takes to get the given number. Your task is to implement this function.

Example

Summer(15) = 4
Summer(16) = 1

[input] integer n

Some integer number.
[output] integer

Summer(n).
 */
