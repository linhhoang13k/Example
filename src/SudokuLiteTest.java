package exercise60;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class SudokuLiteTest {

	private SudokuLite underTest;
	private int[][] validGrid1 = {{1,3,2,5,4,6,9,8,7}, 
	                         {4,6,5,8,7,9,3,2,1}, 
	                         {7,9,8,2,1,3,6,5,4}, 
	                         {9,2,1,4,3,5,8,7,6}, 
	                         {3,5,4,7,6,8,2,1,9}, 
	                         {6,8,7,1,9,2,5,4,3}, 
	                         {5,7,6,9,8,1,4,3,2}, 
	                         {2,4,3,6,5,7,1,9,8}, 
	                         {8,1,9,3,2,4,7,6,5}};
	
	private int[][] invalidHorizontal = {{1,3,2,5,4,6,9,2,7}, 
	                                {4,6,5,8,7,9,3,8,1}, 
	                                {7,9,8,2,1,3,6,5,4}, 
	                                {9,2,1,4,3,5,8,7,6}, 
	                                {3,5,4,7,6,8,2,1,9}, 
	                                {6,8,7,1,9,2,5,4,3}, 
	                                {5,7,6,9,8,1,4,3,2}, 
	                                {2,4,3,6,5,7,1,9,8}, 
	                                {8,1,9,3,2,4,7,6,5}};
	
	private int[][] invalidSmallerGrids = 
									{{1,3,4,2,5,6,9,8,7}, 
	                                {4,6,8,5,7,9,3,2,1}, 
	                                {7,9,2,8,1,3,6,5,4}, 
	                                {9,2,3,1,4,5,8,7,6}, 
	                                {3,5,7,4,6,8,2,1,9}, 
	                                {6,8,1,7,9,2,5,4,3}, 
	                                {5,7,6,9,8,1,4,3,2}, 
	                                {2,4,5,6,3,7,1,9,8}, 
	                                {8,1,9,3,2,4,7,6,5}};
	
	private int[][] invalidVertical = {{1,2,3,4,5,6,7,8,9}, 
	                                   {4,6,5,8,7,9,3,2,1}, 
	                                   {7,9,8,2,1,3,6,5,4}, 
	                                   {1,2,3,4,5,6,7,8,9}, 
	                                   {4,6,5,8,7,9,3,2,1}, 
	                                   {7,9,8,2,1,3,6,5,4}, 
	                                   {1,2,3,4,5,6,7,8,9}, 
	                                   {4,6,5,8,7,9,3,2,1}, 
	                                   {7,9,8,2,1,3,6,5,4}};
	
	@Before
	public void setup() {
		underTest = new SudokuLite();
	}
	
	@Test
	public void shouldReturnTrue() {
		assertTrue(underTest.sudoku(validGrid1));
	}
	
	@Test
	public void shouldReturnFalseTestCase2() {
		assertFalse(underTest.sudoku(invalidHorizontal));
	}
	
	@Test
	public void shouldReturnFalseTestCase3() {
		assertFalse(underTest.sudoku(invalidSmallerGrids));
	}
	
	@Test
	public void shouldReturnFalseTestCase5() {
		assertFalse(underTest.sudoku(invalidVertical));
	}
}
