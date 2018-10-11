import org.junit.Assert;
import org.junit.Test;

public class DepositProfitTest {
    @Test
    public void test1() {
        Assert.assertEquals(3, DepositProfit.depositProfit(100, 20, 170));
    }
    @Test
    public void test2() {
        Assert.assertEquals(1, DepositProfit.depositProfit(100, 1, 101));
    }
}
