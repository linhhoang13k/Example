import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FindDuplicatesTest {

    @Test
    public void testOneDuplicate() {
        int expectedOutput = 3;

        int[] testInput = {2, 3, 3, 1, 5, 2};

        int actualFirstDuplicate = FindDuplicates.firstDuplicate(testInput);
        assertEquals(expectedOutput, actualFirstDuplicate);

    }

    @Test
    public void testNoDuplicate() {
        int expectedOutput = -1;

        int[] testInput = {2, 4, 3, 5, 1};

        int actualFirstDuplicate = FindDuplicates.firstDuplicate(testInput);
        assertEquals(expectedOutput, actualFirstDuplicate);

    }

    @Test
    public void testOneElementNoDuplicate() {
        int expectedOutput = -1;

        int[] testInput = {1};

        int actualFirstDuplicate = FindDuplicates.firstDuplicate(testInput);
        assertEquals(expectedOutput, actualFirstDuplicate);

    }

    @Test
    public void testOneDuplicateAbs() {
        int expectedOutput = 3;

        int[] testInput = {2, 3, 3, 1, 5, 2};

        int actualFirstDuplicate = FindDuplicates.firstDuplicateAbs(testInput);
        assertEquals(expectedOutput, actualFirstDuplicate);

    }

    @Test
    public void testNoDuplicateAbs() {
        int expectedOutput = -1;

        int[] testInput = {2, 4, 3, 5, 1};

        int actualFirstDuplicate = FindDuplicates.firstDuplicateAbs(testInput);
        assertEquals(expectedOutput, actualFirstDuplicate);

    }

    @Test
    public void testOneElementNoDuplicateABs() {
        int expectedOutput = -1;

        int[] testInput = {1};

        int actualFirstDuplicate = FindDuplicates.firstDuplicateAbs(testInput);
        assertEquals(expectedOutput, actualFirstDuplicate);

    }

    @Test
    public void testAnotherOneDuplicateAbs() {
        int expectedOutput = 6;

        int[] testInput = {8, 4, 6, 2, 6, 4, 7, 9, 5, 8};

        int actualFirstDuplicate = FindDuplicates.firstDuplicateAbs(testInput);
        assertEquals(expectedOutput, actualFirstDuplicate);

    }

    @Test
    public void testAnotherOneDuplicateHashSet() {
        int expectedOutput = 6;

        int[] testInput = {8, 4, 6, 2, 6, 4, 7, 9, 5, 8};

        int actualFirstDuplicate = FindDuplicates.firstDuplicateHashSet(testInput);
        assertEquals(expectedOutput, actualFirstDuplicate);

    }


    @Test
    public void testOneMoreDuplicateHashSet() {
        int expectedOutput = 1;

        int[] testInput = {1, 1, 2, 2, 1};

        int actualFirstDuplicate = FindDuplicates.firstDuplicateHashSet(testInput);
        assertEquals(expectedOutput, actualFirstDuplicate);

    }
}
