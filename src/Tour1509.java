package tiendm.codefight.tournament.sep;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Tour1509 {
	int zigzag(int[] a) {
		int best = 1;
		int left = 0;
		while (left < a.length) {
			int right = left + 1;
			while (right < a.length) {
				if (right == left + 1) {
					if (a[left] == a[right]) {
						break;
					}
				} else {
					if ((a[right - 1] - a[right - 2]) * (a[right - 1] - a[right]) <= 0) {
						break;
					}
				}
				right++;
			}
			best = Math.max(best, right - left);
			left = right;
			if (left < a.length && a[left - 1] != a[left]) {
				left--;
			}
		}
		return best;
	}
	int lastDigit(int a, int b) {
	    int last = a, i = 1;
	    while( i < b){
	        a = (a% 10) * (a % 10);
	        i++;
	    }
	    return a % 10;
	}

	int dfsComponentSize(boolean[][] matrix, int vertex) {
	    Set<Integer> set= new HashSet<>();
	    set.add(vertex);
	    Queue<Integer> q = new LinkedList<>();
	    q.add(vertex);
	    while(!q.isEmpty()){
	        int cur = q.poll();
	        for(int i = 0; i < matrix[cur].length; i++){
	        	if(i != cur && matrix[cur][i] && !set.contains(i)){
	        		set.add(i);
	        		q.add(i);
	        	}
	        }
	    }
	    return set.size();
	}

	public static void main(String[] args) {
		Tour1509 t = new Tour1509();
		int[] fromV = { 2, 1, 3, 4, 4, 4, 1 };
		int[] toV = { 3, 2, 1, 3, 2, 1, 4 };
		System.out.println(t.lastDigit(2, 5));
	}
}
