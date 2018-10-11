
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CodeFighter_NumberGameVI;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

/**
 *
 * @author raliclo
 */
public class CodeFighter_NumberGameVI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        long speedX = System.currentTimeMillis();
        int X = 31;
        int[] arr = unique_generator(X, 4);
        for (int i = 0, n = arr.length; i < n; i++) {
            System.out.println(arr[i]);
        }
        System.out.println("Answer:"
                + NumberGameVI(arr[0], arr[1], arr[2], arr[3], X));
        System.out.println("Time spent :" + (System.currentTimeMillis() - speedX));
    }

    public static int NumberGameVI(int a, int b, int c, int d, int X) {
        return q(new int[X][X][X], a, b, c) - 1;
    }

    public static int q(int[][][] w, int a, int b, int c) {
        int x = w[a][b][c], D = 1;
        for (; D < c & x == 0; D++) {
            if (D != a & D != b) {
                int A = D < a ? D : a,
                        C = D > b ? D : b,
                        B = a + b + D - A - C;
                if (q(w, A, B, C) == 0) {
                    x = D + 1;
                }
            }
        }
        return w[a][b][c] = x;
    }

    public static int[] unique_generator(int number, int qty) {
//        int[] arr = new int[4];
//        for (int i = arr.length - 1; i >= 0; i--) {
//            System.out.println(i);
//            arr[i] = (int) (5 * Math.random() + 1);
//            Arrays.sort(arr);
//            for (int j = 0, n = arr.length; j < n; j++) {
//                System.out.print(arr[j] + " ");
//            }
//            System.out.println();
//        }
//        ThreadLocalRandom.current().ints(0, 5).distinct().limit(5).forEach(System.out::print);
        IntStream a = ThreadLocalRandom.current().ints(0, number).distinct().limit(qty);
        int[] arr = a.toArray();
        Arrays.sort(arr);
        return arr;
    }
}
/*
A and B are playing number games again.

First, B chooses 4 different positive integer numbers.
Each move the player whose turn it is should change the largest of the 4 numbers into a smaller positive integer number. It can't be the same as the other three and it can't be the largest one anymore.
The player who can't make a move loses.

B had already chosen 4 different positive numbers a, b, c, d (a < b < c < d ≤ 30).
And now A can choose to play first or to let B play first.

Help A decide what to choose.
If A can win by playing first, return the smallest number he should change the largest number into to win.
Return -1 if A should let B play first.

Examples:

NumberGameVI(1,2,3,4)=-1
A should let B play first, because it's already impossible to make a move.

NumberGameVI(3,6,8,9)=7
The picture below shows how choosing 7 can win the game, and choosing any number smaller than 7 will result in loss. Some of the choices are omitted because they won't be chosen (there are better ones).
The numbers on the arrows shows the numbers the player choose to change the largest number into. Red represents A's moves and blue are B's choices.
Example2

NumberGameVI(4,6,7,10)=-1

NumberGameVI(6,7,11,17)=1

[input] integer a

[input] integer b

[input] integer c

[input] integer d

1 ≤ a < b < c < d ≤ 30
[output] integer

The first number A chooses if A can win by playing first, or -1 if A should let B play first.
CODE

 */
