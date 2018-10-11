package com.sleepsoft.challenges;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by agermenos on 10/31/2016.
 */
public class MatrixSolver {
    Object equationSystem(String[] e) {
        int i=0; int rows=0, cols =0;
        double[][]A=new double[4][3];double[]B=new double[3];double[]X=new double[3];
        for (String eq:e) {
            String chars[] = eq.split("x|y|z");
            for (String element:chars) {
                A[cols++][rows] = Long.valueOf(element.replace("=",""));
            }
            rows++; cols=0;
        };
        return null;

    }

    public void prepare(String[] eqs, Object expected){
        System.out.println("\tEqs \t: " + Arrays.toString(eqs) +
                "\n\tExpected: "+ Arrays.toString((double[])expected) + "\t Result: " +
                Arrays.toString((double[])equationSystem(eqs)));
        assert(Arrays.deepEquals((Double[])expected, (Double[])equationSystem(eqs)));
    }

    @Test
    public void test1(){
        prepare(new String[]{"9x+5y+4z=21",
                "6x+3y-5z=7",
                "3x-10y+6z=35"}, new double[]{3, -2, 1} );
    }

}
