package solutions;

public class MatrixPerimeter {

	public static void main(String[] args) {

		boolean[][] matrix = new boolean[][] { 
			{ false, true , true ,true}, 
			{ false, false,false, true }, 	
			{ false, false,true, true }, 
			{ false, false,true, true } 
		};

		System.out.println(new MatrixPerimeter().matrixPerimeter(matrix));
	}

	/* To find the total perimeter of the matrix , first check 
	 * each element and assume it will add a total of 4 (local perimeter) 
	 * to the total perimeter. Then, for each neighbor (an element located 
	 * the to the left, to the right , above or below the element we are checking), 
	 * decrease the total perimeter by one.
	 */
	int matrixPerimeter(boolean[][] matrix) {
		int perimeter = 0;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				int localPerimeter = 4;
				if (matrix[i][j]) {
					// checking for a neighbor on the left 
					if (i - 1 >= 0 && matrix[i - 1][j]) {
						localPerimeter--;
					}
					// checking for a neighbor on the right
					if (i + 1 < matrix.length && matrix[i + 1][j]) {
						localPerimeter--;
					}
					// checking for a neighbor below
					if (j - 1 >= 0 && matrix[i][j - 1]) {
						localPerimeter--;
					}
					// checking for a neighbor above 
					if (j + 1 < matrix[i].length && matrix[i][j + 1]) {
						localPerimeter--;
					}
					perimeter += localPerimeter;
				}
			}

		}

		return perimeter;
	}

}
