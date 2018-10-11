import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SmoothSailingTest {

    @Test
    public void allLongestStringsTest() {
        SmoothSailing smoothSailing=new SmoothSailing();
        String[] matrix={"abc",
                "eeee",
                "abcd",
                "dcd"};
        String[] output={"eeee",
                "abcd"};

        Assert.assertArrayEquals(output,smoothSailing.allLongestStrings(matrix));
    }

    @Test
    public void commonCharacterCountTest() {
        SmoothSailing smoothSailing=new SmoothSailing();
        Assert.assertEquals(1,smoothSailing.commonCharacterCount("a","aaa"));
    }

    @Test
    public void isLuckyTest() {
        SmoothSailing smoothSailing=new SmoothSailing();
        Assert.assertTrue(smoothSailing.isLucky(123321));
    }

    @Test
    public void sortByHeightTest() {
        SmoothSailing smoothSailing=new SmoothSailing();
        int[] input={4, 2, 9, 11, 2, 16};
        int[] output={2, 2, 4, 9, 11, 16};
        Assert.assertArrayEquals(output,smoothSailing.sortByHeight(input));
    }

    @Test
    public void reverseParenthesesTest() {
        SmoothSailing smoothSailing=new SmoothSailing();
        String input="The ((quick (brown) (fox) jumps over the lazy) dog)";
        String output="The god quick nworb xof jumps over the lazy";
        Assert.assertEquals(output,smoothSailing.reverseParentheses(input));

    }
}