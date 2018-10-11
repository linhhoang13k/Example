import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RotateImageTest {

    @Test
    public void rotateImageTest() {
        int[][] expectedOutput =
                {{7, 4, 1},
                        {8, 5, 2},
                        {9, 6, 3}};

        int[][] testInput =
                {{1, 2, 3},
                        {4, 5, 6},
                        {7, 8, 9}};

        int[][] rotatedImage = RotateImage.rotateImage(testInput);

        assertEquals(expectedOutput, rotatedImage);

    }
}
