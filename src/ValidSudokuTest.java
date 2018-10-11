import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ValidSudokuTest {

    @Test
    public void testValidSudoku() {
        boolean expectedOutput = true;

        char[][] testInput =
                {{'.', '.', '.', '1', '4', '.', '.', '2', '.'},
                        {'.', '.', '6', '.', '.', '.', '.', '.', '.'},
                        {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                        {'.', '.', '1', '.', '.', '.', '.', '.', '.'},
                        {'.', '6', '7', '.', '.', '.', '.', '.', '9'},
                        {'.', '.', '.', '.', '.', '.', '8', '1', '.'},
                        {'.', '3', '.', '.', '.', '.', '.', '.', '6'},
                        {'.', '.', '.', '.', '.', '7', '.', '.', '.'},
                        {'.', '.', '.', '5', '.', '.', '.', '7', '.'}};

        boolean actualResult = ValidSudoku.sudoku2(testInput);
        assertEquals(expectedOutput, actualResult);
    }

    @Test
    public void testInvalidSudokuColumn() {
        boolean expectedOutput = false;

        char[][] testInput =
                {{'.', '.', '.', '.', '2', '.', '.', '9', '.'},
                        {'.', '.', '.', '.', '6', '.', '.', '.', '.'},
                        {'7', '1', '.', '.', '2', '5', '.', '.', '.'},
                        {'.', '7', '.', '.', '.', '.', '.', '.', '.'},
                        {'.', '.', '.', '.', '8', '3', '.', '.', '.'},
                        {'.', '.', '8', '.', '.', '7', '.', '6', '.'},
                        {'.', '.', '.', '.', '.', '2', '.', '.', '.'},
                        {'.', '1', '.', '2', '.', '.', '.', '.', '.'},
                        {'.', '2', '.', '.', '3', '.', '.', '.', '.'}};

        boolean actualResult = ValidSudoku.sudoku2(testInput);
        assertEquals(expectedOutput, actualResult);
    }

    @Test
    public void testInvalidSudokuRow() {
        boolean expectedOutput = false;

        char[][] testInput =
                {{'.', '.', '.', '.', '2', '.', '.', '9', '.'},
                        {'.', '.', '.', '.', '6', '.', '.', '.', '.'},
                        {'7', '1', '.', '.', '7', '5', '.', '.', '.'},
                        {'.', '7', '.', '.', '.', '.', '.', '.', '.'},
                        {'.', '.', '.', '.', '8', '3', '.', '.', '.'},
                        {'.', '.', '8', '.', '.', '7', '.', '6', '.'},
                        {'.', '.', '.', '.', '.', '2', '.', '.', '.'},
                        {'.', '1', '.', '2', '.', '.', '.', '.', '.'},
                        {'.', '2', '.', '.', '3', '.', '.', '.', '.'}};

        boolean actualResult = ValidSudoku.sudoku2(testInput);
        assertEquals(expectedOutput, actualResult);
    }

    @Test
    public void testValidX3Grid() {
        boolean expectedOutput = true;

        char[][] testInput =
                {{'.', '.', '.', '.', '8', '.', '.', '.', '.'},
                        {'.', '.', '.', '.', '.', '.', '5', '.', '.'},
                        {'.', '.', '.', '.', '4', '.', '.', '2', '.'},
                        {'.', '.', '.', '3', '.', '9', '.', '.', '.'},
                        {'.', '.', '1', '8', '.', '.', '9', '.', '.'},
                        {'.', '.', '.', '.', '.', '5', '1', '.', '.'},
                        {'.', '.', '3', '.', '.', '8', '.', '.', '.'},
                        {'.', '1', '2', '.', '3', '.', '.', '.', '.'},
                        {'.', '.', '.', '.', '.', '7', '.', '.', '1'}};

        boolean actualResult = ValidSudoku.sudoku2(testInput);
        assertEquals(expectedOutput, actualResult);
    }

    @Test
    public void testInvalidSudoku() {
        boolean expectedOutput = true;

        char[][] testInput =
                {{'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                        {'4', '.', '.', '.', '.', '.', '.', '.', '.'},
                        {'.', '.', '.', '.', '.', '.', '6', '.', '.'},
                        {'.', '.', '.', '3', '8', '.', '.', '.', '.'},
                        {'.', '5', '.', '.', '.', '6', '.', '.', '1'},
                        {'8', '.', '.', '.', '.', '.', '.', '6', '.'},
                        {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                        {'.', '.', '7', '.', '9', '.', '.', '.', '.'},
                        {'.', '.', '.', '6', '.', '.', '.', '.', '.'}};

        boolean actualResult = ValidSudoku.sudoku2(testInput);
        assertEquals(expectedOutput, actualResult);
    }

    @Test
    public void testSecondInvalidSudoku() {
        boolean expectedOutput = false;

        char[][] testInput =
                {{'.', '8', '.', '.', '.', '.', '.', '.', '.'},
                        {'.', '.', '.', '.', '2', '.', '.', '.', '.'},
                        {'.', '6', '.', '.', '.', '.', '1', '.', '4'},
                        {'.', '.', '.', '9', '.', '.', '7', '.', '.'},
                        {'.', '.', '.', '.', '.', '.', '.', '4', '.'},
                        {'.', '.', '1', '.', '.', '8', '.', '.', '.'},
                        {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                        {'.', '.', '.', '.', '.', '5', '.', '7', '.'},
                        {'.', '.', '3', '.', '.', '5', '6', '.', '.'}};

        boolean actualResult = ValidSudoku.sudoku2(testInput);
        assertEquals(expectedOutput, actualResult);
    }

    @Test
    public void testThirdInvalidSudoku() {
        boolean expectedOutput = false;

        char[][] testInput =
                {{'.', '.', '.', '.', '.', '.', '5', '.', '.'},
                        {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                        {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                        {'9', '3', '.', '.', '2', '.', '4', '.', '.'},
                        {'.', '.', '7', '.', '.', '.', '3', '.', '.'},
                        {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                        {'.', '.', '.', '3', '4', '.', '.', '.', '.'},
                        {'.', '.', '.', '.', '.', '3', '.', '.', '.'},
                        {'.', '.', '.', '.', '.', '5', '2', '.', '.'}};

        boolean actualResult = ValidSudoku.sudoku2(testInput);
        assertEquals(expectedOutput, actualResult);
    }
}
