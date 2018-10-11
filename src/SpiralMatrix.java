package exercise59;

public class SpiralMatrix {

	public int[][] spiralNumbers(int n) {
		int[][] spiral = new int[n][n];

		int left = 0;
		int right = n - 1;
		int top = 0;
		int bottom = n - 1;

		for (int counter = 1; counter <= n * n;) {
			//start at the top and build out first row
			for (int col = left; col <= right; col++) {
				spiral[top][col] = counter++;
			}
			//increment top (so that what is already filled in will not be overwritten)
			top++;

			//start at remaining top for row and work down col
			for (int row = top; row <= bottom; row++) {
				spiral[row][right] = counter++;
			}
			
			//decrement right so that filled in col will not be overwritten/edges move toward center
			right--;

			//start at the right edge and move towards the left
			for (int col = right; col >= left; col--) {
				spiral[bottom][col] = counter++;
			}
			
			//decrement bottom edge/move towards center
			bottom--;

			//start at the bottom row and move up to the top edge to build left col
			for (int row = bottom; row >= top; row--) {
				spiral[row][left] = counter++;
			}
			
			//increment left edge/move towards center
			left++;
		}

		return spiral;
	}
}
