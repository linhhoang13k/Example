import org.junit.Assert;
import org.junit.Test;

public class EvenDigitsOnlyTest {
    @Test
    public void testEven() {
        Assert.assertFalse(EvenDigitsOnly.evenDigitsOnly(1));
        Assert.assertFalse(EvenDigitsOnly.evenDigitsOnly(10));
        Assert.assertFalse(EvenDigitsOnly.evenDigitsOnly(103));
        Assert.assertFalse(EvenDigitsOnly.evenDigitsOnly(100));
        Assert.assertFalse(EvenDigitsOnly.evenDigitsOnly(1005675677));
        Assert.assertFalse(EvenDigitsOnly.evenDigitsOnly(34563456));
        Assert.assertTrue(EvenDigitsOnly.evenDigitsOnly(4622486));
    }
}
