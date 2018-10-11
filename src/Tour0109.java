package tiendm.codefight.tournament.sep;

import java.util.HashSet;
import java.util.Set;

public class Tour0109 {
	int dfsComponentSize(boolean[][] matrix, int vertex) {
		boolean[] visited = new boolean[matrix.length];
		int[] root = new int[matrix.length];
		return dfs(matrix, vertex, vertex, visited, root);

	}

	int dfs(boolean[][] matrix, int vertex, int parent, boolean[] visited, int[] root) {
		visited[vertex] = true;
		if (parent == vertex) {
			root[vertex] = parent;
		} else {
			root[vertex] = root[parent];
		}
		for (int i = 0; i < matrix.length; i++) {
			if (matrix[vertex][i] && !visited[i]) {
				dfs(matrix, i, vertex, visited, root);
			}
		}
		for (int i = 0; i < visited.length; i++) {
			if (!visited[i]) {
				dfs(matrix, i, i, visited, root);
			}
		}
		Set<Integer> components = new HashSet<>();
		for (int i : root) {
			components.add(i);
		}
		return components.size();
	}

	boolean isSum(int value) {
		int s = 0, i = 0;
	    while(s + i <= value){
	    	i++;
	        s+=i;
	        if(s == value) return true;
	        if(s > value) return false;
	    }
	    return false;
	}


	int gcd(int a, int b) {
		while (a % b != 0) {
			int tmp = b;
			b = a % b;
			a = tmp;
		}
		return b;
	}

	double[] quadraticEquation(int a, int b, int c) {
		double delta = b * b - 4 * a * c;
		if (delta < 0)
			return new double[] {};
		if (delta == 0) {
			return new double[] { -b / (2 * a) };
		}
		double dSquare = Math.sqrt(delta);
		return new double[] { (-b - dSquare) / (2 * a), (-b + dSquare) / (2 * a) };
	}

	public static void main(String[] args) {
		Tour0109 t = new Tour0109();
		int[][] x = { { 0, 1, 2, 3 }, { 1, 2, 3, 0 }, { 1, 1, 1 } };
		int[] p = { 7, 5, 4, 4, 8 };
		System.out.println(t.isSum(10));
	}
}
