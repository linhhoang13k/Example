/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codefighter_nextnumber;

/**
 *
 * @author raliclo
 */
public class CodeFighter_nextNumber {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int n = 10;
        for (int i = 1; i < n; i++) {
            int N = i;
            long speedX = System.currentTimeMillis();
            System.out.print("#" + i + "");
            System.out.println("=>" + nextNumber(N) + " Time spent :" + (System.currentTimeMillis() - speedX));
        }
    }

    public static int nextNumber(int a) {
        int x = a + 1;
        while (Long.bitCount(x) != Long.bitCount(a)) {
            x++;
        }
        return x;
    }

    public static int nextNumber2(int N) {
//        System.out.println(Integer.bitCount(N));
        int x;
        System.out.println("-" + Integer.toBinaryString(N));
        for (x = N + 1;; x++) {
            if (Long.bitCount(x) == Long.bitCount(N)) {
//                System.out.println(x + ".bits:" + Long.bitCount(x) + " " + N + ".bits:" + Long.bitCount(N));
                break;
            }
        }
        System.out.println(Integer.toBinaryString(x));
        return x;
    }

// just for fun
    public static
            int doubles(int N) {
        class H {

            int d(int N) {
                return N / 2 > 0 ? 2 * d(N - 1) : 1;
            }
        }
        H a = new H();
        return a.d(N) - 1;

    }
}
/*
You're given a number N. Find the smallest number greater than N
which has the same number of active bits in it
(i.e. the same number of 1 in binary representation).

Examples:

For N = 1 the output should be 2 (they both have 1 active bit)
For N = 3 the output should be 5 (they both have 2 active bits)
[input] integer N

1 ≤ n ≤ 109.
[output] integer


 */
