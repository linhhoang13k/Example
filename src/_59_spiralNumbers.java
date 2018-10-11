package Arcade_Intro;

public class _59_spiralNumbers {
    int[][]spiralNumbers(int n){
        int[][] array = new int[n][n];

        int left = 0, right = n-1, top = 0, down = n-1;
        for(int counter = 1; counter <= n*n;){
            for(int x = left; x <= right; x++)
                array[top][x] = counter++;
            top++;

            for(int y = top; y <= right; y++)
                array[y][right] = counter++;
            right--;

            for(int x = right; x >= left; x--)
                array[down][x] = counter++;
            down--;

            for(int y = down; y >= top; y--)
                array[y][left] = counter++;
            left++;
        }
        return array;
    }
}
