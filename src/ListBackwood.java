package tiendm.codefight.core;

public class ListBackwood {
	boolean areIsomorphic(int[][] array1, int[][] array2) {
		if(array1.length != array2.length) return false;
	    for(int i = 0; i < array1.length; i++){
	        if(array1[i].length != array2[i].length) return false;
	    }
	    return true;
	}
	
	int[][] reverseOnDiagonals(int[][] matrix) {
		if(matrix.length == 1) return matrix;
		int len = matrix.length;
		for(int i =0; i < len/2 ; i++){
			swap(matrix, i, i, len-i, len-i);
			swap(matrix, i, len-1-i, len-1-i, i);
		}
		return matrix;
	}
	
	int[][] swapDiagonals(int[][] matrix) {
		if(matrix.length == 1) return matrix;
		int len = matrix.length;
		for(int i =0; i < len/2 ; i++){
			swap(matrix, i, i, i, len-i-1);
		}
		
		for(int i =len/2; i < len ; i++){
			swap(matrix, i,len-i-1, i, i);
		}
		
		return matrix;
	}
	void swap(int[][] a, int i, int j, int m, int n){
		int tmp = a[i][j];
		a[i][j] = a[m][n];
		a[m][n] = tmp;
	}
	
	////////////////////////////////////////////
	int crossingSum(int[][] matrix, int a, int b) {
		int sum = 0;
		for(int i = 0; i < matrix[0].length; i++){
			sum += matrix[a][i];
		}
		for(int i = 0; i < matrix.length; i++){
			sum += matrix[i][b];
		}
		return sum - matrix[a][b];
	}
	
	///////////////////////////////////////////
	char[][] drawRectangle(char[][] canvas, int[] rectangle) {
		for(int i = rectangle[0]; i <= rectangle[2]; i++){
			canvas[rectangle[1]][i] = '-';
			canvas[rectangle[3]][i] = '-';
		}
		for(int i = rectangle[1]; i <= rectangle[3]; i++){
			canvas[i][rectangle[0]] = '|';
			canvas[i][rectangle[2]] = '|';
		}
		canvas[rectangle[1]][rectangle[0]] = '*';
		canvas[rectangle[1]][rectangle[2]] = '*';
		canvas[rectangle[3]][rectangle[0]] = '*';
		canvas[rectangle[3]][rectangle[2]] = '*';
		return canvas;
	}
	
	
	/////////////////////////////////////////////
	String[][] volleyballPositions(String[][] formation, int k) {
		for(int i = 0; i < k % 6; i++){
			String tmp = formation[0][1];
			formation[0][1] = formation[1][2];
			formation[1][2] = formation[3][2];
			formation[3][2] = formation[2][1];
			formation[2][1] = formation[3][0];
			formation[3][0] = formation[1][0];
			formation[1][0] = tmp;
		}
		return formation;
	}
	
	int[][] starRotation(int[][] matrix, int width, int[] center, int t) {
		t%=8;
	    width/=2;
	    while (t>0){
	        for (int i = 1; i <= width; i++){
	            int x = center[0];
	            int y = center[1];
	            int temp = matrix[x-i][y-i];
	            matrix[x-i][y-i] = matrix[x][y-i];
	            matrix[x][y-i] = matrix[x+i][y-i];
	            matrix[x+i][y-i] = matrix[x+i][y];
	            matrix[x+i][y] = matrix[x+i][y+i];
	            matrix[x+i][y+i] = matrix[x][y+i];
	            matrix[x][y+i] = matrix[x-i][y+i];
	            matrix[x-i][y+i] = matrix[x-i][y];
	            matrix[x-i][y] = temp;
	        }
	        t--;
	    }
	    return matrix;
	}


	public static void main(String[] args) {
		ListBackwood test = new ListBackwood();
		int[][] x = {{1,0,0,2,0,0,3}, 
					 {0,1,0,2,0,3,0}, 
					 {0,0,1,2,3,0,0}, 
					 {8,8,8,9,4,4,4}, 
					 {0,0,7,6,5,0,0}, 
					 {0,7,0,6,0,5,0}, 
					 {7,0,0,6,0,0,5}};
		System.out.println(test.starRotation(x,3,new int[]{3,3},15));
	}
}
