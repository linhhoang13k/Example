/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codefighter_ordometer;

/**
 *
 * @author raliclo
 */
public class CodeFighter_OrdoMeter {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
//        int ran = (int) (Math.random() * 999999999);
        int ran = 999999;

        long c = System.currentTimeMillis();
        System.out.println("FaultyOdometer3 -in : " + ran + " -out : " + FaultyOdometer1(ran));
        System.out.println("Time spent :" + (System.currentTimeMillis() - c));

        long b = System.currentTimeMillis();
        System.out.println("FaultyOdometer2 -in : " + ran + " -out : " + FaultyOdometer2(ran));
        System.out.println("Time spent :" + (System.currentTimeMillis() - b));

    }

    // AWESOME ALOGORITHM O(log(n))
    public static int FaultyOdometer1(int n) {
        // System.out.println(n + " " + (n % 10 - (n % 10 > 4 ? 1 : 0))); // To understand code.
        return n < 1 ? 0 : 9 * FaultyOdometer1(n / 10) + n % 10 - (n % 10 > 4 ? 1 : 0);
    }

    // BRUTE-FORCE ALGORITHM O(n)
    public static int FaultyOdometer2(int n) {
        Integer nI;
        int i, d, delta = 0;
        String t;
        for (i = 0; i < n; i++) {
            nI = i;
            t = nI.toString();
            d = t.indexOf('4');
            if (d != -1) {
//                System.out.print((int) Math.pow(10, t.length() - d - 1) + " :");
                delta += (int) Math.pow(10, t.length() - d - 1);
            }
            if (t.contains("4")) {
//                System.out.print(nI + " -> ");
                nI = Integer.parseInt((t.replace('4', '5')));
//                System.out.println(nI);
                i = nI;
            }
        }
        return n - delta;
    }

}

/*
You are given a car odometer which displays the miles traveled as an integer.
The odometer has a defect, however: it proceeds from digit 3 to digit 5 always
skipping the digit 4. This defect shows up in all positions (ones, tens, hundreds, etc).
For example, if the odometer displays 15339 and the car travels another mile,
the odometer changes to 15350 (instead of 15340).

Constrain: 1 < n < 999999999

Example:

For n = 13 the output should be 12.
For n = 15 the output should be 13.
For n = 2003 the output should be 1461.

[input] integer n

The number the odometer shows, 1 < n < 999999999.
[output] integer
 */
