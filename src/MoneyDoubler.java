package com.sleepsoft.challenges;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by agerm on 10/2/2016.
 */
public class MoneyDoubler {
    double[] doubleTheMoeyGame(int n, int m) {
        double[] distribution=new double[n];
        Arrays.fill(distribution,m);
        int p=n;
        while (p>0) {
            int highestPos=getHighest(distribution);
            for (int k=0;k<n; k++){
                if (k!=highestPos) {
                    distribution[highestPos]-=distribution[k];
                    distribution[k]=distribution[k]*2;
                }
            }
        }
        return distribution;
    }

    private int getHighest(double[] distribution) {
        return 0;
    }

    private void prepare(int n, int m, double[] result){
        System.out.println("\n\tn:\t" + n + "\n\tm:\t"+m+
        "\n\n\tOutput:\t" + Arrays.toString(doubleTheMoeyGame(n,m)) +
                "\n\tExpected:\t"+Arrays.toString(result));
        assert (Arrays.equals(result,doubleTheMoeyGame(n,m)));
    }

    @Test
    public void test1(){
        prepare(3, 16, new double[] {26,14,8});
    }
    @Test
    public void test2(){
        prepare(2, 400, new double[] {500,300});
    }
    @Test
    public void test3(){
        prepare(5, 64, new double[]{162, 82, 42, 22, 12});
    }
    @Test
    public void test4(){
        prepare(2, 3730, new double[]{4662.5, 2797.5});
    }
    @Test
    public void test5(){
        prepare(2, 4899, new double[]{6123.75, 3674.25});
    }
}
