package com.codefights.arcade.intro;


import java.util.Arrays;
import java.util.Stack;

/**
 * Created by zambro on 3/31/17.
 * You have a string s that consists of English letters, punctuation marks, whitespace characters, and brackets. It is guaranteed that the parentheses in s form a regular bracket sequence.

 Your task is to reverse the strings contained in each pair of matching parentheses, starting from the innermost pair. The results string should not contain any parentheses.

 Example

 For string s = "a(bc)de", the output should be
 reverseParentheses(s) = "acbde".


 */
public class ParanthesesReveser {

    public static String reverseParentheses(String s) {
        char[] arr = s.toCharArray();
        Stack<Integer> position = new Stack<Integer>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '(') {
                position.push(i);
            } else if (arr[i] == ')') {
                int start = position.pop() + 1;
                //Reverse string between start and i
                int end = i - 1;
                while(start < end) {
                    char temp = arr[start];
                    arr[start] = arr[end];
                    arr[end] = temp;
                    start++;
                    end--;
                }
            }
        }

        s = new String(arr);
        s = s.replace("(", "");
        s = s.replace(")", "");
        return s;
    }

    public static void main(String[] args) {
        System.out.println(reverseParentheses("a(bc)de"));
        String s = "hello";
        String s1 = 'x' + s;
    }


}