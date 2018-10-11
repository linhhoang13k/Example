//incomplete
public class submatrix 
{
	public static void main(String v[])
	{
		int[][] matrix = { {1, 2, 3, 4},
						   {5, 6, 7, 8},
			               {9, 0, 11, 10}
						 };
		int[] rowsToDelete = {1};
		int[] columnsToDelete = {0,2};
		System.out.println(constructSubmatrix(matrix, rowsToDelete, columnsToDelete));
	}
	static int[][] constructSubmatrix(int[][] matrix, int[] rowsToDelete, int[] columnsToDelete) 
	{
	    int[][] submat = new int[matrix.length-rowsToDelete.length][matrix[0].length-columnsToDelete.length];
	    int x = 0;
	    int y = 0;
	    while(x!=rowsToDelete.length)
	    {
	    	while(y!=columnsToDelete.length)
	    	{
	    		for(int i=0; i<submat.length; i++)
	    		{
	    			for(int j=0; j<submat[0].length; j++)
	    			{
	    				if(i!=rowsToDelete[x])
	    				{
	    					if(j!=columnsToDelete[y])
	    						submat[i][j] = matrix[i][j];
	    					System.out.println(submat[i][j]);
	    				}
	    			}
	    		}
	    		y++;
	    	}
	    	x++;
	    }
	    return submat;
	}


}
