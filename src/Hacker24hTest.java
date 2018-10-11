package Testing;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by tranpham on 3/22/18.
 */
public class Hacker24hTest {
    Hacker24h hackerrank = new Hacker24h();
    @Test
    public void extractLink() throws Exception {
        String[] htmls = {"<p><a href=\"http://www.quackit.com/html/tutorial/html_links.cfm\">Example Link</a></p>",
                "<div class=\"more-info\"><a href=\"http://www.quackit.com/html/examples/html_links_examples.cfm\">More Link Examples...</a></div>"};

        String[] expected = {"http://www.quackit.com/html/tutorial/html_links.cfm,Example Link",
                "http://www.quackit.com/html/examples/html_links_examples.cfm,More Link Examples..."};

        String[] result = hackerrank.extractLink(htmls);
        Assert.assertArrayEquals(expected,result);
    }

}