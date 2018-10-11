package com.jeromewirth;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

public class ArcadeIntro {

    int add(int param1, int param2) {
        return param1 + param2;
    }

    int centuryFromYear(int year) {
        return (int)Math.ceil(year/100.00d);
    }

    boolean checkPalindrome(String inputString) {
        StringBuilder reverseString = new StringBuilder(inputString).reverse();

        return reverseString.toString().equals(inputString);
    }

    int adjacentElementsProduct(int[] inputArray) {
        int result = inputArray[0]*inputArray[1];

        for(int i = 1; i < inputArray.length-1; i++) {
            int temp = inputArray[i]*inputArray[+1];
            if(temp > result) {
                result = temp;
            }
        }

        return result;
    }

    int shapeArea(int n) {
        int area = 1;

        for(int i = 1; i < n; i++) {
            area = area + (i*4);
            System.out.println(area);
        }

        return area;
    }

    int makeArrayConsecutive2(int[] statues) {
        int count = 0;
        int min = Arrays.stream(statues).min().getAsInt();
        int max = Arrays.stream(statues).max().getAsInt();

        Arrays.sort(statues);

        if (statues.length > 2) {
            for(int i = 0; i < statues.length; i++) {
                if(!(statues[i+1] == i+1)) {
                    count++;
                }
            }
        }

        return count;
    }
}
