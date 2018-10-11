package com.codefight.challanges;

import java.util.ArrayList;
import java.util.List;

public class Thumbtack {

	public static void main(String[] args) {
		int[][] ratings = {{3,4}, 
		                   {3,3,3,4}, 
		                   {4}};
		int r[] = ratingThreshold(3.5, ratings);
		for(int m : r){
			System.out.println(m);
		}
	}

	static int[] ratingThreshold(double threshold, int[][] ratings) {
		List<Integer> result = new ArrayList<Integer>();
		
		for(int i=0; i < ratings.length; i++){
			int[] a = ratings[i];
			double sum = 0;
			for(int k: a){
				sum +=(double)k;
			}
			double avg = sum/a.length;
			
			if(avg < threshold){
				result.add(i);
			}
		}
		
		return result.stream().mapToInt(i -> i).toArray();
	}

}
