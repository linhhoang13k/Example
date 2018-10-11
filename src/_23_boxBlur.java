package Arcade_Intro;

public class _23_boxBlur {
    int[][] boxBlur(int[][] image) {
        int blurred[][] = new int[image.length - 2][image[0].length - 2];
        int tmp = 0;
        for (int y = 0; y < blurred.length; y++)
        {
            for (int x = 0; x < blurred[y].length; x++)
            {
                tmp = 0;
                tmp += image[y + 0][x + 0];
                tmp += image[y + 1][x + 0];
                tmp += image[y + 2][x + 0];
                tmp += image[y + 0][x + 1];
                tmp += image[y + 1][x + 1];
                tmp += image[y + 2][x + 1];
                tmp += image[y + 0][x + 2];
                tmp += image[y + 1][x + 2];
                tmp += image[y + 2][x + 2];
                blurred[y][x] = tmp / 9;
            }
        }
        return blurred;
    }
}
