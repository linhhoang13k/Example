/*
Given a rectangular matrix containing only digits, calculate the number of different 2 × 2 squares in it.

Example

For

matrix = [[1, 2, 1],
          [2, 2, 2],
          [2, 2, 2],
          [1, 2, 3],
          [2, 2, 1]]

the output should be
differentSquares(matrix) = 6.

Here are all 6 different 2 × 2 squares:

    1 2
    2 2
    2 1
    2 2
    2 2
    2 2
    2 2
    1 2
    2 2
    2 3
    2 3
    2 1

Input/Output

    [execution time limit] 3 seconds (java)

    [input] array.array.integer matrix

    Guaranteed constraints:
    1 ≤ matrix.length ≤ 100,
    1 ≤ matrix[i].length ≤ 100,
    0 ≤ matrix[i][j] ≤ 9.

    [output] integer

    The number of different 2 × 2 squares in matrix.
*/

int differentSquares(int[][] matrix) {
    int rows = matrix.length;
    int columns = matrix[0].length;
    int differentBoxes = 0;
    
    //Check if the matrix is not 1x1, 1x2, 2x1
    if(rows > 1 && columns > 1){
        ArrayList<String> boxes = new ArrayList<String>();
        int boxIndex = 0;
        //Save all the 2x2 boxes into strings
        for(int row = 0; row < rows-1 ; row++){
            for(int column = 0; column < columns-1 ; column++){
                boxes.add(Integer.toString(matrix[row][column]) +
                                    Integer.toString(matrix[row+1][column]) +
                                    Integer.toString(matrix[row][column+1]) +
                                    Integer.toString(matrix[row+1][column+1]));
            }
        }
        //Calculate all the unique strings
        long uniqueBoxes = boxes.stream().distinct().count();
        differentBoxes = (int) uniqueBoxes;
       
    }
    return differentBoxes;
}