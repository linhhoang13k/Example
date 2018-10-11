package arcade.mirroLake;

import util.Chronometer;

import java.util.HashSet;

/**
 * Created by JavierSainz on 1/19/17.
 */
public class DifferentSquares {
    int differentSquares(int[][] matrix) {
        HashSet<Integer> different = new HashSet<>();
        for (int i = 0; i < matrix.length - 1; i++) {
            for (int j = 0; j < matrix[i].length - 1; j++) {
                different.add(cantorPair(cantorPair(matrix[i][j], matrix[i][j + 1]),
                        cantorPair(matrix[i + 1][j], matrix[i + 1][j + 1])));
            }
        }
        return different.size();
    }

    int cantorPair(int x, int y) {
        return ((x + y) * (x + y + 1)) / 2 + y;
    }

    int differentSquaresStrings(int[][] matrix) {
        HashSet<String> different = new HashSet<>();
        for (int i = 0; i < matrix.length - 1; i++) {
            for (int j = 0; j < matrix[i].length - 1; j++) {
                different.add("" + matrix[i][j] + matrix[i][j + 1] +
                        matrix[i + 1][j] + matrix[i + 1][j + 1]);
            }
        }
        return different.size();
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {2, 5, 3, 4, 3, 1, 3, 2},
                {4, 5, 4, 1, 2, 4, 1, 3},
                {1, 1, 2, 1, 4, 1, 1, 5},
                {1, 3, 4, 2, 3, 4, 2, 4},
                {1, 5, 5, 2, 1, 3, 1, 1},
                {1, 2, 3, 3, 5, 1, 2, 4},
                {3, 1, 4, 4, 4, 1, 5, 5},
                {5, 1, 3, 3, 1, 5, 3, 5},
                {5, 4, 4, 3, 5, 4, 4, 4}
        };
        DifferentSquares instance = new DifferentSquares();
        //warm-up
        instance.differentSquares(matrix);
        instance.differentSquaresStrings(matrix);
        //micro benchmark
        Chronometer c = Chronometer.start();
        instance.differentSquares(matrix);
        System.out.println(c.time());
        c.reset();
        instance.differentSquaresStrings(matrix);
        System.out.println(c.time());
    }
}
