package Testing;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by tranpham on 3/27/18.
 */
public class TestingTest {
    Testing testing = new Testing();
    @Test
    public void listPrimeNumber() throws Exception {

        int[] expected = {2,3,5,7,11,13};
        int n = 6;
        int[] actual = testing.listPrimeNumber(n);
        Assert.assertArrayEquals(expected,actual);
    }

}