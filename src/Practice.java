package com.company;

import java.util.Arrays;

public class Practice {
    int adjacentElementsProduct(int[] inputArray) {
        int aux, left, right, max = 0;
        for(int i=0; i<inputArray.length; i++){
            if(i == 0){
                max = inputArray[i] * inputArray[i+1];
            } else if(i != inputArray.length-1){
                left = inputArray[i] * inputArray[i-1];
                if(left > max){
                    max = left;
                }
                right = inputArray[i] * inputArray[i+1];
                if(right > max){
                    max = right;
                }
            } else {
                left = inputArray[i] * inputArray[i-1];
                if(left > max){
                    max = left;
                }
            }
        }
        return max;
    }

    int shapeArea(int n) {
        int aux = 4;
        int res = 0;
        if (n == 1){
            return 1;
        } else if (n == 2) {
            return 5;
        } else {
            for (int i=2; i<=n; i++){
                res += (i-1) * aux;
            }
            return res;
        }
    }

    int makeArrayConsecutive2(int[] statues) {
        Arrays.sort(statues);
        int inicio = statues[0],fin = statues[statues.length - 1], cont = 0;
        for (int i=1; i<statues.length; i++){
            inicio++;
            if (inicio != statues[i]){
                cont++;
                i--;
            }
        }
        return cont;
    }

    boolean almostIncreasingSequence(int[] sequence) {
        int numErr = 0;
        for (int i = 0; i < sequence.length - 1; i++) {
            if (sequence[i] - sequence[i+1] >= 0) {
                numErr += 1;
                if (i - 1 >= 0 && i + 2 <= sequence.length - 1
                        && sequence[i] - sequence[i+2] >= 0
                        && sequence[i-1] - sequence[i+1] >= 0) {
                    return false;
                }
            }
        }
        return numErr <= 0;
    }

    int matrixElementsSum(int[][] matrix) {
        int res = 0;
        for (int i=0; i<matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                //if (matrix[i])
            }
        }
        return res;
    }

}
