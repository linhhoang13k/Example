package com.paigeruppel.interviewpractice.arrays;

import java.util.HashSet;
import java.util.Set;

public class SudokuSolve {

	public boolean sudoku2(String[][] grid) {
		return isValidHorizontalAndVertical(grid) && isValidSmallerGrids(grid);
	}

	private boolean isValidHorizontalAndVertical(String[][] grid) {
		Set<String> rowSet = new HashSet<>();
		Set<String> colSet = new HashSet<>();
		for (int coord1 = 0; coord1 < grid.length; coord1++) {
			for (int coord2 = 0; coord2 < grid.length; coord2++) {
				String rowClue = grid[coord1][coord2];
				String colClue = grid[coord2][coord1];
				if (isNotBlank(rowClue) && rowSet.contains(rowClue)
						|| isNotBlank(colClue) && colSet.contains(colClue)) {
					return false;
				}
				if (!rowSet.contains(rowClue)) {
					rowSet.add(rowClue);
				}
				if (!colSet.contains(colClue)) {
					colSet.add(colClue);
				}
			}
			rowSet.clear();
			colSet.clear();
		}
		return true;
	}

	private boolean isValidSmallerGrids(String[][] grid) {
		Set<String> present = new HashSet<>();
		int colStart = 0;
		while (colStart < 7) {
			for (int row = 0; row < grid.length; row++) {
				if (row == 0 || row == 3 || row == 6) {
					present.clear();
				}
				for (int col = colStart; col < colStart + 3; col++) {
					String clue = grid[row][col];
					if (isNotBlank(clue) && present.contains(clue)) {
						return false;
					}
					if (!present.contains(clue)) {
						present.add(clue);
					}
				}
			}
			colStart += 3;
		}
		return true;
	}

	private boolean isNotBlank(String horClue) {
		return !horClue.equals(".");
	}
}
