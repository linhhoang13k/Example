package interviewioquestions;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author benmakusha
 */

public class ExpandStringTest {

    private ExpandString expandString = new ExpandString();
    private String testStr = "a2[bc2[c]]d";

    @Test
    public void expanded() {
        String result = expandString.expanded(testStr);
        Assert.assertEquals("abcccbcccd", result);
    }
}