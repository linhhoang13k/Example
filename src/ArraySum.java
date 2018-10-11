package com.codefight.interviewpractice;

import java.util.Arrays;

public class ArraySum {
    public static void main(String ar[]){
        int[] input = {1,2,3,2,4,5};
        System.out.println(sumuniqueArrayValues(input));
        int[] input1 = {3,3,3,3,3,3};
        System.out.println(sumuniqueArrayValues(input1));
    }

    private static int sumuniqueArrayValues(int[] input){
        Arrays.sort(input);
        int sum = 0;
        for(int i=0; i< input.length; i++){
            if((i+1 < input.length) && (input[i] ==input[i+1])){
                i=i+1;
            }else{
                sum += input[i];
            }
        }
        return sum;
    }
}
