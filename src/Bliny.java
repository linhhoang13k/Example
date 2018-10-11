package solutions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Bliny {

	public static void main(String[] args) {

		System.out.println(new Bliny().bliny(new int[] { 1, 3, 2, 5, 6, 8, 7, 10, 9, 11, 13, 12, 4 }));
	}

	boolean bliny(int[] order) {

		// stack representing the blinys available to grab
		ArrayList<Integer> stack = new ArrayList<Integer>();
		
		// set representing the blinys that were already cooked
		Set<Integer> cooked = new HashSet<Integer>();

		for (int i = 0; i < order.length; i++) {

			int blinyId = order[i];
			cooked.add(blinyId);

			// if the bliny grabbed is valid, then it should be the first in the stack (if any)
			// or a bliny that will be cooked later
			
			// not valid
			if (!stack.isEmpty() && blinyId < stack.get(stack.size() - 1)) {
				return false;
			}
			// taking a bliny from the stack
			else if (!stack.isEmpty() && blinyId == stack.get(stack.size() - 1)) {
				stack.remove(stack.size()-1);
			}

			//calculate the blinys that were cooked before I could take a bliny
			for (int j = 1; j < blinyId; j++) {
				if (!cooked.contains(j)) {
					cooked.add(j);
					stack.add(j);
				}
			}

		}
		return true;
	}

}
