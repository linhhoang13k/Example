/*
Given a rectangular matrix and an integer column, return an array containing the elements of the columnth column of the given matrix (the leftmost column is the 0th one).

Example

For

matrix = [[1, 1, 1, 2], 
          [0, 5, 0, 4], 
          [2, 1, 3, 6]]
and column = 2, the output should be
extractMatrixColumn(matrix, column) = [1, 0, 3].
*/

int[] extractMatrixColumn(int[][] matrix, int column) {
 
    ArrayList<Integer> arr = new ArrayList<>();
    
    for(int i=0; i<matrix.length; i++)
    {
        arr.add(matrix[i][column]);
    }
   
    int[] ret = new int[arr.size()];
    for (int i=0; i < ret.length; i++)
    {
        ret[i] = arr.get(i).intValue();
    }
    return ret;
    
    
}
