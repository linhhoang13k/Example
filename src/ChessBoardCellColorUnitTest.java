package rains.of.reason;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class ChessBoardCellColorUnitTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		System.out.println(((int) "A1".charAt(1)));
	}

	@Test
	public void test1() {
		String cell1 = "A1", cell2 = "C3";

		boolean result = chessBoardCellColor(cell1, cell2);

		assertTrue(result);
	}

	@Test
	public void test3() {
		String cell1 = "A1", cell2 = "A2";

		boolean result = chessBoardCellColor(cell1, cell2);

		assertFalse(result);
	}

	boolean chessBoardCellColor(String cell1, String cell2) {

		boolean[][] chessBoard = new boolean[8][8];

		boolean blackColor = false;

		for (int num = 0; num < chessBoard.length; num++) {
			blackColor = !blackColor;
			for (int letter = 0; letter < chessBoard[num].length; letter++) {
				chessBoard[num][letter] = blackColor;
				blackColor = !blackColor;
			}
		}

		int numCell1 = cell1.charAt(1) - 49;
		int letterCell1 = cell1.charAt(0) - 65;
		int numCell2 = cell2.charAt(1) - 49;
		int letterCell2 = cell2.charAt(0) - 65;

		return chessBoard[numCell1][letterCell1] == chessBoard[numCell2][letterCell2];
	}

}
