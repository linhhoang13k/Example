package codefights.edgeofocean;
//Given a sequence of integers as an array, determine whether it is possible to obtain a strictly increasing sequence by

import java.util.ArrayList;
import java.util.List;

//removing no more than one element from the array.

public class AlmostIncreaasingSequence {
	class Pair {
		public int x;
		public int y;
	}
	
	public static void main(String[] args) {

		int[] sequence = { 1, 3, 2, 1};
		AlmostIncreaasingSequence s = new AlmostIncreaasingSequence();
		System.out.println(s.almostIncreasingSequence(sequence));

	}

	boolean almostIncreasingSequence(int[] sequence) {		
		
		boolean isSequence = true;
		List<Integer> list = new ArrayList<Integer>();
		for (int i : sequence) {
			list.add(i);
		}
		
		int numLoops = sequence.length + 1;
		System.out.println(numLoops);
		List<Integer> list2 = new ArrayList<Integer>(list);
		for (int i=0;i<numLoops;i++) {
			System.out.println("Loop " + (i));
			//loop around the list
			for (int j=0;j<list2.size()-1;j++) {
				System.out.print(list2.get(j) + ", ");
				System.out.println(list2.get(j) + " vs " + list2.get(j+1));
				isSequence = true;
				if (list2.get(j) >= list2.get(j+1)) {
					isSequence = false;
					list2 = new ArrayList<Integer>(list);
					System.out.println("removing " + i);  
					if (i != numLoops -1) {
						list2.remove(i);
					}
					break;
				}
			}
			if (isSequence) {
				break;
			}
			System.out.println(" ");
		}
		return isSequence;
	}
}
