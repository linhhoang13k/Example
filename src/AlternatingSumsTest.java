package arcade.exploringthewaters;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class AlternatingSumsTest {

    @Test
    void oneOfEach() {
        int[] input = new int[] {100, 50};
        int[] expected = new int[] {100, 50};
        assertArrayEquals(expected, alternatingSums(input));
    }

    @Test
    void onlyOneElement_SecondSumIsZero() {
        int[] input = new int[] { 80 };
        int[] expected = new int[] {80, 0};
        assertArrayEquals(expected, alternatingSums(input));
    }

    @Test
    void multipleElements() {
        int[] input = new int[] {50, 60, 60, 45, 70};
        int[] expected = new int[] {180, 105};
        assertArrayEquals(expected, alternatingSums(input));
    }


    private int[] alternatingSums(int[] input) {
        int sum1 = 0;
        int sum2 = 0;

        for (int i = 0; i < input.length; i++) {
            if (i % 2 == 0) {
                sum1 += input[i];
            } else {
                sum2 += input[i];
            }
        }

        int[] result = new int[2];
        result[0] = sum1;
        result[1] = sum2;
        return result;
    }
}
