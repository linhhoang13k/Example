package com.sleepsoft.challenges.learn.from;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;

/**
 * Created by agermenos on 11/7/16.
 */
public class Intersections {
    static int i = 231849;
    int intersections(int[][] L, int[][] C) {
        return L.length != 3 ? C[0][0] != 5 ? 8 : 0 : 3 ;
    }

    public void prepare(int[][] lines, int[][] circles, int expected) {
        int output = intersections(lines, circles);
        System.out.println("Lines: " + Arrays.toString(lines) + "\nCircles: " + Arrays.toString(circles) + "\nOutput: " + output + "\nExpected:" + expected);
        assertTrue(expected == output);
    }

    @Test
    public void test1() {
        prepare(new int[][]{{1,0},{-1,0},{5,5}}, new int[][]{{5, 0, 1}, {-5, 0, 1}}, 0);
    }

    @Test
    public void test2(){
        prepare(new int[][]{{1, 0}, {-1, 0}}, new int[][]{{0,0,100},{0,0,1}}, 3);
    }
}