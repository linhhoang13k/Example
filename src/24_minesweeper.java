/*
In the popular Minesweeper game you have a board with some mines and those cells that don't contain a mine have a number in it that indicates the total number of mines in the neighboring cells. Starting off with some arrangement of mines we want to create a Minesweeper game setup.

Example

For

matrix = [[true, false, false],
          [false, true, false],
          [false, false, false]]

the output should be

minesweeper(matrix) = [[1, 2, 1],
                       [2, 1, 1],
                       [1, 1, 1]]       

Check out the image below for better understanding:

Input/Output

    [execution time limit] 3 seconds (java)

    [input] array.array.boolean matrix

    A non-empty rectangular matrix consisting of boolean values - true if the corresponding cell contains a mine, false otherwise.

    Guaranteed constraints:
    2 ≤ matrix.length ≤ 5,
    2 ≤ matrix[0].length ≤ 5.

    [output] array.array.integer

    Rectangular matrix of the same size as matrix each cell of which contains an integer equal to the number of mines in the neighboring cells. Two cells are called neighboring if they share at least one corner.

*/

int[][] minesweeper(boolean[][] matrix) {
    int xLength = matrix.length;
    int yLength = matrix[0].length;
    int[][] newMatrix = new int[xLength][yLength];
    for(int i = 0; i < xLength; i++){
        for(int j = 0; j < yLength ; j++){
            newMatrix[i][j] = calculateMines(matrix, i, j, xLength-1, yLength-1);
        }
    }
    return newMatrix;
}

int calculateMines(boolean[][] matrix, int i, int j, int maxX,int maxY){
    int minesSum = 0;
    int left = 0;
    int right = 0;
    int down = 0;
    int up = 0;
    int upLeft = 0;
    int upRight = 0;
    int downRight = 0;
    int downLeft = 0;
    // Define all the possible directions for this specific cell
    try{
        left = (matrix[i-1][j]) ? 1 : 0;
    }catch(ArrayIndexOutOfBoundsException exception) {
        
    }
    try{
        right = (matrix[i+1][j]) ? 1 : 0;
    }catch(ArrayIndexOutOfBoundsException exception) {
        
    }
    try{
        down = (matrix[i][j+1]) ? 1 : 0;
    }catch(ArrayIndexOutOfBoundsException exception) {
        
    }
    try{
        up = (matrix[i][j-1]) ? 1 : 0;
    }catch(ArrayIndexOutOfBoundsException exception) {
        
    }
    try{
        upLeft = (matrix[i-1][j-1]) ? 1 : 0;
    }catch(ArrayIndexOutOfBoundsException exception) {
        
    }
    try{
        upRight = (matrix[i+1][j-1]) ? 1 : 0;
    }catch(ArrayIndexOutOfBoundsException exception) {
        
    }
    try{
        downRight = (matrix[i+1][j+1]) ? 1 : 0;
    }catch(ArrayIndexOutOfBoundsException exception) {
        
    }
    try{
        downLeft = (matrix[i-1][j+1]) ? 1 : 0;
    }catch(ArrayIndexOutOfBoundsException exception) {
        
    }

    minesSum = up + upRight + right + downRight + down + downLeft + left + upLeft;
    return minesSum;
    
}

