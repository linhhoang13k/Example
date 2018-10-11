package interviewpractice.commonTechniquesAdvanced;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author benmakusha
 */
public class BomberTest {

    private Bomber bomber = new Bomber();

    private char[][] inputArray = new char[][] {
            {'0','0','E','0'},
            {'W','0','W','E'},
            {'0','E','0','W'},
            {'0','W','0','E'}
    };

    @Test
    public void testBomberOne() {
        int result = bomber.bomber(inputArray);
        assertEquals(2, result);
    }
}