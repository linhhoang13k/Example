package com.codefight.challanges;

import java.util.ArrayList;
import java.util.List;

public class GcdSubset {

	public static void main(String[] args) {
		System.out.println(subsetGcd(37, 6));
	}

	static int subsetGcd(int n, int g) {
		int k = 1;
		int m = 1;
		List<Integer> numList = new ArrayList<>();
		List<List<Integer>> comboList = new ArrayList<>();
		while(true){
			if(k+g > n) break;
			k = g * m;
			numList.add(k);
			++m;
		}
		List<Integer> a1 = new ArrayList();
		a1.add(numList.get(0));
		comboList.add(a1);
		
		for(int i=0; i < numList.size()-1;i++){
		}
		
		System.out.println(numList.size());

		return 0;
	}
}
