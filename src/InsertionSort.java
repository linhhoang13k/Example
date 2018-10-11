package com.sleepsoft.tests;

/**
 * Created by Alejandro on 6/18/16.
 */
public class InsertionSort {
    public static void main(String[] args) {

        int[] input = { 4, 2, 9, 6, 23, 12, 34, 0, 1 };
        //printInput(input);
        insertionSort(input);
        printInput(input);
    }

    private static void printInput(int[] input) {
        for (int k=0; k<input.length; k++){
            System.out.print(input[k] + " ");
        }
        System.out.println("");
    }

    private static void insertionSort(int[] input) {
        int j=0;
        for (int i=0; i<input.length; i++) {
            j=i;
            while (j>0 && input[j]<input[j-1]){
                int temp = input[j];
                input[j] = input[j-1];
                input[--j] = temp;
            }
            printInput(input);
        }
    }
}
