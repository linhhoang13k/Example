class ValidSudoku{
boolean sudoku2(char[][] grid) {
    
   HashSet<Character> rowSet;
   HashSet<Character> columnSet;
   HashSet<Character> boxSet;
   
    for(int i = 0 ; i < 9 ; i++){
        
            
            rowSet = new HashSet<Character>();
            columnSet = new HashSet<Character>();
            boxSet = new HashSet<Character>();
            
            for(int j = 0 ; j < 9 ; j++){
                if(grid[i][j] != '.' && !rowSet.add(grid[i][j]) )
                   return false;
                if(grid[j][i] != '.' && !columnSet.add(grid[j][i]))
                   return false;
                 
                int row = i/3*3 + j/3;
                int column = i%3*3 + j%3;
                   
                                                            
                if(grid[row][column] != '.' && !boxSet.add(grid[row][column]))
                   return false;
            }
                   rowSet.clear();
                   columnSet.clear();
                   boxSet.clear();
                   }
                   return true;
                   }

}
