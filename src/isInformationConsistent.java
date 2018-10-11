boolean isInformationConsistent(int[][] a) {
   for(int i = 0 ; i < a[0].length ;i++){
        int c = 0, b = 0;
        for(int j = 0 ; j < a.length ;j++){
            if(a[j][i] == 1)
                c = 1;
            if(a[j][i] == -1)
                b = 1;
        }
        if( b * c != 0)
            return false;
   }
    return true;
}

https://codefights.com/tournaments/RWEGdtB8xHyeSAPiX/C

/*
allowed to move to an adjacent cell, i.e. to a cell that shares a common side with the one you are standing on now. 
It is prohibited to visit any cell more than once.

Check if it is possible to visit all the cells of the matrix in the order of increasing numbers in the cells, i.e. 
get to the cell with the number 2 on the first turn, then move to 3, etc.

matrix = [[1, 4, 5], 
          [2, 3, 6]]
the output should be
findPath(matrix) = true;

For

matrix = [[1, 3, 6], 
          [2, 4, 5]]
the output should be
findPath(matrix) = false.
*/
