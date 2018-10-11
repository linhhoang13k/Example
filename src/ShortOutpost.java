package tiendm.codefight.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ShortOutpost {
	List<Integer> shuffledArray(int[] shuffled) {
		int sum  = 0;
		for(int i : shuffled){
			sum+=i;
		}
		int half = sum/2;
		List<Integer> lsResult = new ArrayList<>();
		boolean added = false;
		for(int i = 0; i < shuffled.length; i++){
			if(shuffled[i]!=half){
				lsResult.add(shuffled[i]);
			}else {
				if(!added){
					added = true;
				} else {
					lsResult.add(shuffled[i]);
				}
			}
		}
		Collections.sort(lsResult);
		return lsResult;
	}
	
	////////////////////////////////////////////////
	int[] sortByHeight(int[] a) {
		List<Integer> lsPeople = new ArrayList<>();
		for(int i = 0; i < a.length;i++){
			if(a[i] != -1) {
				lsPeople.add(a[i]);
				a[i] = 0;
			}
		}
		Collections.sort(lsPeople);
		int count = 0;
		for(int i = 0; i < a.length; i++){
			if(a[i] == 0) a[i] = lsPeople.get(count++);
		}
		return a;
	}
	
	////////////////////////////////////////////////
	String[] sortByLength(String[] inputArray) {
		for(int i = 1; i < inputArray.length; i++){
			int n = i;
			while(n > 0 && inputArray[n].length() < inputArray[n-1].length()){
				swapString(inputArray, n, n-1);
				n--;
			}
		}
		return inputArray;
	}
	
	void swapString(String[] inputArr, int i, int j){
		String tmp = inputArr[i];
		inputArr[i] = inputArr[j];
		inputArr[j] = tmp;
	}
	
	///////////////////////////////////////////////
	boolean boxesPacking(int[] length, int[] width, int[] height) {
		for(int i = 0; i < length.length-1; i++){
			for(int j = i+1; j < length.length; j++){
				if(!checkInside(length[i], width[i], height[i], length[j], width[j], height[j])) return false;
			}
		}
		return true;
	}
	
	boolean checkInside(int l1,int w1,int h1,int l2,int w2,int h2){
		int min1 = Math.min(Math.min(l1, w1), h1);
		int max1 = Math.max(Math.max(l1, w1), h1);
		int mid1 = (l1+w1+h1-min1-max1);
		int min2 = Math.min(Math.min(l2, w2), h2);
		int max2 = Math.max(Math.max(l2, w2), h2);
		int mid2 = (l2+w2+h2-min2-max2);
		return  (min1 - min2 > 0 && max1 - max2 > 0 && mid1 - mid2 > 0) 
					|| (min1 - min2 < 0 && max1 - max2 < 0 && mid1 - mid2 < 0);
	}
	
	////////////////////////////////////////////////
	int maximumSum(int[] arr, int[][] queries) {
		Arrays.sort(arr);
		int[] frequency = new int[arr.length];
		for(int i = 0; i < queries.length; i++){
			for(int j = queries[i][0]; j <= queries[i][1]; j++){
				frequency[j]++;
			}
		}
		int sum = 0;
		Arrays.sort(frequency);
		for(int i = 0; i < frequency.length; i++){
			sum += arr[i] * frequency[i];
		}
		return sum;
	}
	
	//////////////////////////////////////////////////
	boolean rowsRearranging(int[][] matrix) {
		String[] strCol = new String[matrix[0].length];
		for(int i = 0; i < matrix[0].length; i++){
			strCol[i] = getStringOrd(matrix,i);
			if(strCol[i].equals(" ")) return false;
			if(i > 0 && !strCol[i].equals(strCol[i-1])) return false;
		}
		return true;
	}

	String getStringOrd(int[][] matrix, int c) {
		boolean[] visited = new boolean[matrix.length];
		String s = "";
		for(int i = 0; i < matrix.length; i++){
			int min = Integer.MAX_VALUE, minIdx = 0;
			for(int j = 0; j < matrix.length; j++){
				if(visited[j]) continue;
				if(matrix[j][c] < min){
					min = matrix[j][c];
					minIdx = j;
				} else if (matrix[j][c] == min) {
					return " ";
				}
			}
			s += minIdx;
			visited[minIdx] = true;
		}
		return s;
	}
	
	//////////////////////////////////////////////////
	int[] digitDifferenceSort(int[] a) {
		int[] diff = new int[a.length], result = new int[a.length];
		for(int i = 0; i < a.length; i++){
			diff[i] = getDiff(a[i]);
		}
		int count = 0;
		boolean[] visited = new boolean[a.length];
		for(int i = 0; i < a.length; i++){
			int min = Integer.MAX_VALUE, minIdx = 0;
			for(int j =0; j< a.length; j++){
				if(visited[j]) continue;
				if(diff[j] <= min){
					min = diff[j];
					minIdx = j;
				}
			}
			result[count++] = a[minIdx];
			visited[minIdx] = true;
		}
		return result;
	}


	int getDiff(int n) {
		if(n < 10) return 0;
		int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
		while (n > 0) {
			int mod = n%10;
			if(mod > max) max = mod;
			if(mod < min) min = mod;
			n = n/10;
		}
		return max-min;
	}
	
	/////////////////////////////////////
	int uniqueDigitProducts(int[] a) {
		Set<Integer> setProducts = new HashSet<>();
		for(int x : a){
			setProducts.add(product(x));
		}
		return setProducts.size();
	}

	Integer product(int x) {
		int multi = 1;
		while(x > 1){
			multi *= (x%10);
			x/=10;
		}
		return multi;
	}

	public static void main(String[] args) {
		ShortOutpost test = new ShortOutpost();
		int[] x =  {13098, 1308, 12398, 52433, 213, 424, 213, 243, 12213, 54234, 99487, 81892, 11111, 97897}; 
		System.out.println(test.digitDifferenceSort(x));
	}
}
