import org.junit.Assert;
import org.junit.Test;

public class AlphabeticShiftTest {
    @Test
    public void test() {
        String res = AlphabeticShift.alphabeticShift("z");
        Assert.assertEquals("a", res);
        res = AlphabeticShift.alphabeticShift("zb");
        Assert.assertEquals("ac", res);
    }
}
