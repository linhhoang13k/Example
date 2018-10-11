package CodeFight;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by tranpham on 3/13/18.
 */
public class TackBotTest {
    @Test
    public void addDigits() throws Exception {
        bot.addDigits(12,11,2);
    }

    TackBot bot = new TackBot();
    @Test
    public void ratingThreshold() throws Exception {
    }

    @Test
    public void proCategorization() throws Exception {
        String[] pros =  {"Jack",
                "Leon",
                "Maria"};
        String[][] preferences = {{"Computer repair","Handyman","House cleaning"},
                                {"Computer lessons","Computer repair","Data recovery service"},
                                {"Computer lessons","House cleaning"}};

        String[][][] expected = {{{"Computer lessons"},{"Leon","Maria"}},
                                 {{"Computer repair"},{"Jack","Leon"}},
                                 {{"Data recovery service"},{"Leon"}},
                                 {{"Handyman"},{"Jack"}},
                                 {{"House cleaning"},{"Jack","Maria"}}};

        String[][][] actual=bot.proCategorization(pros,preferences);
        System.out.println(Arrays.deepToString(actual));

        Assert.assertArrayEquals(expected,actual);
    }
}