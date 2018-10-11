/*
You are given an n x n 2D matrix that represents an image. Rotate the image by 90 degrees (clockwise).
*/

public class MatrixTwister{

	public static void main(String[] args){
		int[][] test1 = {
			{1,2,3},
			{4,5,6},
			{7,8,9}
			};
		int[][] test2 = {
			{1,2,3,4},
			{12,13,14,5},
			{11, 16, 15, 6},
			{10, 9, 8, 7}
		};
		int[][] test3 = {
			{1,2,3,4,5},
				{16,17,18,19,6},
				{15, 24,25,20,7},
				{14,23,22,21,8},
				{13,12,11,10,9}
		};
		int[][] test4 = {
			{1,2,3,4,5,6},
			{7,8,9,10,11,12},
			{13,14,15,16,17,18},
			{19,20,21,22,23,24},
			{25,26,27,28,29,30},
			{31,32,33,34,35,36}
		};
		printCWMatrixImage(test4);
	}
	
	public static void printCWMatrixImage(int[][] arr){
		
		
		for (int i = 0; i < arr.length; i++){
			for (int j = 0; j < arr[0].length; j++){
				if (arr[i][j] < 10){
					System.out.print(arr[i][j] + "  ");
				}
				else{
					System.out.print(arr[i][j] + " ");
				}
			}
			System.out.println();
		}
		
		System.out.println();
		for (int j = 0; j < arr.length / 2; j++){
			for (int i = 0; i < arr.length; i++){
				int copy = arr[j][i];
				arr[j][i] = arr[arr.length-1-j][i];
				arr[arr.length-1-j][i] = copy;
			}
		} //swaps all rows
		
		//ever spot equal to its row/colum backwards 
		
		for (int i = 0; i < arr.length; i++){
			for (int j = i + 1; j < arr.length; j++){
				int copy = arr[i][j];
				arr[i][j] = arr[j][i];
				arr[j][i] = copy;
			}
		}
		
		
		/*
		for (int j = 0; j < arr.length / 2; j++){
			for (int i = 0 + j; i < arr.length - 1 - j; i++){
				int copy = arr[j][i + j];
				arr[j][i+j] = arr[arr.length - 1 - i - j][j];
				arr[arr.length - 1 - i - j][j] = arr[arr.length-1-j][arr.length-1-i-j];
				arr[arr.length-1-j][arr.length-1-i-j] = arr[i+j][arr.length-1-j];
				arr[i+j][arr.length-1-j] = copy;
			}
		}
		*/
		
		/*
		int j = 0;
		
		for (int i = 0; i < arr.length - 1; i++){
			int copy = arr[0][i];
			arr[0][i] = arr[arr.length - 1 - i][0];
			arr[arr.length - 1 - i][0] = arr[arr.length-1][arr.length-1-i];
			arr[arr.length-1][arr.length-1-i] = arr[i][arr.length-1];
			arr[i][arr.length - 1] = copy;
		}
		//Rotates outer most row/column
		*/  
		
		
		for (int i = 0; i < arr.length; i++){
			for (int j = 0; j < arr[0].length; j++){
				if (arr[i][j] < 10){
					System.out.print(arr[i][j] + "  ");
				}
				else{
					System.out.print(arr[i][j] + " ");
				}
			}
			System.out.println();
		}
		System.out.println();
	}
}