/*
Construct a square matrix with a size N × N containing integers from 1 to N * N in a spiral order, starting from top-left and in clockwise direction.

Example

For n = 3, the output should be

spiralNumbers(n) = [[1, 2, 3],
                    [8, 9, 4],
                    [7, 6, 5]]

Input/Output

    [execution time limit] 3 seconds (java)

    [input] integer n

    Matrix size, a positive integer.

    Guaranteed constraints:
    3 ≤ n ≤ 10.

    [output] array.array.integer
*/
    
int[][] spiralNumbers(int n) {
    int size = n;
    int[][] spiral = new int[size][size];
    int circles = (size/2) + (size%2);

    int index = 1;
    for(int circle = 0; circle < circles ; circle++){
        //Move right
        for(int column = circle ; column < size-1 ; column++){
            spiral[circle][column] = index++;
        }
        //Move down
        for(int row = circle ; row < size-1 ; row++){
            spiral[row][size-1] = index++;
        }
        //Move left
        for(int column = size-1 ; column > circle; column--){
            spiral[size-1][column] = index++;
        }
        //Move up
        for(int row = size-1 ; row > circle; row--){
            spiral[row][circle] = index++;
        }
        size--;
    }
    
    if(n%2 == 1){
        spiral[circles-1][circles-1] = n*n;
    }
    
    return spiral;
}
