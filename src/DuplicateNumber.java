package com.sleepsoft.tests;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alejandro on 6/18/16.
 */
public class DuplicateNumber {
    public static void main(String a[]){
        List<Integer> numbers = new ArrayList<Integer>();
        for(int i=1;i<95;i++){
            numbers.add(i);
        }
        //add duplicate number into the list
        numbers.add(-3);
        DuplicateNumber dn = new DuplicateNumber();
        System.out.println("Duplicate Number: "+dn.findDuplicateNumber(numbers));
    }

    private String findDuplicateNumber(List<Integer> numbers) {
        Integer total_d=0;
        Integer total_r=0;
        Integer cont = 1;
        for (Integer number: numbers){
            total_d+=number;
            total_r+=cont++;
        }
        return total_d -(total_r - numbers.size()) +"";
    }
}
