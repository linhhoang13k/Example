package com.codefights.arcade.intro;

/**
 * Created by zambro on 4/19/17.
 * CodeMaster has just returned from shopping. He scanned the check of the items he bought and gave the resulting string to Ratiorg to figure out the total number of purchased items. Since Ratiorg is a bot he is definitely going to automate it, so he needs a program that sums up all the numbers which appear in the given input.

 Help Ratiorg by writing a function that returns the sum of numbers that appear in the given inputString.

 Example

 For inputString = "2 apples, 12 oranges", the output should be
 sumUpNumbers(inputString) = 14.
 */
public class SumNumbers {
    public static int sumUpNumbers(String inputString) {
        String[] s = inputString.split("[^\\d]");
        int count = 0;
        for(String x : s) {
            if(x.matches("^-?\\d+$")){
                count += Integer.parseInt(x);
            }
        }

        return count;
    }


    public static void main(String[] args) {
        System.out.println(sumUpNumbers("2 apples, 12 orange"));
    }
}
