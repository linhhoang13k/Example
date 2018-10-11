package com.paigeruppel.interviewpractice.arrays;

public class Rotation {

	/*
	 * Note: Try to solve this task in-place (with O(1) additional memory), since
	 * this is what you'll be asked to do during an interview.
	 * 
	 * You are given an n x n 2D matrix that represents an image. Rotate the image
	 * by 90 degrees (clockwise).
	 */
	
	public int[][] rotateImage(int[][] a) {
		int maxInd = a.length - 1;
		int[][] rotated = new int[a.length][a.length];
		
		for (int row = 0; row < a.length; row++) {
			for (int col = 0; col < a[0].length; col++) {
				int newRow = col;
				int newCol = maxInd - row;
				rotated[newRow][newCol] = a[row][col];
			}
		}

		return rotated;
	}

}
