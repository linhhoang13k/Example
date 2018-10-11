package com.codefights.arcade.intro;

/**
 * Created by zambro on 3/9/17.
 */

/**
 *
 * https://codefights.com/arcade/intro/level-2/yuGuHvcCaFCKk56rJ/description
 *
 * Below we will define an n-interesting polygon. Your task is to find the area of a polygon for a given n.

 A 1-interesting polygon is just a square with a side of length 1. An n-interesting polygon is obtained by taking the n - 1-interesting polygon and appending 1-interesting polygons to its rim, side by side. You can see the 1-, 2-, 3- and 4-interesting polygons in the picture below.


 Example

 For n = 2, the output should be
 shapeArea(n) = 5;
 For n = 3, the output should be
 shapeArea(n) = 13.

 */
public class SquareSpaceFinder {

    public static void main(String[] args) {
        for(int i=1;i<=100;i++) {
            System.out.println(shapeAreaN(i)+" "+shapeArea(i));
        }
    }
    public static int shapeAreaN(int n) {
        int totalSquares = 0;
        for(int i = n - 1; i>0; i--) {
            totalSquares += (i * 2) - 1;
        }

        totalSquares *=2;
        totalSquares += (n * 2) - 1;
        return totalSquares;
    }

    /**
     *
     * This can be written as a single line formula:
     *
     * Expanding on for loop
     *
     * [(n-1) * 2 - 1] + [(n-2) * 2 - 1] + .....+[(1) * 2 - 1]
     *
     * There will be (n-1) minus one's in the above eq
     *  2 * n(n-1)/2 + (n-1)(-1)
     *
     * n(n-1)-n+1
     * n^2-n-n+1
     * n^2-2n+1
     *
     * Now multiply by 2 to replcate bottom set of squares
     * 2n^2-4n+2
     *
     * Now lets add the middle squares
     *
     * 2n^2-4n+2+2n-1
     * 2n^2-2n+1 is the formula to find the share area
     *
     *
     * */

    public static int shapeArea(int n) {
        return  1 - 2*n +2*((int)Math.pow(n,2));
    }
}
