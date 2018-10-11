package tiendm.codefight.challenge.may;

import java.util.ArrayList;
import java.util.List;

public class SwitchingTumblers {
	boolean switchingTumblers(String[] tumblers, String[] pattern) {
		boolean[][] p = new boolean[pattern.length][pattern[0].length()];
		long start = System.currentTimeMillis();
		for(int i = 0; i < pattern.length; i++){
			for(int j = 0; j < pattern[0].length(); j++){
				p[i][j] = (pattern[i].charAt(j) == '0');
			}
		}
		
		List<ArrayList<Integer>> lsTumblers = new ArrayList<>();
		for(String t : tumblers){
			String[] arr = t.split(",");
			ArrayList<Integer> ls = new ArrayList<>();
			for(String s : arr){
				s = s.trim();
				ls.add(pattern.length - (Integer.parseInt(s.substring(1))));
				ls.add(s.charAt(0)-'a');
			}
			lsTumblers.add(ls);
		}
		
		System.out.println("time prepareData = " + ((System.currentTimeMillis()-start)/1000));
		start = System.currentTimeMillis();
		
		boolean[][] x = new boolean[p.length][p[0].length];
		for(int i = 0; i < lsTumblers.size(); i++){
			boolean[] visited = new boolean[lsTumblers.size()];
			if(solve(i, lsTumblers, x, p, visited)){
				return true;
			}
		}
		System.out.println("time solve = " + ((System.currentTimeMillis()-start)/1000));
		
		return false;
	}
	
	boolean solve(int i, List<ArrayList<Integer>> lsTumblers, boolean[][] x, boolean[][] p , boolean[] visited) {
		visited[i] = true;
		ArrayList<Integer> tumbler = lsTumblers.get(i);
		boolean[][] x2 = cloneX(x);
		for(int j = 0; j <tumbler.size()-1; j+=2){
			x2[tumbler.get(j)][tumbler.get(j+1)] = !x2[tumbler.get(j)][tumbler.get(j+1)];
		}
		if(check(x2, p)) {
			return true;
		}
		else {
			for(int j = i+1; j < lsTumblers.size(); j++){ 
				if(visited[j]) continue;
//				System.out.println("i= " + i + ", j= "+j);
				print(visited);
				if(solve(j, lsTumblers, x2, p, visited)){
					System.out.print("result= "); print(visited);
					return true;
				}else {
					visited[j] = false;
				}
			}
		}
		return false;
	}


	boolean check(boolean[][] x, boolean[][] p){
		for(int i = 0; i < x.length; i++){
			for(int j = 0; j < x[0].length; j++){
				if(x[i][j] != p[i][j]) return false;
			}
		}
		return true;
	}
	
	boolean[][] cloneX(boolean[][] x) {
		boolean[][] x2 = new boolean[x.length][x[0].length];
		for(int i = 0; i < x.length; i++){
			for(int j = 0; j < x[0].length; j++){
				x2[i][j] = x[i][j];
			}
		}
		return x2;
	}
	
	void print(boolean[] x){
		System.out.print("[");
		for(int i = 0; i < x.length; i++){
			if(i == x.length-1) System.out.print(x[i]);
			else System.out.print(x[i] + ", ");
		}
		System.out.println("]");
	}
	public static void main(String[] args) {
		SwitchingTumblers test = new SwitchingTumblers();
		String[] tumblers = {"a7, d5, e1, f7, g1", 
				 "c3, d9, f8, g9, i8", 
				 "a1, a3, a6, a7, a8, b10, b6, c1, c10, c3, c5, c9, d2, d3, d6, d7, e7, e8, f2, f3, f5, f7, f8, g1, g3, g7, g8, g9, h3, h7, i4, j3, j4, j9", 
				 "c8, d3, f6, g8, i3, j10, j5", 
				 "a1, a4, a6, b9, c6, c7, c9, d2, d6, d7, e8, f1, f10, f2, f3, f5, f7, g1, g7, g9, h3, h4, h7, h9, j10, j3, j4, j8", 
				 "a7, a8, b5, c1, c10, c7, c9, d1, d2, d3, e10, e8, f1, f6, f9, g1, g8, h10, h2, h3, h5, i3, i4, j3, j9", 
				 "b9, c3, c5, c7, c9, d2, e10, g7, i2, j9", 
				 "a4, b5, b9, c5, c6, c7, c8, c9, d10, d2, d3, d7, d9, e10, f10, f3, f7, f8, f9, g7, g8, g9, h10, h3, h5, i4, i8, j1, j5, j8", 
				 "a1, a3, a6, a7, a8, b10, c1, c10, c3, c5, c7, c9, d2, d3, d7, e8, f2, f3, f5, f7, f8, g1, g3, g4, g8, g9, h3, h7, i4, j3, j4, j9", 
				 "b6, c7, d6, e7, g4, g7", 
				 "d5, e8, f3, h2, h4, j3", 
				 "a1, a4, a6, a8, b6, b9, c10, c6, c7, d3, d5, d7, e7, f1, f10, f5, f6, f7, f9, g1, g7, g8, h10, h2, h3, h4, h5, h7, i2, j10, j4, j9", 
				 "a4, a7, b5, b6, b9, c3, c6, c9, d1, d2, d6, d9, e10, e7, f1, f10, f6, f8, g9, h3, i8, j10, j8", 
				 "a7, e1, f1, f3, f7, g7, i3, i4", 
				 "a3, a7, a8, b10, b9, c10, c8, d1, d10, d5, d6, d7, e1, e10, f1, f2, f3, f8, g1, g3, g9, h4, j1, j10, j5, j8", 
				 "e10, f2, f6, g9, h9", 
				 "a3, a4, a7, b10, b5, b6, c6, c7, d1, e1, e7, e8, f1, f10, f3, f6, f7, f8, f9, g1, g3, h10, h2, h3, h4, h5, h9, i2, i4, j10, j3, j8, j9", 
				 "a3, a7, a8, b10, b5, b6, c1, c10, c3, c5, c8, c9, d10, d2, d7, e10, e7, e8, f3, f7, f8, g1, g3, g7, h2, h3, h9, i3, i4, j1, j10, j3, j5, j9", 
				 "a8, b9, c10, d3, g4, g7, g8, h4, j8", 
				 "a1, a3, a4, a6, a8, b10, b5, c1, c10, c5, c6, c7, c9, d1, d2, d3, d7, d9, e10, e8, f1, f10, f3, f5, f7, f9, g1, g3, g7, g8, g9, h10, h5, h7, h9, i2, i4, i8, j10, j3, j4, j8", 
				 "a1, a4, a6, a7, b6, c3, c6, c7, c8, d1, d10, d3, d9, e7, f1, f10, f5, f8, f9, g8, g9, h10, h2, h3, h5, h7, i2, i3, i8, j1, j4, j5, j8, j9", 
				 "a3, a4, a7, b10, b6, b9, c1, c6, c8, c9, d2, d3, d5, e7, f10, f2, f3, f8, g1, g3, g4, g7, g8, g9, i2, j5", 
				 "a3, a7, b10, d6, f8, g3, h9, i4", 
				 "a1, a6, b5, d10, d6, f5, h2, h7, j1, j4", 
				 "c3, c5, f9, g7, h10, h5", 
				 "a1, a3, a4, a6, a7, b10, c5, c6, c8, d3, d7, d9, f10, f3, f5, f7, g3, g7, g8, g9, h2, h3, h7, h9, i2, i8, j4, j5, j8, j9", 
				 "d1, d10, d7, e1, g4, j1", 
				 "a7, b5, c1, d1, f6, g4, h3, i2, j8", 
				 "a4, c1, c3, c5, c6, f1, f10, j10, j9", 
				 "a3, a4, a7, a8, b10, b6, c1, c10, c6, c8, c9, d2, d5, e7, f10, f2, f3, f8, g1, g3, g9, h4, i2, j5, j8"};
		String[] pattern =  {".0...0.0..", 
				 ".......0..", 
				 "......0.0.", 
				 "..0...0.0.", 
				 "....0000..", 
				 "....00.0.0", 
				 "..0..0....", 
				 "..00......", 
				 ".00..0...0", 
				 ".........."};
		System.out.println(test.switchingTumblers(tumblers, pattern));
	}
}
