package exercise50;

import java.util.regex.Pattern;

public class ChessBoard {

	/*
	 * Given a position of a knight on the standard chessboard, find the number of
	 * different moves the knight can perform.
	 * 
	 * The knight can move to a square that is two squares horizontally and one
	 * square vertically, or two squares vertically and one square horizontally away
	 * from it. The complete move therefore looks like the letter L. Check out the
	 * image below to see all valid moves for a knight piece that is placed on one
	 * of the central squares.
	 */

	public int chessKnight(String cell) {
		cell = cell.toUpperCase();
		int moves = 8;
		if (cell.charAt(0) == 'B' || cell.charAt(0) == 'G') { 
			// second row from left or right will always lose two moves
			moves -= 2;
		}
		if (cell.charAt(1) == '2' || cell.charAt(1) == '7') { 
			// second row from top or bottom will always lose two moves
			moves -= 2;
		}
		if (cell.charAt(0) == 'A' || cell.charAt(0) == 'H') { 
			// row on left or right edge will always have possible moves cut in half
			moves /= 2;
		}
		if (cell.charAt(1) == '1' || cell.charAt(1) == '8') { 
			// row on top or bottom edge will always have possible moves cut in half
			moves /= 2;
		}
		return moves;
	}

}
