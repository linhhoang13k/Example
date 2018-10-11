package tiendm.codefight.tournament.oct;

import java.util.LinkedList;
import java.util.Queue;

public class Tour1004 {
	int[] nextSecond(int[] currentTime) {

		if (currentTime[2] == 59) {
			currentTime[2] = 0;
			if (currentTime[1] == 59) {
				currentTime[1] = 0;
				currentTime[0] = (currentTime[0] + 1) % 24;
			} else {
				currentTime[1]++;
			}
		} else {
			currentTime[2]++;
		}

		return currentTime;
	}

	int bfsComponentSize(boolean[][] matrix) {
		Queue<Integer> q = new LinkedList<>();
		q.add(1);
		boolean[] visited = new boolean[matrix.length];
		int s = 0;
		while (!q.isEmpty()) {
			int cur = q.poll();
			visited[cur] = true;
			s++;
			for (int i = 0; i < matrix.length; i++) {
				if (i == cur || visited[i])
					continue;
				if (matrix[cur][i]) {
					q.add(i);
				}
			}
		}
		return s;
	}

	public static void main(String[] args) {
		Tour1004 t = new Tour1004();
		int[] fromV = { 2, 1, 3, 4, 4, 4, 1 };
		int[] toV = { 3, 2, 1, 3, 2, 1, 4 };
		System.out.println(t);
	}
}
