package interviewpractice.counting;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * @author benmakusha
 */
public class pressingButtonsTest {

    private PressingButtons pressingButtons = new PressingButtons();

    private String inputStr = "42";
    private String[] results = new String[] {"ga", "gb", "gc", "ha", "hb", "hc", "ia", "ib", "ic"};

    @Test
    public void pressingButtons() {
        String[] result = pressingButtons.pressingButtons(inputStr);
        assertArrayEquals(results, result);
    }
}