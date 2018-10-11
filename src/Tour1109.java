package tiendm.codefight.tournament.sep;

public class Tour1109 {
	int[] extractMatrixColumn(int[][] matrix, int column) {
	    int[] r = new int [matrix.length];
	    for(int i = 0; i < r.length; i++){
	        r[i] = matrix[i][column];
	    }
	    return r;
	}

	boolean findPath(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == 1) {
					return find(matrix, i, j, 1);
				}
			}
		}
		return false;
	}

	boolean find(int[][] matrix, int row, int column, int i) {
		if (i == matrix.length * matrix[0].length)
			return true;
		if (row - 1 >= 0 && matrix[row - 1][column] == i + 1) {
			return find(matrix, row - 1, column, i + 1);
		}

		if (column - 1 >= 0 && matrix[row][column - 1] == i + 1) {
			return find(matrix, row, column - 1, i + 1);
		}

		if (row + 1 < matrix.length && matrix[row + 1][column] == i + 1) {
			return find(matrix, row + 1, column, i + 1);
		}

		if (column + 1 < matrix[0].length && matrix[row][column + 1] == i + 1) {
			return find(matrix, row, column + 1, i + 1);
		}
		return false;
	}
	
	int smallestUnusualNumber(String a) {
	    if(a.indexOf("0") >= 0) return 0;
	    return 10 - (a.charAt(a.length()-1) - '0'); 
	}

	public static void main(String[] args) {
		Tour1109 t = new Tour1109();
		int[][] x = { { 0, 1, 2, 3 }, { 1, 2, 3, 0 }, { 1, 1, 1 } };
		int[] p = { 7, 5, 4, 4, 8 };
		System.out.println(t);
	}
}
