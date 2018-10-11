package com.danielsolawa.codefights.challenges.solutions;

import java.util.LinkedList;
import java.util.Queue;

public class MoveZeros {

		int[] moveZeros(int[] arr) {
				
				Queue<Integer> qu = new LinkedList<>();
				
				for(int i = arr.length -1; i >= 0; i--) {
					if(arr[i] == 0) {
						if(qu.size() > 0) {
							int pos = qu.poll();
							int temp = arr[pos];
							arr[pos] = arr[i];
							arr[i] = temp;
							qu.add(i);
						}
					}else
						qu.add(i);

				}
				
					
				return arr;
		}
	
	
}
