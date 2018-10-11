import org.junit.Test;

import static org.junit.Assert.assertFalse;

public class IsIPv4AddressTest {
    @Test
    public void test1() {
        assertFalse(IsIPv4Address.isIPv4Address("0.1.1.256"));
    }
}
