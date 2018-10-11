package br.com.codefights.arrays;

public class RotateImage {
	
	public int[][] test( int a[][]){
		int r = a.length;
		int c = a.length;
		int l;
		int k;
		
		
		int b[][] = new int[r][c]; 
		l=3;
		 
		for(int i=0;i<r;i++)
		{
		  k=0;
		  l--;  
		 for(int j=0;j<c;j++)
		  {
		   b[k][l]=a[i][j];
		   k++;
		  }
		}
		
		return b;
	}
	
	
	public int[][] rotateImage2(int[][] a) {
		 int r = a.length;
				int c = a.length;
				int l;
				int k;
				
				
				int b[][] = new int[r][c]; 
				l= a.length;;
				 
				for(int i=0;i<r;i++)
				{
				  k=0;
				  l--;  
				 for(int j=0;j<c;j++)
				  {
				   b[k][l]=a[i][j];
				   k++;
				  }
				}
				
				return b;
		}
	
	
	int[][] rotateImage3(int[][] a) {
	    int n = a.length;
	    for(int i = 0; i < n / 2; i++){
	        for(int j = i; j < n-i-1; j++){
	            int temp = a[i][j];
	            a[i][j] = a[n-j-1][i];
	            a[n-j-1][i] = a[n-1-i][n-1-j];
	            a[n-1-i][n-1-j] = a[j][n-1-i];
	            a[j][n-1-i] = temp;
	        }
	    }
	    return a;
	}
	
	
	int[][] rotateImage4(int[][] a) {
	    
	    int n = a.length;
	    
	     for (int layer = 0; layer < Math.ceil(n / 2.0); ++layer) {
	        int first = layer;
	        int last = n - 1 - layer;
	        for(int i = first; i < last; ++i) {
	            int offset = i - first;
	            int top = a[first][i]; // save top

	            // left -> top
	            a[first][i] = a[last-offset][first];          

	            // bottom -> left
	            a[last-offset][first] = a[last][last - offset]; 

	            // right -> bottom
	            a[last][last - offset] = a[i][last]; 

	            // top -> right
	            a[i][last] = top; // right <- saved top
	        }
	    }
	     
	   
	    
	    return a;
	        
	     
	  
	    

	}

}
