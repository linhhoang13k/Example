package arcade.islandofknowledge;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArrayMaximalAdjacentDifferenceTest {

    @Test
    public void AllElementsTheSame_DifferenceIsZero() {
        assertEquals(0, arrayMaximalAdjacentDifference(new int[] { 1, 1, 1, 1 }));
    }

    @Test
    public void AllPositiveElements() {
        assertEquals(3, arrayMaximalAdjacentDifference(new int[] { 2, 4, 1, 0}));
    }

    @Test
    public void MixOfPositiveAndNegativeElements() {
        assertEquals(7, arrayMaximalAdjacentDifference(new int[]
                {-1, 4, 10, 3, -2}));
    }

    private int arrayMaximalAdjacentDifference(int[] inputArray) {
        int maxDifference = -1;
        for (int i = 1; i < inputArray.length; i++) {
            int thisDifference = Math.abs(inputArray[i] - inputArray[i - 1]);
            maxDifference = Math.max(maxDifference, thisDifference);
        }
        return maxDifference;
    }
}
