package Arcade_Intro;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class _55_differentSquares {
    int differentSquares(int[][] matrix) {

        ArrayList<Integer> uniqueSubArrays = new ArrayList<>();
        for(int x = 0; x < matrix[0].length -1; x++){
            for(int y = 0; y < matrix.length -1; y++){
                int[][] smallArray = new int[2][2];
                smallArray[0][0] = matrix[y][x];
                smallArray[0][1] = matrix[y][x+1];
                smallArray[1][0] = matrix[y+1][x];
                smallArray[1][1] = matrix[y+1][x+1];
                if(!uniqueSubArrays.contains(hashValue(smallArray)))
                    uniqueSubArrays.add(hashValue(smallArray));
            }
        }
        return uniqueSubArrays.size();
    }

    private int hashValue(int[][] smallArray){
        return Integer.parseInt(
                Integer.toString(smallArray[0][0]) +
                Integer.toString(smallArray[0][1]) +
                Integer.toString(smallArray[1][0]) +
                Integer.toString(smallArray[1][1]));
    }
}
