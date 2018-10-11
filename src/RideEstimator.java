package com.sleepsoft.challenges.uber.challenge_2;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by agerm on 10/9/2016.
 */
public class RideEstimator {
    String fancyRide(int l, double[] fares) {
        float CASH=20;
        String rides[]={"UberX", "UberXL", "UberPlus", "UberBlack", "UberSUV"};
        int current=0;
        while (current<fares.length&&CASH>=(l*fares[current])){
            current++;
        }
        return rides[current-1];
    }

    @Test
    public void test1(){
        prepare(30, new double[] {0.3, 0.5, 0.7, 1, 1.3}, "UberXL");
    }

    @Test
    public void test3(){
        prepare(19, new double[]{1, 2, 3, 4, 5}, "UberX");
    }

    @Test
    public void test4(){
        prepare(20, new double[]{0.3, 0.5, 0.7, 1, 1.3},"UberBlack");
    }

    @Test
    public void test5(){
        prepare(15, new double[]{0.3, 0.5, 0.7, 1, 1.3}, "UberSUV");
    }

    public void prepare(int l, double[] fares, String output) {
        System.out.println ("Length: "+ l + "\tFares: " + Arrays.toString(fares) + "\n\tOutput: " + fancyRide(l,fares) + "\n\tExpected: " +output );
        assert(output.equals(fancyRide(l, fares)));
    }

}
