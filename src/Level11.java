package tiendm.codefight.introduction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Level11 {
	
	boolean isDigit(char symbol) {
		return (symbol >= '0' && symbol <= '9');
	}
	
	String lineEncoding(String s) {
		StringBuilder builder = new StringBuilder();
		int count = 1;
		s = s + "_";
		for(int i=0; i < s.length() - 1; i++){
			if(s.charAt(i) == s.charAt(i+1)) count++;
			else{
				builder.append(count+""+s.charAt(i));
				count = 1;
			}
		}
		return builder.toString().replaceAll("1", "");
	}
	
	ArrayList<Double> liquidMixing(List<Integer> densities) {
		  ArrayList<Double> result = new ArrayList<>();
		  for (int i = 0; i < densities.size(); i++) {
			  int sum = 0;
		      for(int j = 0; j < i+1; j++){
		    	  sum += densities.get(j);
		      }
		      result.add((double) (sum / (i+1)));
		  }
		  return result;
	}

	
	int chessKnight(String cell) {
		int [][] chess = new int[8][8];
		int x = cell.charAt(0) - 'a';
		int y = cell.charAt(1) - '1';
		int count = 0, valid = 0;
		try {valid = chess[x+1][y+2];count++;} catch (Exception e) {}
		try {valid = chess[x+1][y-2];count++;} catch (Exception e) {}
		try {valid = chess[x-1][y+2];count++;} catch (Exception e) {}
		try {valid = chess[x-1][y-2];count++;} catch (Exception e) {}
		try {valid = chess[x+2][y+1];count++;} catch (Exception e) {}
		try {valid = chess[x+2][y-1];count++;} catch (Exception e) {}
		try {valid = chess[x-2][y+1];count++;} catch (Exception e) {}
		try {valid = chess[x-2][y-1];count++;} catch (Exception e) {}
		return count;
	}
	
	int deleteDigit(int n) {
		String s = n+"";
		int mark = 0;
		for(int i=0 ; i < s.length() - 1; i++){
			if(s.charAt(i) < s.charAt(i+1)) {
				mark = i;
				break;
			} else {
				mark++;
			}
		}
		return Integer.parseInt(s.substring(0,mark)+ (mark+1 < s.length() ? s.substring(mark+1,s.length()) : ""));
	}
	
//	int deleteDigit(int n) {
//		int log = (int) Math.log10(n) ;
//		int mark = 0;
//		for(int i = log; i > 0; i--){
//			if((int)(n % Math.pow(10, i+1) / Math.pow(10, i)) < (int)(n % Math.pow(10, i) / Math.pow(10, i-1))){
//				mark = log - i;
//				break;
//			}else {
//				mark++;
//			}
//		}
//		if(mark == log) return (int) n / 10;  
//		return (int) (((int)(n / Math.pow(10, log)) * Math.pow(10, log-1)) + 
//				((int)((n % Math.pow(10, mark)) / Math.pow(10, log-mark)) * Math.pow(10, log-mark))+ n%10);
//	}
	
	public static void main(String[] args) {
		Level11 test = new Level11();
		System.out.println(test.deleteDigit(5236));
//		System.out.println(test.lineEncoding("abbcabb"));
	}
}
