int differentSquares(int[][] matrix) {
    List<List<Integer>> arr = new ArrayList<>();
    
    for (int i=0;i<matrix.length-1;i++) {
        for (int j=0;j<=matrix[0].length-2;j++) {
            List<Integer> temp = new ArrayList<>();
            temp.add(matrix[i][j]);
            temp.add(matrix[i][j+1]);
            temp.add(matrix[i+1][j]);
            temp.add(matrix[i+1][j+1]);
            
            if (!arr.contains(temp)) {
                arr.add(temp);
            }
        }
    }
    
    return arr.size();
}
