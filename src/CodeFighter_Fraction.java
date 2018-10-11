/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CodeFighter_Fraction;

/**
 *
 * @author raliclo
 */
public class CodeFighter_Fraction {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        long runTime = System.currentTimeMillis();
        int max = 2000;
        int a = (int) (max * Math.random()) + 1;
        int b = (int) (max * Math.random()) + 1;
        System.out.println(a + " " + b + " " + Fraction(a, b));
        System.out.println(Fraction(10, 100));
        System.out.println(Fraction(5, 5));
        System.out.println(Fraction(2, 4));
        long runned = (System.currentTimeMillis() - runTime);
        System.out.println("Time spent :" + runned);

    }

    public static int Fraction(int a, int b) {
        for (int i = a > b ? b : a; i > 1; i--) {
            if (a % i == 0 && b % i == 0) {
                a /= i;
                b /= i;
            }
        }
        return a + b;
    }

    public static int Fraction2(int a, int b) {
        for (int i = a > b ? b : a; i > 1; i--) {
            if (a % i == 0 && b % i == 0) {
                a /= i;
                b /= i;
            }
        }
        return a + b;
    }
}
/*
Given two integers a and b, return the sum of the numerator and the denominator
of the reduced fraction a/b.

Example:

Fraction(2, 4) = 3, since
2/4 = 1/2 => 1 + 2 = 3.
Fraction(10, 100) = 11, since
10/100 = 1/10 => 1 + 10 = 11.
Fraction(5, 5) = 2, since
5/5 = 1/1 => 1 + 1 = 2.
[input] integer a

The numerator, 1 ≤ a ≤ 2000.
[input] integer b

The denominator, 1 ≤ b ≤ 2000.
[output] integer

The sum of the numerator and the denominator of the reduces fraction.
 */
