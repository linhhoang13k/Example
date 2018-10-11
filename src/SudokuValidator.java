/* Determine if provided sudoku grid is solvable (i.e. there are no repeating digits in any column, row, or 3x3 sub-grid)
*/

public class SudokuValidator{
	public static void main(String[] args){
		char[][] validGrid = 
	{{'.', '.', '.', '1', '4', '.', '.', '2', '.'},
	{'.', '.', '6', '.', '.', '.', '.', '.', '.'},
	{'.', '.', '.', '.', '.', '.', '.', '.', '.'},
	{'.', '.', '1', '.', '.', '.', '.', '.', '.'},
	{'.', '6', '7', '.', '.', '.', '.', '.', '9'},
	{'.', '.', '.', '.', '.', '.', '8', '1', '.'},
	{'.', '.', '.', '.', '.', '.', '.', '.', '6'},
	{'.', '3', '.', '.', '.', '7', '.', '.', '.'},
	{'.', '.', '.', '5', '.', '.', '.', '7', '.'}};
		System.out.println(sudokuValid(validGrid));
	}
	
	
	public static boolean sudokuValid(char[][] grid){
		int[][] arr = new int[grid.length][grid[0].length];
		for (int i = 0; i < grid.length; i++){
			for (int j = 0; j < grid[0].length; j++){
				if (grid[i][j] != '.'){
					arr[i][j] = Integer.parseInt(grid[i][j] + "");
				}
			}
		}
		for (int i = 0; i < arr.length; i++){
			int[] rowCounts = new int[10];
			int[] colCounts = new int[10];
			for (int j = 0; j < arr[0].length; j++){
				if (arr[i][j] != 0){
					rowCounts[arr[i][j]] += 1;
					if (rowCounts[arr[i][j]] > 1){
						System.out.println(arr[i][j]);
						return false;
					}
				}
				if (arr[j][i] != 0){
					colCounts[arr[j][i]] += 1;
					if (colCounts[arr[j][i]] > 1){
						System.out.println(arr[j][i]);
						return false;
					}
				}
			}
		}
		
		for(int i = 0; i < arr.length; i += 3){
			for (int j = 0; j < arr[0].length; j += 3){
				System.out.println(i + " " + j);
				int[] numCounts = new int[10];
				for (int k = i; k < i + 3; k++){
					for (int l = j; l < j + 3; l++){
						if (arr[k][l] != 0){
							numCounts[arr[k][l]] += 1;
							if (numCounts[arr[k][l]] > 1){
								return false;
							}
						}
					}
				}
			}
		}
		
		return true;
	}
}