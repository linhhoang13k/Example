package com.codefights;

import java.util.*;

/**
 * Created by miztli on 10/06/17.
 */
public class RatingThreshold {
    public static int[] ratingThreshold(double threshold, int[][] ratings) {
        int result[] = new int[ratings.length];
        int next = 0;
        for(int i=0; i<ratings.length; i++){
            double sum = 0;
            for(int j=0; j<ratings[i].length; j++){
                sum+=ratings[i][j];
            }
            double average = sum/ratings[i].length;
            if (average < threshold){
                result[next] = i;
                next++;
            }
        }
        return Arrays.copyOfRange(result, 0, next);
    }

    public static void main(String[] args) {
        int ratings[][] = new int[][]{{3, 4}, {3, 3, 3, 4}, {4}};
        System.out.println("Result: ");
        int result[] = ratingThreshold(3.5, ratings);
        for(int i = 0; i < result.length; i++){
            System.out.println(i + ":" + result[i]);
        }
    }
}
