package CodeFight;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by tranpham on 3/15/18.
 */
public class ArcadeTest {
    @Test
    public void binaryToChar() throws Exception {
        Assert.assertEquals(arcade.binaryToChar("01001000"),'H');
    }

    @Test
    public void isBeautifulString() throws Exception {
        Assert.assertFalse(arcade.isBeautifulString("zaa"));
    }

    @Test
    public void stringsRearrangement() throws Exception {
        String[] inputArray= {"abc",
                "bef",
                "bcc",
                "bec",
                "bbc",
                "bdc"};
        boolean expected= true;
        boolean actual = arcade.stringsRearrangement(inputArray);
        Assert.assertEquals(expected,actual);

        String[] inputArray2= {"ab", "bb", "aa"};
        expected= true;
        actual = arcade.stringsRearrangement(inputArray2);
        Assert.assertEquals(expected,actual);

        String[] inputArray3= {"abc", "abx", "axx", "abc"};
        expected= false;
        actual = arcade.stringsRearrangement(inputArray3);
        Assert.assertEquals(expected,actual);

    }

    @Test
    public void absoluteValuesSumMinimization() throws Exception {
        int[] a = {-1000000, -10000, -10000, -1000, -100, -10, -1, 0, 1, 10, 100, 1000, 10000, 100000, 1000000};
        int expected = 0;
        int res = arcade.absoluteValuesSumMinimization(a);
        Assert.assertEquals(expected,res);
    }

    @Test
    public void zigzag() throws Exception {
        int[] a = {9, 8, 8, 5, 3, 5, 3, 2, 8, 6};
        int expected = 4;
        int actual = arcade.zigzag(a);
        Assert.assertEquals(expected,actual);

        int[] b = {2, 1, 4, 4, 1, 4, 4, 1, 2, 0, 1, 0, 0, 3, 1, 3, 4, 1, 3, 4};
        expected = 4;
        actual = arcade.zigzag(b);
        Assert.assertEquals(expected,actual);

    }

    @Test
    public void palindromeRearranging() throws Exception {
    }

    @Test
    public void minesweeper() throws Exception {
        boolean[][] matrix = {{true,false,false},
                            {false,true,false},
                            {false,false,false}};

        int[][] expected = {{1,2,1},
                            {2,1,1},
                            {1,1,1}};

        int[][] actual = arcade.minesweeper(matrix);

        Assert.assertArrayEquals(expected,actual);
    }

    @Test
    public void isIPv4Address() throws Exception {
        String inputString= "172.316.254.1";
        boolean expected = false;
        boolean actual = arcade.isIPv4Address(inputString);
        Assert.assertEquals(expected,actual);
    }

    Arcade arcade = new Arcade();
    @Test
    public void reverseParentheses() throws Exception {
        String input= "abc(def)gh";
        String expected = "abcfedgh";
        String actual = arcade.reverseParentheses(input);
        Assert.assertEquals(expected,actual);

        input= "a(bcdefghijkl(mno)p)q";
        expected = "apmnolkjihgfedcbq";
        actual = arcade.reverseParentheses(input);
        Assert.assertEquals(expected,actual);

        input= "((b))";
        expected = "b";
        actual = arcade.reverseParentheses(input);
        Assert.assertEquals(expected,actual);

    }

}