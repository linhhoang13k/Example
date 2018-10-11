package com.codefight.interviewpractice;

import java.util.HashSet;
import java.util.Set;

public class Sudoku2DArray {

	public static void main(String[] args) {
		char[][]  grid1 = {{'.', '.', '.', '1', '4', '.', '.', '2', '.'},
				 		  {'.', '.', '6', '.', '.', '.', '.', '.', '.'},
				 		  {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
				 		  {'.', '.', '1', '.', '.', '.', '.', '.', '.'},
				 		  {'.', '6', '7', '.', '.', '.', '.', '.', '9'},
				 		  {'.', '.', '.', '.', '.', '.', '8', '1', '.'},
				 		  {'.', '3', '.', '.', '.', '.', '.', '.', '6'},
				 		  {'.', '.', '.', '.', '.', '7', '.', '.', '.'},
				 		  {'.', '.', '.', '5', '.', '.', '.', '7', '.'}};
		System.out.println(sudoku2(grid1));//true
		
		char[][] grid2 = {{'.', '.', '.', '.', '2', '.', '.', '9', '.'},
						 {'.', '.', '.', '.', '6', '.', '.', '.', '.'},
						 {'7', '1', '.', '.', '7', '5', '.', '.', '.'},
		                 {'.', '7', '.', '.', '.', '.', '.', '.', '.'},
		                 {'.', '.', '.', '.', '8', '3', '.', '.', '.'},
		                 {'.', '.', '8', '.', '.', '7', '.', '6', '.'},
		                 {'.', '.', '.', '.', '.', '2', '.', '.', '.'},
		                 {'.', '1', '.', '2', '.', '.', '.', '.', '.'},
		                 {'.', '2', '.', '.', '3', '.', '.', '.', '.'}};
		System.out.println(sudoku2(grid2));//false
		
		char[][] grid3 = {{'.', '.', '.', '9', '.', '.', '.', '.', '.'}, 
				         {'.', '.', '.', '.', '.', '.', '.', '.', '.'}, 
				         {'.', '.', '3', '.', '.', '.', '.', '.', '1'}, 
				         {'.', '.', '.', '.', '.', '.', '.', '.', '.'}, 
				         {'1', '.', '.', '.', '.', '.', '3', '.', '.'}, 
				         {'.', '.', '.', '.', '2', '.', '6', '.', '.'}, 
				         {'.', '9', '.', '.', '.', '.', '.', '7', '.'}, 
				         {'.', '.', '.', '.', '.', '.', '.', '.', '.'}, 
				         {'8', '.', '.', '8', '.', '.', '.', '.', '.'}};
		System.out.println(sudoku2(grid3));//false

	}

	static boolean sudoku2(char[][] grid) {
		for(int i=0; i<3; i++){
			for(int j=0; j<3; j++){
				Set<String> sudoku1 =  new HashSet<>();
				for(int m=0; m<3; m++){
					for(int n=0; n<3; n++){
						int row = i*3 + m;
						int col = j*3 + n;
						char c = grid[row][col];
						if(c != '.'){
							if(sudoku1.contains(String.valueOf(c))){
								return false;
							}else{
								sudoku1.add(String.valueOf(c));
							}
						}
						
					}
				}
			}
		}
		
		for(int i=0; i<9; i++){
			Set<String> sudoku2 = new HashSet<>();
			Set<String> sudoku3 = new HashSet<>();
			for(int j=0; j<9; j++){
				char row = grid[i][j];
				if(row != '.'){
					if(sudoku2.contains(String.valueOf(row))){
						return false;
					}else{
						sudoku2.add(String.valueOf(row));
					}
				}
				char col = grid[j][i];
				if(col != '.'){
					if(sudoku3.contains(String.valueOf(col))){
						return false;
					}else{
						sudoku3.add(String.valueOf(col));
					}
				}
			}
		}
		
		return true;
	}
}
