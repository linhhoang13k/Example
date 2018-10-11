package codefights;

import static codefights.TextIt.texting;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

/**
 * @author daniel.bubenheim@gmail.com
 */
public class TextItTest {

    @Test
    public void test1() {
        assertThat(texting("a"), is(equalTo("21")));
    }

    @Test
    public void test2() {
        assertThat(texting("aa"), is(equalTo("221")));
    }

    @Test
    public void test3() {
        assertThat(texting("ab"), is(equalTo("2122")));
    }

    @Test
    public void test4() {
        assertThat(texting("hello world"), is(equalTo("423225363019163735331")));
    }

    @Test
    public void test5() {
        assertThat(texting("hacker"), is(equalTo("422123523273")));
    }

    @Test
    public void test6() {
        assertThat(texting("code fights"), is(equalTo("2363313201334341428174")));
    }

    @Test
    public void test7() {
        assertThat(texting("gbwbb  nzthycq   qpmhbrbc ncvvr"), is(equalTo("41229122220162948142932372301727161422273222301622328373")));
    }

    @Test
    public void test8() {
        assertThat(texting("bkgrnd"), is(equalTo("225241736231")));
    }

    @Test
    public void test9() {
        assertThat(texting("vlcn"), is(equalTo("83532362")));
    }

    @Test
    public void test10() {
        assertThat(texting("a   b"), is(equalTo("2130122")));
    }

    @Test
    public void test11() {
        assertThat(texting("aaaaaaaaaaaaaa"), is(equalTo("1421")));
    }
}