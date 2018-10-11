package tiendm.codefight.introduction;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Level12 {
	
	String longestWord(String text) {
		StringBuilder builder = new StringBuilder();
		int maxLength = 0;
		int count = 0;
		String max = "";
		for(int i = 0; i < text.length(); i++){
			char c = text.charAt(i);
			if(isLetter(c)){
				count++;
				builder.append(c);
			} else {
				if(count > maxLength) {
					maxLength = count;
					max = builder.toString();
				}
				builder = new StringBuilder();
				count = 0;
			}
		}
		return max.equals("") ? builder.toString() : max;
	}
	int length(String letter) {
		int count = 0;
		for(int i = 0; i < letter.length(); i++){
			char c = letter.charAt(i);
			if((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) count++;
		}
		return count;
	}
	
	boolean isLetter(char c) {
		if((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) return true;
		return false;
	}
	
	boolean isDigit(char c){
		return c >= '0' && c <= '9';
	}
	
	boolean validTime(String time) {
		String[] arrtime = time.split(":");
		if(arrtime.length != 2) return false;
		try {
			int h = Integer.parseInt(arrtime[0]);
			int m = Integer.parseInt(arrtime[1]);
			return (h>=0 && h < 24 && m >= 0 && m < 60);
		} catch (Exception e) {
			return false;
		}
	}
	
	int sumUpNumbers(String inputString) {
		int sum = 0;
		String num = "";
		inputString += "x";
		for(int i = 0; i < inputString.length(); i++){
			char c = inputString.charAt(i);
			if(isDigit(c)) {
				num += c;
			}else {
				sum += Integer.parseInt(num);
				num = "0";
			}
		}
		return sum;
	}
	
	int differentSquares(int[][] matrix) {
		if(matrix.length < 2 || matrix[0].length < 2) return 0; 
		int row = matrix.length;
		int col = matrix[0].length;
		Set<String> lsSubSquare = new HashSet();
		for(int i = 0; i < row-1; i++){
			for(int j = 0; j < col-1; j++) {
				lsSubSquare.add(matrix[i][j] + "" + matrix[i][j+1] 
										+ "" + matrix[i+1][j] + "" + matrix[i+1][j+1]);
			}
		}
		return lsSubSquare.size();
	}
	
	int digitsProduct(int product){
		if(product == 0) return 10;
		if(product < 10) return product;
		List<Integer> track = new ArrayList<>() ;
		int count = 9;
		while (product > 1) {
			if(count == 1) return -1;
			for(count = 9; count >= 2; count--){
				if(product % count == 0) {
					track.add(count);
					product = product / count;
					count = 9;
					break;
				} 
			}
		}
		int sum = 0;
		Collections.sort(track);
		for(int i = 0; i < track.size(); i++ ) {
			sum += track.get(i) * Math.pow(10, track.size()-1-i);
		}
		return sum;
	}
	
	String[] fileNaming(String[] names) {
		List<Integer> listIndex = new ArrayList<>();
		for(int i = 0; i < names.length; i++){
			int idx = -1;
			listIndex.clear();
			for(int j = 0; j < i ; j++){
				if(names[j].equals(names[i])){
					idx = 0;
					listIndex.add(idx);
				}else if (names[j].startsWith(names[i]+"(")) {
					String index = names[j].substring(names[i].length()) ;
					try {
						idx = Integer.parseInt(index.substring(1,index.length()-1));
						listIndex.add(idx);
					} catch(Exception e){}
				}
			}
			if(!listIndex.isEmpty()){
				names[i] = names[i]  + getIndex(listIndex);
			}
		}
		return names;
	}
	
	String getIndex(List<Integer> listIndex) {
		Collections.sort(listIndex);
		if(listIndex.get(0) != 0) return "";
		for(int i = listIndex.get(0); i < listIndex.get(listIndex.size()-1); i++){
			if(!listIndex.contains(i)) return "("+i+")";
		}
		return "("+(listIndex.get(listIndex.size()-1)+1)+")";
	}
	
	List<String> fileNaming2(String[] names){
		List<String> results = new ArrayList<>();
	    for (String name : names){
	        String result = name;
	        if(results.contains(name)){
	            int i = 1;
	            while(results.contains(result= name+"("+(i++)+")")){
	            }
	        }
	        results.add(result);
	        
	    }
	    return results;
	}
	
	String[] fileNaming3(String[] names) {
		Map<String, Integer> mapName =  new HashMap<>();
		List<String> lsName = new ArrayList<String>();
		for(String name : names) {
			String nameProcess = name;
			int i = 1;
			if(mapName.get(name) == null){
				mapName.put(name, 1);
			} else {
				while (mapName.get(name+ "(" + i + ")") != null) {
					i++;
				}
				nameProcess = name+ "(" + i + ")";
				mapName.put(nameProcess, i);
			}
			lsName.add(nameProcess);
		}
		return lsName.toArray(new String[lsName.size()]);
	}
	
	
	String messageFromBinaryCode(String code) {
		int count = 0;
		StringBuilder builder = new StringBuilder();
		while(count + 8 <= code.length()){
			String s = code.substring(count,count+8);
			char c = (char) Integer.parseInt(s,2);
			count += 8;
			builder.append(c);
		}
		return builder.toString();
	}
	
	int[][] spiralNumbers(int n) {
		int[][] result = new int[n][n];
		boolean[][] mark = new boolean[n][n];
		int N = n*n;
		for(int i = 0; i <= n/2; i++){
			buildCycle(i,result,n);
		}
		printMatrix(result);
		return result;
	}

	void buildCycle(int i, int[][] result, int n) {
		if(i == (n-1)/2) {
			if(n % 2 == 1){
				result[i][i] = n*n;
				return;
			} else {
				result[i+1][i] = n*n;
				result[i+1][i+1] = n*n-1;
				result[i][i+1] = n*n-2;
				result[i][i] = n*n-3;
				return;
			}
		}
		int count = (i == 0 ? 0 : result[i][i-1]);
		for(int j = i; j < n - i ; j++){
			result[i][j] = ++count; 
		}
		for(int j = i; j < n - i - 1; j++){
			result[j+1][n-i-1] = ++count;
		}
		for(int j = n - i - 2; j >= i; j--){
			result[n-i-1][j] = ++count;
		}
		for(int j = n - i - 2; j > i; j--){
			result[j][i] = ++count;
		}
	}
	
	void printMatrix(int[][] graph){
		for(int i = 0; i < graph.length; i++){
			for(int j = 0; j < graph[0].length; j++){
				System.out.print(graph[i][j] + "\t");
			}
			System.out.println();
		}
	}
	
	boolean sudoku(int[][] grid) {
		for(int i =0; i < 9; i++){
			if(!checkSudoku(grid[i])) return false;
		}
		
		for(int i=0 ; i < 9; i++){
			int[] tmp = new int[9];
			for(int j=0; j < 9; j++){
				tmp[j] = grid[j][i];
			}
			if(!checkSudoku(tmp)) return false;
		}
		
		for(int i=0 ; i < 9; i++){
			int rowIdx = (i/3) *3;
			int colIdx = (i%3) *3;
			int[] tmp = new int[9];
			int count = 0;
			for(int r = rowIdx; r < rowIdx + 3; r++){
				for(int c = colIdx; c < colIdx + 3; c++){
					tmp[count++] = grid[r][c];
				}
			}
			if(!checkSudoku(tmp)) return false;
		}
		
		return true;
	}
	
	boolean checkSudoku(int[] arrCheck){
		for(int i = 0; i < arrCheck.length - 1; i++){
			if(arrCheck[i] < 0 || arrCheck[i] > 9) return false;
			for(int j = i+1; j < arrCheck.length; j++){
				if(arrCheck[j] <0 || arrCheck[j] > 9 || arrCheck[i] == arrCheck[j]) return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		Level12 test = new Level12();
//		int[][] grid = {{1,3,2,5,4,6,9,8,7}, 
//				 {4,6,5,8,7,9,3,2,1}, 
//				 {7,9,8,2,1,3,6,5,4}, 
//				 {9,2,1,4,3,5,8,7,6}, 
//				 {3,5,4,7,6,8,2,1,9}, 
//				 {6,8,7,1,9,2,5,4,3}, 
//				 {5,7,6,9,8,1,4,3,2}, 
//				 {2,4,3,6,5,7,1,9,8}, 
//				 {8,1,9,3,2,4,7,6,5}};
//		System.out.println(test.sudoku(grid));
		System.out.println(test.digitsProduct(600));
	}
}
