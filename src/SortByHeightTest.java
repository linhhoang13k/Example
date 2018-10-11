import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Random;

public class SortByHeightTest {

    private static int[] array;
    @BeforeClass
    public static void setup() {
        array = new int[100000000];
        Random random = new Random();
        for (int i = 0; i < array.length; i++)
            array[i] = random.nextInt(5000) -1;
    }

    @Test
    public void testV1() {
        int[] sorted = SortByHeight.sortByHeightV1(array);
    }

    @Test
    public void testV2() {
        int[] sorted = SortByHeight.sortByHeightV2(array);
    }

//    @Test
//    public void testV3() {
//        int[] sorted = SortByHeight.sortByHeightV3(array);
//    }
}
