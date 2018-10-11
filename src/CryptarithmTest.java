import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CryptarithmTest {

    @Test
    public void testValidCryptSolution() {
        String[] testCrypt = {"SEND", "MORE", "MONEY"};
        char[][] testSolution =
                {{'O', '0'},
                        {'M', '1'},
                        {'Y', '2'},
                        {'E', '5'},
                        {'N', '6'},
                        {'D', '7'},
                        {'R', '8'},
                        {'S', '9'}};

        boolean expectedOutput = true;
        boolean actualOutput = Cryptarithm.isCryptSolution(testCrypt, testSolution);

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testInvalidCryptSolution() {
        String[] testCrypt = {"TEN", "TWO", "ONE"};
        char[][] testSolution =
                {{'O', '1'},
                        {'T', '0'},
                        {'W', '9'},
                        {'E', '5'},
                        {'N', '4'}};

        boolean expectedOutput = false;
        boolean actualOutput = Cryptarithm.isCryptSolution(testCrypt, testSolution);

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testSecondValidCryptSolutionOnlyZeroes() {
        String[] testCrypt = {"A", "A", "A"};
        char[][] testSolution =
                {{'A', '0'}};

        boolean expectedOutput = true;
        boolean actualOutput = Cryptarithm.isCryptSolution(testCrypt, testSolution);

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testThirdValidCryptSolution() {
        String[] testCrypt =
                {"AAAAAAAAAAAAAA",
                        "BBBBBBBBBBBBBB",
                        "CCCCCCCCCCCCCC"};
        char[][] testSolution =
                {{'A', '1'},
                        {'B', '2'},
                        {'C', '3'}};

        boolean expectedOutput = true;
        boolean actualOutput = Cryptarithm.isCryptSolution(testCrypt, testSolution);

        assertEquals(expectedOutput, actualOutput);
    }

}
