package interviewpractice.strings;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author benmakusha
 */
public class TextJustificationTest {

    private TextJustification text = new TextJustification();

    private String[] inputArr = new String[] {"This", "is", "an", "example", "of",
            "text", "justification."};
    private String[] resultString = new String[] {"This    is    an", "example  of text",
            "justification.  "};

    @Test
    public void testTextJustificationOne() {
        String[] result = text.textJustification(inputArr, 16);
        assertArrayEquals(resultString, result);
    }
}