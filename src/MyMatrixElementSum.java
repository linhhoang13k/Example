/*
 * Author: Luisa McKenna
 * Problem By: CodeFights Level 2
 * 
 * A hotel is represent by a rectangular matrix of rooms, each room
 * contains an integer, the price of the room. Some rooms are 
 * free(their cost is 0). Any room located under a free room can't
 * be used. Calculate the total price of all the rooms that are suitable
 * to house people.
 * 
 */
public class MyMatrixElementSum {
	
	public static int matrixElementsSum(int[][] matrix){

		  int sum = 0;
		  for(int i = 0; i<matrix.length-1; i++){
		    for(int j = 0; j<matrix[0].length; j++){
		      if(matrix[i][j]==0){
		        matrix[i+1][j]=0;
		      }
		    }
		  }
		  
		  for(int k = 0; k<matrix.length; k++){
		    for(int z = 0; z<matrix[0].length; z++){
		      if(matrix[k][z]>0){
		        sum+=matrix[k][z];
		      }
		    }
		  }
		  return sum;
		}
	public static void main(String args[]){
		System.out.println(matrixElementsSum(new int[][]{{0,1,1,2},{0,5,0,0},{2,0,3,3}}));
	}
}
