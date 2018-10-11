package Easy;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Trung on 10/14/2017.
 */
public class _461_HammingDistanceTest {
    @Test
    public void hammingDistance() throws Exception {
        assertEquals("Test failed.", 2, _461_HammingDistance.hammingDistance(1, 4));
        assertEquals("Test failed.", 4, _461_HammingDistance.hammingDistance(1994, 2017));
        assertEquals("Test failed.", 2, _461_HammingDistance.hammingDistance(1, 65536));
        assertEquals("Test failed.", 4, _461_HammingDistance.hammingDistance(10,123));
    }

}