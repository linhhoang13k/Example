package interviewpractice.hashTables;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author benmakusha
 */

public class SwapLexOrderTest {

    private SwapLexOrder swap = new SwapLexOrder();

    private String inputStr = "abdc";
    private int[][] inputPairsArray = new int[][] {
            {1, 4},
            {3, 4}
    };
    private String inputStr2 = "abcdefgh";
    private int[][] inputPairsArray2 = new int[][] {
            {1, 4},
            {7, 8}
    };
    private String inputStr3 = "acxrabdz";
    private int[][] inputPairsArray3 = new int[][] {
            {1, 3},
            {6, 8},
            {3, 8},
            {2, 7}
    };
    private String inputStr4 = "z";
    private int[][] inputPairsArray4 = new int[][] {};

    @Test
    public void testSwapLexOrderOne() {
        String result = swap.swapLexOrder(inputStr, inputPairsArray);
        assertEquals("dbca", result);
    }

    @Test
    public void testSwapLexOrderTwo() {
        String result = swap.swapLexOrder(inputStr2, inputPairsArray2);
        assertEquals("dbcaefhg", result);
    }

    @Test
    public void testSwapLexOrderThree() {
        String result = swap.swapLexOrder(inputStr3, inputPairsArray3);
        assertEquals("zdxrabca", result);
    }

    @Test
    public void testSwapLexOrderFour() {
        String result = swap.swapLexOrder(inputStr4, inputPairsArray4);
        assertEquals("z", result);
    }
}