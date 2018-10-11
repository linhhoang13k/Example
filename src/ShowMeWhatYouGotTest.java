package codefights;

import static codefights.ShowMeWhatYouGot.showMeWhatYouGot;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

/**
 * @author daniel.bubenheim@gmail.com
 */
public class ShowMeWhatYouGotTest {

    @Test
    public void test1() {
        assertThat(showMeWhatYouGot("000000"), is(equalTo("I LIKE WHAT YOU GOT")));
    }

    @Test
    public void test2() {
        assertThat(showMeWhatYouGot("000001"), is(equalTo("I LIKE WHAT YOU G0T")));
    }

    @Test
    public void test3() {
        assertThat(showMeWhatYouGot("000011"), is(equalTo("I LIKE WHAT Y0U G0T")));
    }
    @Test
    public void test4() {
        assertThat(showMeWhatYouGot("000111"), is(equalTo("I LIKE WH4T Y0U G0T")));
    }

    @Test
    public void test5() {
        assertThat(showMeWhatYouGot("001111"), is(equalTo("I LIK3 WH4T Y0U G0T")));
    }

    @Test
    public void test6() {
        assertThat(showMeWhatYouGot("011111"), is(equalTo("I L1K3 WH4T Y0U G0T")));
    }

    @Test
    public void test7() {
        assertThat(showMeWhatYouGot("111111"), is(equalTo("1 L1K3 WH4T Y0U G0T")));
    }
}
