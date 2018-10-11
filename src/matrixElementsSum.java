package test;
/*
 * After becoming famous, CodeBots decided to move to a new building and live together. The building is represented by a rectangular matrix of rooms, each cell containing an integer - the price of the room. Some rooms are free (their cost is 0), but that's probably because they are haunted, so all the bots are afraid of them. That is why any room that is free or is located anywhere below a free room in the same column is not considered suitable for the bots.

Help the bots calculate the total price of all the rooms that are suitable for them.

Example

For

matrix = [[0, 1, 1, 2], 
          [0, 5, 0, 0], 
          [2, 0, 3, 3]]
the output should be
matrixElementsSum(matrix) = 9.

Here's the rooms matrix with unsuitable rooms marked with 'x':
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class matrixElementsSum {

	int matrixElementsSum(int[][] matrix) {
		
		Map<Integer,Integer> matrixElements = new HashMap<Integer,Integer>();
		int sum = 0;
		
		 for (int i=0 ; i<matrix.length;i++)
		    {
		        for (int j =0 ; j<matrix[i].length;j++)
		        {
		        
		        	
                if (matrix[i][j] == 0)
                	matrixElements.put(j, j);
                
                if (i == 0)
		        	sum =  sum+matrix[i][j];
                else 
                	{
                		if(! matrixElements.containsKey(j)  )
                		{
                			System.out.println(matrix[i][j]);
                			sum = sum + matrix[i][j];
                		}
                	}
		        	
		        }
		    }
 return sum;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int matrix[][] = {{0,1,1,2}, 
				 {0,5,0,0}, 
				 {2,0,3,3}};
		matrixElementsSum s = new matrixElementsSum();
		System.out.println(s.matrixElementsSum(matrix));
		
		

	}

}
