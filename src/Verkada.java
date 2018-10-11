package com.taidev198.game.CodingInterview.Companies.Verkada;

import java.util.Arrays;

public class Verkada {

    static double[][] blurFaces(int[][] img) {
        int row = img.length;
        int col = img[0].length;
        double[][] ans = new double[row][col];

        for(int i =0; i< row; i++){
            for(int j =0; j< col; j++){

                double totalNum = 0;
                double countNeighbors = 0;
                if(i < row -1){
                    totalNum += img[i+1][j];
                    countNeighbors++;
                }

                if(j < col -1){
                    countNeighbors++;
                    totalNum += img[i][j+1];
                }

                if(i >0 ) {
                    totalNum += img[i-1][j];
                    countNeighbors++;
                }
                if(j >0) {
                    totalNum += img[i][j-1];
                    countNeighbors++;
                }
                if(i < row -1 && j < col -1) {
                    countNeighbors++;
                    totalNum += img[i+1][j+1];
                }
                if(i > 0 && j < col -1) {
                    totalNum += img[i-1][j+1];
                    countNeighbors++;
                }
                if(i >0 && j > 0) {
                    totalNum += img[i-1][j-1];
                    countNeighbors++;
                }
                if(i < row -1 && j > 0) {
                    totalNum += img[i+1][j-1];
                    countNeighbors++;
                }
                ans[i][j] = totalNum / countNeighbors;
            }
        }
        return ans;

    }
    //count the number of neighbors.
   static int countNeighbors(int row, int col, int i, int j){
        int numberNeighbors = 0;
        if(i == 0 || i == row -1){
            if(j == 0 || j == col -1)
                numberNeighbors = 3;
            else
                numberNeighbors = 5;
        }else  {
            if(j == 0 || j == col -1)
                numberNeighbors = 5;
            else
                numberNeighbors = 8;
        }
        return numberNeighbors;
    }

    public static void main(String...args){

        System.out.println(Arrays.deepToString(blurFaces(new int[][]{
                {3, 0, 2, 5},
                {1, 2, 3, 4},
                {2, 3, 2, 3}})));
    }

}
