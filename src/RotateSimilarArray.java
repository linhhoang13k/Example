package com.codefight.arcade;

import java.util.Arrays;

public class RotateSimilarArray {

	public static void main(String[] args) {
		int a[] = {1,2,3};
		int b[] = {2,1,3};
		

		System.out.println(areSimilar(a,b));
	}
	
	static boolean areSimilar(int[] a, int[] b) {
		if(checkEqual(a,b)) return true;
		
		int mLeft[]  = Arrays.copyOf(a, a.length); //Copy of A
		int nLeft[]  = Arrays.copyOf(b, b.length); //Copy of B
		int mRight[] = Arrays.copyOf(a, a.length); //Copy of A
		int nRight[] = Arrays.copyOf(b, b.length); //Copy of B
		
		rotateLeft(mLeft);
		rotateLeft(nLeft);
		rotateRight(mRight);
		rotateRight(nRight);
		
		if(checkEqual(mLeft, b)) 	 	return true;
		if(checkEqual(a,nLeft)) 	 	return true;
		if(checkEqual(mLeft, nLeft)) 	return true;
		if(checkEqual(mRight, b))		return true;
		if(checkEqual(a,nRight))	 	return true;
		if(checkEqual(mRight, nRight))	return true;
		if(checkEqual(mLeft, nRight))	return true;
		if(checkEqual(mLeft, nLeft))	return true;
		if(checkEqual(mRight, nLeft))	return true;
		if(checkEqual(mRight, nRight))	return true;
		return false;
	}
	static boolean checkEqual(int a[], int b[]){
		for(int i=0; i < a.length; i++){
			if(a[i] != b[i]) return false;
		}
		return true;
	}
	static void rotateRight(int arr[]){
		int swap = arr[arr.length-1];
		for(int i= arr.length-1; i>0; i--){
			arr[i] = arr[i-1];
		}
		arr[0] = swap;
	}
	static void rotateLeft(int arr[]){
		int swap = arr[0];
		for (int i= 0; i < arr.length-1;  i++ ) {
			arr[i] = arr[i+1];
		}
		arr[arr.length-1] = swap;
	}
}
