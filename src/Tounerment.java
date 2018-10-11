package tiendm.codefight.tournament;

import java.util.ArrayList;
import java.util.List;

public class Tounerment {
//	int closestSequence(int[] a, int[] b) {
//		int bestDiff = 0;
//		boolean[] mask = new boolean[b.length];
//		for (int i = 0; i < a.length; i++) {
//			int min = Integer.MAX_VALUE, minIndex = 0;
//			for (int j = 0; j < b.length; j++) {
//				if (mask[j])
//					continue;
//				if (Math.abs(a[i] - b[j]) < min) {
//					min = Math.abs(a[i] - b[j]);
//					minIndex = j;
//				}
//			}
//			bestDiff += min;
//			mask[minIndex] = true;
//		}
//
//		return bestDiff;
//	}
	
	int closestSequence(int[] a, int[] b) {
	  int bestDiff = Integer.MAX_VALUE;
	  int nbRemove = b.length - a.length;
	  	List<Integer> listMin = new ArrayList<>(); 
	    for (int i = 0; i < b.length -1; i++) {
	    	for(int j = i+1; j < b.length; j++){
	    		listMin.add(check(a,b,i,j));
	    	}
	    }
	    for(int i : listMin){
	    	if(i < bestDiff) bestDiff = i;
	    }
	    return bestDiff;
	  }
	  

	int check(int[] a, int[] b, int i, int j) {
		int sum = 0;
		int countA = 0;
		for(int count = 0; count < b.length; count++){
			if(count == i || count == j) continue;
			sum += Math.abs(b[count] - a[countA]);
			countA++;
		}
		return sum;
	}
	
	int sumOfMultiples(int n, int k) {
		int count = 0,mul = k,sum = 0;
		
		while(count < n/k){
			count++;
			mul = k * count;
			sum+=mul;
		}
		return sum;
	}


	public static void main(String[] args) {
		Tounerment t = new Tounerment();
		int[] a = { 1, 2, 6 };
		int[] b = { 0, 1, 3, 4, 5 };
		System.out.println(t.sumOfMultiples(7, 2));
	}
}
