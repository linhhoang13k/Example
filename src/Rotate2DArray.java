package com.codefight.interviewpractice;

public class Rotate2DArray {

	public static void main(String[] args) {
		int a[][] = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12},{13,14,15,16}};
		int result[][] = rotateImage(a);
		for(int i=0; i< result.length;i++){
			for(int j=0; j< result.length; j++){
				System.out.print(result[i][j] + " ");
			}
			System.out.println();
		}
	}

	static int[][] rotateImage(int[][]a){
		int len = a.length;
		int[][] result = new int [len][len];
		for(int i=0 ; i <= len-1; i++){
			for(int j=len-1, m=0; j >=0; j--,m++){
				result[i][m] = a[j][i];
			}
		}
		return result;
	}
	
}
