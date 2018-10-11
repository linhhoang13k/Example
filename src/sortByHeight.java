package codefights;

import java.util.Arrays;

public class SortByHeight {

	int[] sortByHeight(int[] a) {
	
		int[] htSrt = new int[a.length];
		int index = 0;
		
		for (int n : a) {
			if (n!= -1) {
				htSrt[index] = n;
				index++;
			}
		}
		
		index = a.length - index; // provides value for lowest non-zero index in the sorted array
		Arrays.sort(htSrt);
		
		for (int j = 0; j < a.length; j++) {
			if (a[j] != -1) {
				a[j] = htSrt[index];
				index++;
			}
		}
		
		return a;
	}
}