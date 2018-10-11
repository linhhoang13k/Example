package com.codefight.challanges;
/**
 * 
 * @author muralimanohar
 *This is a reverse challenge, enjoy!
 *
 *A reverse challenge is a special type of challenge, where no description is provided! 
 *You have to solve two challenges in one: find out what the author wants from you and 
 *write a solution. Check out this page for more information.
 *
 *Input/Output
 *
 *[execution time limit] 3 seconds (java)
 *
 *[input] integer x
 *
 *Guaranteed constraints:
 *1≤ x ≤ 100.
 *
 *[output] array.array.integer
 *
 *A matrix of integers
 * 
 * 1    2    3    4   
 * 5    6    7    8   
 * 9    10   11   12   
 * 13   14   15   16   
 *-------------------
 * 1    5    9    13   
 * 2    6    7    14   
 * 3    10   11   15   
 * 4    8    12   16  
 *
 * 1    2    3    4    5    6   
 * 7    8    9    10   11   12   
 * 13   14   15   16   17   18   
 * 19   20   21   22   23   24   
 * 25   26   27   28   29   30   
 * 31   32   33   34   35   36   
 * -------------------
 * 1    7    13   19   25   31   
 * 2    8    9    10   11   32   
 * 3    14   15   16   17   33   
 * 4    20   21   22   23   34   
 * 5    26   27   28   29   35   
 * 6    12   18   24   30   36   

 */
public class InvertPictureFrame {

	public static void main(String[] args) {
		int x = 6;
		int f = 1;
		int[][] printArr = invertPictureFrame(x);
		for(int i=0; i < x; i++){
			for(int j=0; j < x; j++){
				System.out.print(f++ + "   ");
			}
			System.out.println();
		}
		System.out.println("-------------------");
		for (int[] is : printArr) {
			for (int o : is) {
				System.out.print(o + "   ");
			}
			System.out.println();
		}
	}
	
	static int[][] invertPictureFrame(int x) {
		   int array[][] = new int[x][x];
		   int f = 1;
		   for(int i=0; i <x; i++){ 
			   for(int j=0; j < x; j++){
				   if(j==0) array[i][j]=f++; //first column
				   if(i>0 && j==0) array[j][i]=array[j][i-1]+x; //first row
				   if(i==(x-1) && j > 0) array[x-1][j] = array[x-1][j-1]+x; //last row
			   }
		   }

		   for(int i=0;i <x;i++){
			   for(int j=0; j<x; j++){
				   if(i>0 && j== (x-1) ) array[i][x-1] = array[i-1][x-1]+1;//last column
				   if(i>0 && i < (x-1) && j>0 && j < (x-1)) array[i][j]=++f;
			   }
			   if(i>0 && i < (x-1) ) {
				   f = f + 2 + (x%2) - (x%2);
			   }
			   
		   }
		   return array;
		}

	/*
	 * 
		1   2    3    4   
		5   6    7    8   
		9   10   11   12   
		13  14   15   16   
		-------------------
		1   5    9    13   
		2   6    7    14   
		3   10   11   15   
		4   8    12   16   
	 */

}
