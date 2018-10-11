package InterviewPractice;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Trung on 5/19/2017.
 */
public class robHousesTest {
    @Test
    public void testSameAmount() throws Exception {
        assertEquals(2, robHouses.houseRobber(new int[] {1, 1, 1}));

    }

    @Test
    public void testEmpty() throws Exception {
        assertEquals(0, robHouses.houseRobber(new int[] {}));

    }


    @Test
    public void testOneEle() throws Exception {
        assertEquals(1, robHouses.houseRobber(new int[] {1}));

    }

    @Test
    public void testTwoEle() throws Exception {
        assertEquals(2, robHouses.houseRobber(new int[] {2, 1}));

    }

    @Test
    public void testSmallSample() throws Exception {
        assertEquals(26, robHouses.houseRobber(new int[] {2, 1, 2, 6, 1, 8, 10, 10}));

    }


    @Test
    public void testBigSample() throws Exception {
        assertEquals(4517, robHouses.houseRobber(new int[] {155, 44, 52, 58, 250, 225, 109, 118, 211, 73, 137, 96,
                137, 89, 174, 66, 134, 26, 25, 205, 239, 85, 146, 73, 55, 6, 122, 196, 128, 50, 61, 230, 94, 208, 46,
                243, 105, 81, 157, 89, 205, 78, 249, 203, 238, 239, 217, 212, 241, 242, 157, 79, 133, 66, 36, 165}));

    }
}