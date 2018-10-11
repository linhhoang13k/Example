int findmines(boolean[][] matrix,int i,int j)
{
    int count=0;

        if(i-1>=0 && j-1>=0 && matrix[i-1][j-1])
        {
            count+=1;
        }
        if(i-1>=0 && matrix[i-1][j])
        {
            count+=1;
        }
        if(i-1>=0 && j+1<matrix[0].length && matrix[i-1][j+1])
        {
            count+=1;
        }
        if(j-1>=0 && matrix[i][j-1])
        {
            count+=1;
        }
        if(j+1<matrix[0].length && matrix[i][j+1])
        {
            count+=1;
        }
        if(i+1<matrix.length && j-1>=0 && matrix[i+1][j-1])
        {
            count+=1;
        }
        
        if(i+1<matrix.length && matrix[i+1][j])
        {
            count+=1;
        }

        if(i+1<matrix.length && j+1<matrix[0].length && matrix[i+1][j+1])
        {
            count+=1;
        }
       return count;
}
int[][] minesweeper(boolean[][] matrix) {
    
    int numrow=matrix.length,numcol=matrix[0].length;
    int res[][]=new int[numrow][numcol];
    
    for(int i=0;i<numrow;i++)
    {
        for(int j=0;j<numcol;j++)
        {
                res[i][j]=findmines(matrix,i,j);
        }
        
    }
    
    return res;

}
