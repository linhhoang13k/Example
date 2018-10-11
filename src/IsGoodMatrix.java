boolean isGoodMatrix(int[][] matrix) {
    
    if(matrix[0].length ==1 )
    {
        return true;
    }
    
String[] a = new String[matrix.length+matrix[0].length-1];
    for(int i=0; i<a.length; i++)
    {
        a[i] = "";
    }
    
    int c=0;
    
    for(int x=0; x<matrix[0].length; x++)
    {
        for(int i=0; i<matrix.length; i++)
          {
              if( i+x >=matrix[0].length )
              {
                  break;
              }
             a[matrix[0].length-1-x] += Integer.toString(matrix[i][i+x]);
          }
        
    }
    
    for(int x=1; x<matrix.length; x++)
    {
        for(int i=0; i<matrix[0].length; i++)
          {
              if( i+x >=matrix.length )
              {
                  break;
              }
             a[matrix[0].length-1+x] += Integer.toString(matrix[i+x][i]);
          }
        
    }
    
    
    
    for(int i=0; i<a.length; i++)
    {
        for(int j=0; j<a[i].length()-1; j++)
        {
            if(a[i].charAt(j)!=a[i].charAt(j+1))
            {
                return false;
            }
        }
    }
   
    return true;
}
