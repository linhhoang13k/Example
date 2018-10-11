package interviewpractice.strings;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author benmakusha
 */

public class AmendTheSentenceTest {

    private AmendTheSentence amend = new AmendTheSentence();

    private String testString = "CodefightsIsAwesome";
    private String resultString = "codefights is awesome";

    @Test
    public void TestAmendTheSentenceOne() {
        String result = amend.amendTheSentence(testString);
        Assert.assertEquals(resultString, result);
    }
}