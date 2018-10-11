package com.github.chen0040.codefights.arrays;


import java.util.HashSet;
import java.util.Set;


/**
 * Created by xschen on 3/8/2017.
 *
 * Sudoku is a number-placement puzzle. The objective is to fill a 9 × 9 grid with numbers in such a way that each column, each row, and each of the nine 3 × 3 sub-grids that compose the grid all contain all of the numbers from 1 to 9 one time.

 Implement an algorithm that will check whether the given grid of numbers represents a valid Sudoku puzzle according to the layout rules described above. Note that the puzzle represented by grid does not have to be solvable.

 Example

 For

 grid = [['.', '.', '.', '1', '4', '.', '.', '2', '.'],
 ['.', '.', '6', '.', '.', '.', '.', '.', '.'],
 ['.', '.', '.', '.', '.', '.', '.', '.', '.'],
 ['.', '.', '1', '.', '.', '.', '.', '.', '.'],
 ['.', '6', '7', '.', '.', '.', '.', '.', '9'],
 ['.', '.', '.', '.', '.', '.', '8', '1', '.'],
 ['.', '3', '.', '.', '.', '.', '.', '.', '6'],
 ['.', '.', '.', '.', '.', '7', '.', '.', '.'],
 ['.', '.', '.', '5', '.', '.', '.', '7', '.']]
 the output should be
 sudoku2(grid) = true;

 For

 grid = [['.', '.', '.', '.', '2', '.', '.', '9', '.'],
 ['.', '.', '.', '.', '6', '.', '.', '.', '.'],
 ['7', '1', '.', '.', '7', '5', '.', '.', '.'],
 ['.', '7', '.', '.', '.', '.', '.', '.', '.'],
 ['.', '.', '.', '.', '8', '3', '.', '.', '.'],
 ['.', '.', '8', '.', '.', '7', '.', '6', '.'],
 ['.', '.', '.', '.', '.', '2', '.', '.', '.'],
 ['.', '1', '.', '2', '.', '.', '.', '.', '.'],
 ['.', '2', '.', '.', '3', '.', '.', '.', '.']]
 the output should be
 sudoku2(grid) = false.

 The given grid is not correct because there are two 1s in the second column. Each column, each row, and each 3 × 3 subgrid can only contain the numbers 1 through 9 one time.

 Input/Output

 [time limit] 3000ms (java)
 [input] array.array.char grid

 A 9 × 9 array of characters, in which each character is either a digit from '1' to '9' or a period '.'.

 [output] boolean

 Return true if grid represents a valid Sudoku puzzle, otherwise return false.
 */
public class Sudoku2 {
   public class Solution {
      boolean sudoku2(char[][] grid) {
         for(int i=0; i < 3; ++i) {

            for(int j=0; j < 3; ++j) {
               Set<Character> exists = new HashSet<Character>();
               for(int k=0; k < 3; ++k) {
                  int row = i * 3 + k;
                  for(int k2 = 0; k2 < 3; ++k2) {
                     int col = j * 3 + k2;
                     char c = grid[row][col];
                     if(c != '.') {
                        if(exists.contains(c)) {
                           return false;
                        }
                        exists.add(c);
                     }
                  }
               }
            }
         }

         for(int i=0; i < 9; ++i) {
            Set<Character> exists1 = new HashSet<Character>();
            Set<Character> exists2 = new HashSet<Character>();
            for(int j=0; j < 9; ++j) {
               char c = grid[i][j];
               if(c != '.') {
                  if(exists1.contains(c)) {
                     return false;
                  }
                  exists1.add(c);
               }
               char c2 = grid[j][i];
               if(c2 != '.') {
                  if(exists2.contains(c2)) {
                     return false;
                  }
                  exists2.add(c2);
               }
            }
         }

         return true;

      }

   }
}
