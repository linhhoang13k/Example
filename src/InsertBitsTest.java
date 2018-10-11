package interviewpractice.bits;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author benmakusha
 */
public class InsertBitsTest {

    private InsertBits insert = new InsertBits();

    @Test
    public void testInsertBitsOne() {
        int result = insert.insertBits(1024, 1, 6, 17);
        assertEquals(1058, result);
    }

    @Test
    public void testInsertBitsTwo() {
        int result = insert.insertBits(11, 1, 2, 2);
        assertEquals(13, result);
    }

    @Test
    public void testInsertBitsThree() {
        int result = insert.insertBits(1, 3, 4, 3);
        assertEquals(25, result);
    }

    @Test
    public void testInsertBitsFour() {
        int result = insert.insertBits(2147483647, 0, 30, 0);
        assertEquals(0, result);
    }
}