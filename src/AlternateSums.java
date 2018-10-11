package com.danielsolawa.codefights.intro.solutions;

public class AlternateSums {

	int[] alternatingSums(int[] a) {
		int[] totalWeights = new int[2];
		
		for(int i = 0; i < a.length; i++) {
			int currentIndex = i+1;
			if(currentIndex % 2 == 0) {
				totalWeights[1] += a[i];
			}else {
				totalWeights[0] += a[i];
			}
		}
		
		
		return totalWeights;
	}

}
