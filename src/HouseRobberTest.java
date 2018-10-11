package interviewpractice.dynamicprogrammingbasic;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author benmakusha
 */
public class HouseRobberTest {

    private HouseRobber houseRobber = new HouseRobber();

    private int[] inputArray = new int[] {1, 1, 1};
    private int[] inputArray2 = new int[0];
    private int[] inputArray3 = new int[] {0};
    private int[] inputArray4 = new int[] {105, 153, 133, 205, 157, 227, 74, 225, 238, 239, 195, 58, 166, 193, 150, 89, 208, 149};

    @Test
    public void testHouseRobberOne() {
        int result = houseRobber.houseRobber(inputArray);
        assertEquals(2, result);
    }

    @Test
    public void testHouseRobberTwo() {
        int result = houseRobber.houseRobber(inputArray2);
        assertEquals(0, result);
    }

    @Test
    public void testHouseRobberThree() {
        int result = houseRobber.houseRobber(inputArray3);
        assertEquals(0, result);
    }

    @Test
    public void testHouseRobberFour() {
        int result = houseRobber.houseRobber(inputArray4);
        assertEquals(1573, result);
    }
}