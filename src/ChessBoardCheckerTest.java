package exercise29;

import static org.junit.Assert.*;

import org.junit.Test;

public class ChessBoardCheckerTest {

	@Test
	public void shouldReturnTrueA1andC3() {
		ChessBoardChecker underTest = new ChessBoardChecker();
		String cell1 = "A1";
		String cell2 = "C3";
		boolean response = underTest.chessBoardCellColor(cell1, cell2);
		assertEquals(true, response);
	}
	
	@Test
	public void shouldReturnFalseA1andH3() {
		ChessBoardChecker underTest = new ChessBoardChecker();
		String cell1 = "A1";
		String cell2 = "H3";
		boolean response = underTest.chessBoardCellColor(cell1, cell2);
		assertEquals(false, response);
	}
	
	@Test
	public void shouldReturnTrueA1andB2() {
		ChessBoardChecker underTest = new ChessBoardChecker();
		String cell1 = "A1";
		String cell2 = "B2";
		boolean response = underTest.chessBoardCellColor(cell1, cell2);
		assertEquals(true, response);
	}
}
