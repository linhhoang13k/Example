package Arcade_Intro;

import java.util.ArrayList;
import java.util.Arrays;

public class _60_sudoku {
    boolean sudoku(int[][] grid) {
        // Check each "subsquare"
        for(int row = 0; row < 9; row+=3){
            for(int column = 0; column < 9; column+=3){
                if(!checkSquares(grid, row, column))
                    return false;
            }
        }

        // Check each row
        for(int row = 0; row < 9; row++){
            if(Arrays.stream(grid[row]).distinct().count() != 9) return false;
        }

        // Check each column
        for(int col = 0; col < 9; col++){
            if(!checkColumn(grid, col)) return false;
        }

        return true;
    }

    boolean checkColumn(int[][] grid, int columnIndex){
        ArrayList<Integer> list = new ArrayList<>();
        for(int row = 0; row < 9; row++){
            list.add(grid[row][columnIndex]);
        }
        if(Arrays.stream(list.toArray()).distinct().count() != 9) return false;
        return true;
    }

    boolean checkSquares(int[][] grid, int baseX, int baseY){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(grid[baseX][baseY]);
        list.add(grid[baseX][baseY+1]);
        list.add(grid[baseX][baseY+2]);

        list.add(grid[baseX+1][baseY]);
        list.add(grid[baseX+1][baseY+1]);
        list.add(grid[baseX+1][baseY+2]);

        list.add(grid[baseX+2][baseY]);
        list.add(grid[baseX+2][baseY+1]);
        list.add(grid[baseX+2][baseY+2]);
        long numDistinctElem = Arrays.stream(list.toArray()).distinct().count();
        if(numDistinctElem == 9) return true;
        return false;
    }
}
