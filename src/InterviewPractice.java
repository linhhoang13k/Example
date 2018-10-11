package com.jeromewirth;

import java.util.*;

public class InterviewPractice {

    int firstDuplicate(int[] a) {

        boolean dublette[] = new boolean[a.length];

        for (int num : a) {
            if (dublette[num - 1]) {
                return num;
            } else {
                dublette[num - 1] = true;
            }
        }

        return -1;
    }

    char firstNotRepeatingCharacter(String s) {

//        int counter = 0;
//
//        for(int i = 0; i < s.length(); i++) {
//            char temp = s.charAt(i);
//            for(int j = 0; j < s.length(); j++) {
//                if(temp == s.charAt(j)) {
//                    counter++;
//                }
//            }
//            if(counter < 2) {
//                return s.charAt(i);
//            } else {
//                counter = 0;
//            }
//        }
//
//        return '_';

        for(int i = 0; i<s.length(); i++) {
            char letter = s.charAt(i);
            if(s.indexOf(letter) == s.lastIndexOf(letter)) {
                return letter;
            }
        }

        return '_';
    }

    int[][] rotateImage(int[][] a) {
        int length = a.length;
        int layer = length / 2;
        int[][] newMatrix = new int[length][length];

        for (int i = 0; i < layer; i++) {
            int first = i;
            int last = length - first - 1;

            for(int j = first; j < last; j++) {
                int offset = j - first;

                int top_element = a[first][j];
                int right_side = a[j][last];
                int bottom = a[last][last-offset];
                int left_side = a[last-offset][first];

                newMatrix[first][j] = top_element;
                newMatrix[j][last] = right_side;
                newMatrix[last][last-offset] = bottom;
                newMatrix[last-offset][first] = left_side;
            }

        }

        return newMatrix;
    }



}
