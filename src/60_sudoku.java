/*
Sudoku is a number-placement puzzle. The objective is to fill a 9 × 9 grid with digits so that each column, each row, and each of the nine 3 × 3 sub-grids that compose the grid contains all of the digits from 1 to 9.

This algorithm should check if the given grid of numbers represents a correct solution to Sudoku.

Example

For the first example below, the output should be true. For the other grid, the output should be false: each of the nine 3 × 3 sub-grids should contain all of the digits from 1 to 9.

Input/Output

    [execution time limit] 3 seconds (java)

    [input] array.array.integer grid

    A matrix representing 9 × 9 grid already filled with numbers from 1 to 9.

    [output] boolean

    true if the given grid represents a correct solution to Sudoku, false otherwise.
*/



/*
The program supposes that the grid represents a sudoku and then checks all the different  
9-number combinations to see if one of them doesn't .
It runs through all the rows, columns and boxes checking the numbers and if one of them 
is not a sudoku then false the method returns false.
*/

boolean sudoku(int[][] grid) {
    boolean isCorrect = true;
    if(!checkBoxes(grid) || !checkRows(grid) || !checkColumns(grid)){
        isCorrect = false;
    }
    return isCorrect;
}

// Given an array of numbers, check if the numbers represent a sudoku
boolean isArrayCorrect(int[] array){
    boolean isCorrect = true;
    int[] sudokuSequence = new int[]{1,2,3,4,5,6,7,8,9};
    Arrays.sort(array);
    for(int index = 0; index < 9; index++){
        if(array[index] != sudokuSequence[index]){
            isCorrect = false;
        }
    }
   return isCorrect;
}

// Check all boxes
boolean checkBoxes(int[][] grid){
    boolean areBoxesCorrect = true;
    int[] array = new int[9];
    int arrayIndex = 0;
    for(int row = 0; row < 9; row+=3){
        for(int column = 0; column < 9; column+=3){
            for(int boxRow = row ; boxRow < row+3; boxRow++){
                for(int boxColumn = column; boxColumn < column+3; boxColumn++){
                    array[arrayIndex] = grid[boxRow][boxColumn];
                    arrayIndex++;
                }
            }
            arrayIndex = 0;
            if(isArrayCorrect(array) == false){
                areBoxesCorrect = false;
                break;
            }
            
        }
    }
    return areBoxesCorrect;
}

// Check all rows
boolean checkRows(int[][] grid){
    boolean areRowsCorrect = true;
    int[] array = new int[9];
    for(int row = 0; row < 9; row++){
        for(int column = 0; column < 9; column++){
            array[column] = grid[row][column];
        }
        if(isArrayCorrect(array) == false){
            areRowsCorrect = false;
            break;
        }
    }
    return areRowsCorrect;
}

// Check all columns
boolean checkColumns(int[][] grid){
    boolean areColumnsCorrect = true;
    int[] array = new int[9];
    for(int column = 0; column < 9; column++){
        for(int row = 0; row < 9; row++){
            array[row] = grid[row][column];
        }
        if(isArrayCorrect(array) == false){
            areColumnsCorrect = false;
            break;
        }
    }
    return areColumnsCorrect;
}

