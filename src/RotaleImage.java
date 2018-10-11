package codefights;

public class RotaleImage 
{
	int[][] rotateImage(int[][] a) 
	{
	    int i,j;
	    int k;
	    int arr[][] = new int[a.length][a.length];
	    for(i=0;i<a.length;i++)
	    {
	        k = a.length - 1;
	        for(j=0;j<a.length;j++)
	        {
	            arr[i][j] = a[k][i];
	            k--;
	        }
	    }
	    return arr;
	}


}
