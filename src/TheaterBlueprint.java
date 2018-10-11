package exercise4;

public class TheaterBlueprint {

	public int seatsInTheatre(int nCols, int nRows, int col, int row) {
		int blockedRows = nRows - row;
		int blockedCols = nCols - col + 1; 
		return blockedRows * blockedCols;
	}

}
