package interviewpractice.geometry;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author benmakusha
 */
public class LazyCutterTest {

    private LazyCutter lazyCutter = new LazyCutter();

    @Test
    public void testLazyCutterOne() {
        int result = lazyCutter.lazyCutter(1);
        assertEquals(2, result);
    }

    @Test
    public void testLazyCutterTwo() {
        int result = lazyCutter.lazyCutter(2);
        assertEquals(4, result);
    }

    @Test
    public void testLazyCutterThree() {
        int result = lazyCutter.lazyCutter(42);
        assertEquals(904, result);
    }

    @Test
    public void testLazyCutterFour() {
        int result = lazyCutter.lazyCutter(13);
        assertEquals(92, result);
    }
}