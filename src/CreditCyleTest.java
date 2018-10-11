package codefights;

import static codefights.CreditCycle.creditCycle;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

import org.junit.Test;

import java.util.Date;

/**
 * @author daniel.bubenheim@gmail.com
 */
public class CreditCyleTest {

    @Test
    public void test1() {
        assertThat(creditCycle(2017, 8, 26, 20), is(equalTo(6L)));
    }

    @Test
    public void test2() {
        assertThat(creditCycle(2017, 8, 31, 26), is(equalTo(5L)));
    }

    @Test
    public void test3() {
        assertThat(creditCycle(2018, 5, 5, 20), is(equalTo(15L)));
    }

    @Test
    public void test4() {
        System.err.println(new Date(4, 2, 12).getDate());
        assertThat(creditCycle(2020, 12, 25, 25), is(equalTo(30L)));

    }
}