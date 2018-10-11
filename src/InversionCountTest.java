package interviewpractice.commonTechniquesAdvanced;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author benmakusha
 */
public class InversionCountTest {

    private InversionCount inversionCount = new InversionCount();

    private int[] inputArray = new int[] {3, 1, 5, 6, 4};

    @Test
    public void countInversions() {
        int result = inversionCount.countInversions(inputArray);
        assertEquals(3, result);
    }
}