package tiendm.codefight.core;

import java.util.ArrayList;
import java.util.List;

public class WaterfallIntergration {
	//////////////////////////////////////////////////
	int[][] minesweeper(boolean[][] matrix) {
		int[][] sum = new int[matrix.length][matrix[0].length];
		for(int i = 0; i < matrix.length; i ++){
			for(int j = 0; j < matrix[0].length; j++){
				if(check(matrix, i, j-1)) sum[i][j]++;
				if(check(matrix, i-1, j-1)) sum[i][j]++;
				if(check(matrix, i-1, j)) sum[i][j]++;
				if(check(matrix, i-1, j+1)) sum[i][j]++;
				if(check(matrix, i, j+1)) sum[i][j]++;
				if(check(matrix, i+1, j+1)) sum[i][j]++;
				if(check(matrix, i+1, j)) sum[i][j]++;
				if(check(matrix, i+1, j-1)) sum[i][j]++;
			}
		}
		return sum;
	}
	boolean check(boolean[][] matrix, int i, int j){
		try {
			return matrix[i][j];
		} catch (Exception e) {
			return false;
		}
	}
	
	//////////////////////////////////////////////////
	int[][] boxBlur(int[][] image) {
		int [][] result = new int[image.length-2][image[0].length-2];
		for(int i = 0; i < image.length-2; i++){
			for(int j = 0; j < image[i].length-2; j++){
				result[i][j] = avg(image,i,j);
			}
		}
		return result;
	}

	int avg(int[][] image, int a, int b) {
		int sum = 0;
		for(int i = a; i < a + 3; i ++){
			for(int j = b; j < b + 3; j++){
				sum += image[i][j]; 
			}
		}
		return sum/9;
	}
	
	
	///////////////////////////////////////////////////
	int[][] contoursShifting(int[][] matrix) {
		boolean lockCycle = true;
		int row = matrix.length, col = matrix[0].length;
		for(int i = 0; i < (col+1)/2 && i < (row+1)/2; i++){
			if(lockCycle){
				if(i == row/2){
					int tmp = matrix[i][col-i-1];
					for(int j = col-i-1; j > i; j--){
						matrix[i][j] = matrix[i][j-1];
					}
					matrix[i][i] = tmp;
				}else if (i == col/2) {
					int tmp = matrix[row-i-1][i];
					for(int j = row-i-1; j > i; j--){
						matrix[j][i] = matrix[j-1][i];
					}
					matrix[i][i] = tmp;
				}else {
					int tmp = matrix[i][i];
					for(int j = i; j < row-i-1; j++){
						matrix[j][i] = matrix[j+1][i];
					}
					for(int j = i; j < col-i-1; j++){
						matrix[row-1-i][j] = matrix[row-1-i][j+1];
					}
					for(int j = row-i-1 ; j > i; j--){
						matrix[j][col-i-1] = matrix[j-1][col-i-1];
					}
					for(int j = col-i-1; j > i+1; j--){
						matrix[i][j] = matrix[i][j-1];
					}
					matrix[i][i+1] = tmp;
				}
			}else {
				if(i == row/2){
					int tmp = matrix[i][i];
					for(int j = i; j < col-i-1; j++){
						matrix[i][j] = matrix[i][j+1];
					}
					matrix[i][col-i-1] = tmp;
				}else if (i == col/2) {
					int tmp = matrix[i][i];
					for(int j = i; j < row-i-1; j++){
						matrix[j][i] = matrix[j+1][i];
					}
					matrix[row-i-1][i] = tmp;
				}else {
					int tmp = matrix[i][i];
					for(int j = i; j < col-i-1; j++){
						matrix[i][j] = matrix[i][j+1];
					}
					for(int j = i; j < row-i-1; j++){
						matrix[j][col-i-1] = matrix[j+1][col-i-1];
					}
					for(int j = col-i-1 ; j > i; j--){
						matrix[row-i-1][j] = matrix[row-i-1][j-1];
					}
					for(int j = row-i-1; j > i+1; j--){
						matrix[j][i] = matrix[j-1][i];
					}
					matrix[i+1][i] = tmp;
				}
			}
			lockCycle = !lockCycle;
		}
		return matrix;
	}
	
	///////////////////////////////////////////////////
	int polygonPerimeter(boolean[][] matrix) {
		int count = 0, neighbor = 0, r = matrix.length, c = matrix[0].length;
		for(int i = 0; i < r; i++){
			for(int j = 0; j < c-1; j++){
				if(matrix[i][j]){
					count++;
					if(matrix[i][j+1]) neighbor++;
				}
			}
			if(matrix[i][c-1]) count++;
		}
		for(int i = 0; i < c; i++){
			for(int j = 0; j < r-1; j++){
				if(matrix[j][i] && matrix[j+1][i]) neighbor++;
			}
		}
		return count * 4 - neighbor*2;
	}
	
	///////////////////////////////////////////////////
	List<Integer> gravitation(String[] rows) {
		List<Integer> lsReturn = new ArrayList<>();
		int r = rows.length, c = rows[0].length(), min = Integer.MAX_VALUE;
		char[][] box = new char[rows.length][rows[0].length()];
		for(int i = 0; i < r; i++){
			box[i] = rows[i].toCharArray();
		}
		int[] w =  new int[c], w2 =  new int[c];
		for(int j = r-1; j > 0; j--){
			for(int i = 0; i < c ; i++){
				if(box[j][i] == '.') w2[i]++;
				else {
					w[i] += w2[i];
					w2[i] = 0;
				}
			}
		}
		for(int i = 0; i < w.length; i++){
			if(box[0][i] == '#') w[i] += w2[i];
			if(w[i] < min){
				min = w[i];
				lsReturn.clear();
				lsReturn.add(i);
			}else if (w[i] == min) {
				lsReturn.add(i);
			}
		}
		return lsReturn;
	}
	
	/////////////////////////////////////////////////////////////////
	boolean isInformationConsistent(int[][] evidences) {
		for(int i = 0; i < evidences[0].length; i++){
			int check = 0;
			for(int j = 0; j < evidences.length; j++){
				if(evidences[j][i] != 0 && check!=0 && evidences[j][i]!= check) return false;
				check = evidences[j][i];
			}
		}
		return true;
	}
	
	
	/////////////////////////////////////////////////////////////////
	boolean correctNonogram(int size, String[][] nonogramField) {
		int first = (size+1)/2, r = nonogramField.length, c = nonogramField[0].length;
		String[] strRow = new String[r]; 
		String[] strCol = new String[c];
		for(int i = 0; i < r; i ++){
			StringBuilder builder = new StringBuilder();
			for(String s : nonogramField[i]){
				builder.append(s);
			}
			strRow[i] = builder.toString();
		}
		for(int i = 0; i < r; i ++){
			StringBuilder builder = new StringBuilder();
			for(int j = 0; j < c ; j++){
				builder.append(nonogramField[j][i]);
			}
			strCol[i] = builder.toString();
		}
		
		for(int i = first; i < r; i++){
			int idx = 0;
			boolean hasColor = false;
			for(int j = 0; j < c && !hasColor ; j++){
				int num = getDigit(nonogramField[i][j]);
				if(num == -1) continue;
				idx = j;
				for(int k = j+1; k < c; k++){
					if(isColor(nonogramField[i][k])) {
						hasColor = true;
						break;
					}
				}
			}
			if(!hasColor) continue;
			List<Integer> lsBlack = new ArrayList<>();
			int count = idx;
			while (getDigit(nonogramField[i][count]) > -1) {
				lsBlack.add(getDigit(nonogramField[i][count]));
				count++;
			}
			count = 0;
			String check = strRow[i].substring(idx);
			while (count < lsBlack.size()) {
				int nBlack = lsBlack.get(count);
				String strBlack = String.format("%"+nBlack+"s", " ").replace(" ", "#");
				if(count == 0){
					if(!check.contains(strBlack)){
						return false;
					}
				}else {
					if(!check.contains("."+strBlack)){
						return false;
					}
				}
				count++;
				check = check.substring(check.indexOf(strBlack));
			}
		}
		for(int j= first; j < c; j++){
			int idx = 0;
			boolean hasColor = false;
			for(int i= 0; i < r && !hasColor; i++){
				int num = getDigit(nonogramField[i][j]);
				if(num == -1) continue;
				idx = i;
				for(int k = i+1; k < r; k++){
					if(isColor(nonogramField[k][j])) {
						hasColor = true;
						break;
					}
				}
			}
			if(!hasColor) continue;
			List<Integer> lsBlack = new ArrayList<>();
			int count = idx;
			while (getDigit(nonogramField[count][j]) > -1) {
				lsBlack.add(getDigit(nonogramField[count][j]));
				count++;
			}
			count = 0;
			String check = strCol[j].substring(idx);
			while (count < lsBlack.size()) {
				int nBlack = lsBlack.get(count);
				String strBlack = String.format("%"+nBlack+"s", " ").replace(" ", "#");
				if(count == 0){
					if(!check.contains(strBlack)){
						return false;
					}
				}else {
					if(!check.contains("."+strBlack)){
						return false;
					}
				}
				count++;
				check = check.substring(check.indexOf(strBlack));
			}
		}
		return true;
	}
	
	int getDigit(String s){
		try {
			return Integer.parseInt(s);
		} catch (Exception e) {
			return -1;
		}
	}
	
	boolean isColor(String s){
		return s.equals(".") || s.equals("#");
	}
	
	public static void main(String[] args) {
		WaterfallIntergration test = new WaterfallIntergration();
	    String[][] x =  {{"-","-","-","-","-","-","-","-","1","1","-","-","-","-","-"}, 
			    		 {"-","-","-","-","-","-","1","-","1","1","-","1","-","-","-"}, 
			    		 {"-","-","-","-","-","-","2","1","1","1","1","1","-","-","-"}, 
			    		 {"-","-","-","-","-","3","1","1","1","1","2","1","1","1","1"}, 
			    		 {"-","-","-","-","-","4","3","1","1","1","1","1","3","4","4"}, 
			    		 {"-","-","2","1","2","#","#",".",".",".","#",".","#","#","."}, 
			    		 {"-","1","1","1","1","#",".",".","#",".",".","#",".",".","#"}, 
			    		 {"-","-","-","2","1","#","#",".",".",".",".",".",".","#","."}, 
			    		 {"-","-","-","-","4",".","#","#","#","#",".",".",".",".","."}, 
			    		 {"-","-","-","-","2",".",".",".",".",".",".","#","#",".","."}, 
			    		 {"-","-","1","3","2",".","#",".","#","#","#",".",".","#","#"}, 
			    		 {"-","-","-","1","5","#",".",".",".",".","#","#","#","#","#"}, 
			    		 {"-","-","-","5","2","#","#","#","#","#",".",".","#","#","."}, 
			    		 {"-","-","-","2","2","#","#",".",".",".",".",".","#","#","."}, 
			    		 {"-","-","-","7","1","#","#","#","#","#","#","#",".",".","#"}};
		System.out.println(test.correctNonogram(10,x));
	}
}
