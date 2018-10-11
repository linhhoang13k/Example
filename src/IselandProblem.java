package com.iub.coding.practice.CodeName47;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class IselandProblem {

	public static void main(String[] args) {

		int mayMap[][] = { { 1, 0, 1, 1, 0 }, { 0, 1, 0, 0, 1 }, { 1, 0, 1, 1, 0 }, { 1, 0, 1, 1, 0 },
				{ 0, 1, 0, 0, 1 } };
		int landCount = 0, temp = 0;
		int[] t = { 1, 2, 3, 4, 5 };

		HashMap<Integer, Integer> grp = new HashMap<Integer, Integer>();
		for (int i = 0; i < t.length; i++) {

			grp.put(t[i], 0);
		}

		for (int i = 0; i < mayMap.length; i++) {
			for (int j = 0; j < mayMap[i].length; j++) {

				//System.out.print(mayMap[i][j] + " ");
				if (mayMap[i][j] != 0) {

					temp = getWholeLandBfs(mayMap, i, j);
					System.out.println(temp);

					if (grp.containsKey(temp))
						grp.put(temp, (Integer) (grp.get(temp)) + 1);
				}
			}

			System.out.println();
		}

		System.out.println("Total number of lands : " + grp);
	}

	public static int getWholeLand(int map[][], int i, int j, int count) {

		if (i < 0 || i >= map.length || j < 0 || j >= map[i].length)
			return count;

		if (map[i][j] == 0)
			return count;

		count++;
		map[i][j] = 0;

		count = getWholeLand(map, i, j - 1, count);
		count = getWholeLand(map, i, j + 1, count);
		count = getWholeLand(map, i + 1, j, count);
		count = getWholeLand(map, i - 1, j, count);

		return count;
	}

	public static int getWholeLandBfs(int map[][], int i, int j) {

		Queue<Integer> q = new LinkedList<Integer>();
		int row = 0, col = 0, count = 0;

		q.add(i);
		q.add(j);

		while (!q.isEmpty()) {

			row = q.poll();
			col = q.poll();

			if (map[row][col] != 0) {
				count++;
				map[row][col] = 0;

				if (col > 0) {

					q.add(row);
					q.add(col - 1);
				}
				if (col < map[row].length - 1) {

					q.add(row);
					q.add(col + 1);
				}
				if (row > 0) {

					q.add(row - 1);
					q.add(col);
				}
				if (row < map.length - 1) {

					q.add(row + 1);
					q.add(col);
				}
			}

		}
		return count;
	}
}
