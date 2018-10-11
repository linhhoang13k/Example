package exercise60;
import java.util.HashSet;
import java.util.Set;

public class SudokuLite {

	public boolean sudoku(int[][] grid) {
		return isValidHorizontalAndVertical(grid) && isValidSmallGrids(grid);
	}

	private boolean isValidSmallGrids(int[][] grid) {
		Set<Integer> values = buildPossibleNumbersSet();
		boolean isValid = true;
		int colStart = 0;
		while (colStart < 7 && isValid) {
		for (int row = 0; row < grid.length; row++) {
			for (int col = colStart; col < colStart + 3; col++) {
				if (row == 0 || row == 3 || row == 6) {
					values = buildPossibleNumbersSet();
				}
				int currentNumber = grid[row][col];
				if (!values.contains(currentNumber)) {
					return false;
				}
				values.remove(currentNumber);
			}
		}
		colStart += 3;
		}
		return isValid;
	}
	
	private boolean isValidHorizontalAndVertical(int[][] grid) {
		Set<Integer> horValues = buildPossibleNumbersSet();
		Set<Integer> verValues = buildPossibleNumbersSet();
		boolean isValid = true;
		for (int coord1 = 0; coord1 < grid.length; coord1++) {
			for (int coord2 = 0; coord2 < grid[coord1].length; coord2++) {
				int horNumber = grid[coord1][coord2];
				int verNumber = grid[coord2][coord1];
				if (!horValues.contains(horNumber)) {
					isValid = false;
					break;
				}
				if (!verValues.contains(verNumber)) {
					isValid = false;
					break;
				}
				horValues.remove(horNumber);
				verValues.remove(verNumber);
			}
			horValues = buildPossibleNumbersSet();
			verValues = buildPossibleNumbersSet();
		}
		return isValid;
	}

	private Set<Integer> buildPossibleNumbersSet() {
		Set<Integer> oneThroughNine = new HashSet<>();
		for (int i = 1; i < 10; i++) {
			oneThroughNine.add(i);
		}
		return oneThroughNine;
	}

}
