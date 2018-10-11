package com.sleepsoft.tests;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by agermenos on 6/6/16.
 */
public class ArrayIndexSum {

    static Integer[] array = {-8, 1, 4, 6, 10, 45};
    static Integer sum = 16;

    public static void main (String args[]){
        ArrayIndexSum arrayIndexSum = new ArrayIndexSum();
        Arrays.stream(arrayIndexSum.getIndexesThatSum(array, sum)).forEach(index -> {
            System.out.println(index + " - ");
        });
    }

    private String[] getIndexesThatSum(Integer[] intArray, Integer sum) {
        Set returnItems = new HashSet<String>();
        for (int k = 0; k<intArray.length-2; k++) {
            for (int i=k; i<intArray.length-1; i++) {
                Integer localSum = intArray[i] + intArray[k];
                if (localSum==sum) {
                    returnItems.add(new String(intArray[k] + ", " + intArray[(i)]));
                }
            }
        }
        return (String[]) returnItems.toArray(new String[returnItems.size()]);
    }
}
