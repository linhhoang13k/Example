package tiendm.codefight.tournament.sep;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Tour1909 {
	boolean findPath(int[][] matrix) {

		int positionX = -1, positionY = -1;

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == 1) {
					positionX = i;
					positionY = j;
				}
			}
		}
		for (int i = 1; i < matrix.length * matrix[0].length; i++) {
			boolean found = false;
			int nextX = -1;
			int nextY = -1;
			for (int dx = -1; dx <= 1; dx++) {
				for (int dy = -1; dy <= 1; dy++) {
					if (dx * dy == 0) {
						if (positionX + dx >= 0 && positionX + dx < matrix.length && positionY + dy >= 0
								&& positionY + dy < matrix[0].length) {
							if (matrix[positionX + dx][positionY + dy] == i + 1) {
								found = true;
								nextX = positionX + dx;
								nextY = positionY + dy;
							}
						}
					}
				}
			}
			if (found) {
				positionX = nextX;
				positionY = nextY;
			} else {
				return false;
			}
		}
		return true;
	}
	
	int sumBelowBound(int bound) {
	    int i = 1, s = 0;
	    for(i = 1; ; i++){
	        s += i;
	        if(s > bound) return i-1;
	    }
	}
	
	public static void main(String[] args) {
		Tour1909 t = new Tour1909();
		int[] fromV = { 2, 1, 3, 4, 4, 4, 1 };
		int[] toV = { 3, 2, 1, 3, 2, 1, 4 };
		System.out.println(t);
	}
}
