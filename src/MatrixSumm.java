package test;

public class MatrixSumm {
	
	int matrixElementsSum(int[][] matrix) {
		int sum = 0;
		    for (int i=0 ; i<matrix.length;i++)
		    {
		        for (int j =0 ; j<matrix.length;j++)
		        {
		        	if(i==0)
		            sum = sum + matrix[i][j];
		        	else
		        	{
		        		if (matrix[i-1][j] !=0)
		        			sum = sum + matrix[i][j];
		        	}
		        }
		    }
		    return sum;
		}
	
	public static void main(String[] arg)
	{
	int matrix[][] = {{0,1,1,2}, 
			 {0,5,0,0}, 
			 {2,0,3,3}};
	MatrixSumm s = new MatrixSumm();
	System.out.println(s.matrixElementsSum(matrix));
	}

}
