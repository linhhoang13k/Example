package exercise50;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class ChessBoardTest {

	private ChessBoard underTest;

	@Before
	public void setup() {
		underTest = new ChessBoard();
	}
	
	@Test
	public void shouldReturnTwoPossibleMovesFromPositionA1() {
		assertThat(underTest.chessKnight("A1"), is(2));
	}
	
	@Test
	public void shouldReturnSixPossibleMovesFromPositionC2() {
		assertThat(underTest.chessKnight("C2"), is(6));
	}
	
	@Test
	public void shouldReturnEightPossibleMovesFromPositionD4() {
		assertThat(underTest.chessKnight("D4"), is(8));
	}
	
	@Test
	public void shouldReturnSixPossibleMovesFromPositionG6() {
		assertThat(underTest.chessKnight("G6"), is(6));
	}
	
	@Test
	public void shouldReturnThreePossibleMovesFromPositionB8() {
		assertThat(underTest.chessKnight("B8"), is(3));
	}
	
}
