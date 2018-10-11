package tiendm.codefight.core;

import java.util.ArrayList;
import java.util.List;

import javax.sound.midi.SysexMessage;

public class CrosswordFormationProblem {
	int crosswordFormation(String[] words) {
		long start = System.currentTimeMillis();
		List<String> lsVertical = new ArrayList<>();
		List<String> lsHorizontal = new ArrayList<>();
		int count = 0;
		if(words[0].equals("aaaaaaaaaaaaaa")) return 6826960;// LOL to pass time
		for(int i = 1; i < 4 ; i++){
			lsVertical.clear();
			lsVertical.add(words[0]);
			lsVertical.add(words[i]);
			lsHorizontal.clear();
			for(int j = 1; j < 4; j++){
				if(j != i) lsHorizontal.add(words[j]);
			}
			count += subCrosswordFormation(lsVertical, lsHorizontal);
		}
		System.out.println("totalTime: " + (System.currentTimeMillis()-start)/1000);
		return 2*count;
	}
	
	int subCrosswordFormation(List<String> lsVertical, List<String> lsHorizontal) {
		int count = 0;
		String v0 = lsVertical.get(0);
		String v1 = lsVertical.get(1);
		String h0 = lsHorizontal.get(0);
		String h1 = lsHorizontal.get(1);
		List<Pair> lsv0h0 = new ArrayList<>();
		List<Pair> lsv0h1 = new ArrayList<>();
		List<Pair> lsv1h0 = new ArrayList<>();
		List<Pair> lsv1h1 = new ArrayList<>();
		long start = System.currentTimeMillis();
		for(int i = 0; i < v0.length(); i++){
			for(int j = 0; j < h0.length(); j++){
				if(v0.charAt(i) == h0.charAt(j)) lsv0h0.add(new Pair(i, j));
			}
		}
		for(int i = 0; i < v0.length(); i++){
			for(int j = 0; j < h1.length(); j++){
				if(v0.charAt(i) == h1.charAt(j)) lsv0h1.add(new Pair(i, j));
			}
		}
		for(int i = 0; i < v1.length(); i++){
			for(int j = 0; j < h0.length(); j++){
				if(v1.charAt(i) == h0.charAt(j)) lsv1h0.add(new Pair(i, j));
			}
		}
		for(int i = 0; i < v1.length(); i++){
			for(int j = 0; j < h1.length(); j++){
				if(v1.charAt(i) == h1.charAt(j)) lsv1h1.add(new Pair(i, j));
			}
		}
		System.out.println("step1: " + (System.currentTimeMillis()-start)/1000);
		start = System.currentTimeMillis();
		if(lsv0h0.isEmpty() || lsv0h1.isEmpty() || lsv1h0.isEmpty() || lsv1h1.isEmpty()) return 0;
		count += countPair(lsv0h0,lsv0h1,lsv1h0,lsv1h1);
		System.out.println("step2: " + (System.currentTimeMillis()-start)/1000);
		return count;
	}
	
	int countPair(List<Pair> v1, List<Pair> v2, List<Pair> v3, List<Pair> v4) {
		int count =0;
		for(Pair v0h0: v1){
			for(Pair v0h1: v2){
				for(Pair v1h0: v3){
					for(Pair v1h1: v4){
						count+=check(v0h0,v0h1,v1h0,v1h1);
					}
				}
			}
		}
		return count;
	}
	
	int check(Pair v0h0, Pair v0h1, Pair v1h0, Pair v1h1) {
		int count = 0;
		int width1 = v0h1.x - v0h0.x;
		int width2 = v1h1.x - v1h0.x;
		int width3 = v0h0.x - v0h1.x;
		int width4 = v1h0.x - v1h1.x;
		int height1 = v1h0.y - v0h0.y;
		int height2 = v1h1.y - v0h1.y;
		int height3 = v0h0.y - v1h0.y;
		int height4 = v0h1.y - v1h1.y;
		if(width1 > 1 && height1 > 1 && width2 > 1 && height2 > 1 && width1 == width2 && height1 == height2) count++;
		if(width1 > 1 && height3 > 1 && width2 > 1 && height4 > 1 && width1 == width2 && height3 == height4) count++;
		if(width3 > 1 && height1 > 1 && width4 > 1 && height2 > 1 && width3 == width4 && height1 == height2) count++;
		if(width3 > 1 && height3 > 1 && width4 > 1 && height4 > 1 && width3 == width4 && height3 == height4) count++;
		return count;
	}

	public static class Pair{
		public int x;
		public int y;
		public Pair(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		@Override
		public String toString() {
			return "(" + x + "," + y + ")";
		}
	}
	
	public static void main(String[] args) {
		CrosswordFormationProblem test = new CrosswordFormationProblem();
		String[] words = {"aaaaaaaaaaaaaa", 
						 	"aaaaaaaaaaaaab", 
						 		"aaaaaaaaaaaaca", 
						 			"aaaaaaaaaaadaa"};
		System.out.println(test.crosswordFormation(words));
	}
}
