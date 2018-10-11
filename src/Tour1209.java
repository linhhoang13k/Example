package tiendm.codefight.tournament.sep;

import java.util.HashSet;
import java.util.Set;

public class Tour1209 {
	String caesarBoxCipherEncoding(String inputString) {
		int len = inputString.length();
		int x = (int) Math.sqrt(len);
		String s = "";
		for (int i = 0; i < x; i++) {
			for (int j = i; j < len; j += x) {
				s += inputString.charAt(j) + "";
			}
		}
		return s;
	}

	String reflectString(String inputString) {
		String s = "";
		for (int i = 0; i < inputString.length(); i++) {
			s += (char) ('z' - (inputString.charAt(i) - 'a')) + "";
		}
		return s;
	}
	
	boolean isTournament(int n, int[] fromV, int[] toV) {
		int[][] graph = new int[n][n];
		for(int i = 0; i < fromV.length; i++){
			graph[fromV[i]-1][toV[i]-1] = 1; 
		}
	    
	    for(int i = 0; i < n; i++){
	    	if(dfs(graph,i)) return true;
	    }
	    return false;
	}
	
	private boolean dfs(int[][] graph, int i) {
		boolean[] visited = new boolean[graph.length];
		int cur = i;
		Set<Integer> set = new HashSet<>();
		while (true) {
			set.add(cur);
			visited[cur] = true;
			if(set.size() == graph.length){
				return true;
			}
			int j = 0;
			for(; j < graph.length; j++){
				if(!visited[j] && graph[cur][j] == 1){
					cur = j;
					break;
				}
			}
			if(j == graph.length) return false;
		}
	}

	public static void main(String[] args) {
		Tour1209 t = new Tour1209();
		int[] fromV = { 2, 1, 3, 4, 4, 4, 1};
		int[] toV =   { 3, 2, 1, 3, 2, 1, 4};
		System.out.println(t.isTournament(4, fromV, toV));
	}
}
