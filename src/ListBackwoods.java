package evg.codefights.core;

public class ListBackwoods {

    int[] extractMatrixColumn(int[][] matrix, int column) {
        int[] result = new int[matrix.length];
        for(int i = 0; i < matrix.length; i++) {
            result[i] = matrix[i][column];
        }
        return result;
    }

    boolean areIsomorphic(int[][] array1, int[][] array2) {
        if (array1.length != array2.length) {
            return false;
        }
        for(int i = 0; i < array1.length; i++) {
            if (array1[i].length != array2[i].length) {
                return false;
            }
        }
        return true;
    }

    int[][] reverseOnDiagonals(int[][] matrix) {
        int len = matrix.length - 1;
        for(int i = 0; i < matrix.length / 2; i++) {
            int tmp = matrix[i][i];
            matrix[i][i] = matrix[len - i][len - i];
            matrix[len - i][len - i] = tmp;
            tmp = matrix[i][len - i];
            matrix[i][len - i] = matrix[len - i][i];
            matrix[len - i][i] = tmp;
        }
        return matrix;
    }

    int[][] swapDiagonals(int[][] matrix) {
        int len = matrix.length - 1;
        for(int i = 0; i < matrix.length / 2; i++) {
            int tmp = matrix[i][i];
            matrix[i][i] = matrix[i][len - i];
            matrix[i][len - i] = tmp;
            tmp = matrix[len - i][i];
            matrix[len - i][i] = matrix[len - i][len - i];
            matrix[len - i][len - i] = tmp;
        }
        return matrix;
    }

    int crossingSum(int[][] matrix, int a, int b) {
        int sum = 0;
        for(int i = 0; i < matrix[0].length; i++) {
            sum += matrix[a][i];
        }
        for(int i = 0; i < matrix.length; i++) {
            sum += matrix[i][b];
        }
        sum -= matrix[a][b];
        return sum;
    }

    char[][] drawRectangle(char[][] canvas, int[] rectangle) {
        int x1 = Math.min(rectangle[0], rectangle[2]);
        int x2 = Math.max(rectangle[0], rectangle[2]);
        int y1 = Math.min(rectangle[1], rectangle[3]);
        int y2 = Math.max(rectangle[1], rectangle[3]);
        canvas[y1][x1] = '*';
        canvas[y1][x2] = '*';
        canvas[y2][x1] = '*';
        canvas[y2][x2] = '*';
        for(int i = x1 + 1; i <= x2 - 1; i++) {
            canvas[y1][i] = '-';
            canvas[y2][i] = '-';
        }
        for(int i = y1 + 1; i <= y2 - 1; i++) {
            canvas[i][x1] = '|';
            canvas[i][x2] = '|';
        }
        return canvas;
    }

    String[][] volleyballPositions(String[][] formation, int k) {
        for(int i = 0; i < k % 6; i++){
            String tmp = formation[0][1];
            formation[0][1] = formation[1][2];
            formation[1][2] = formation[3][2];
            formation[3][2] = formation[2][1];
            formation[2][1] = formation[3][0];
            formation[3][0] = formation[1][0];
            formation[1][0] = tmp;
        }
        return formation;
    }

    int[][] starRotation(int[][] matrix, int width, int[] center, int t) {
        t %= 8;
        width /= 2;
        while (t > 0) {
            for (int i = 1; i <= width; i++) {
                int x = center[0];
                int y = center[1];
                int tmp = matrix[x - i][y - i];
                matrix[x - i][y - i] = matrix[x][y - i];
                matrix[x][y - i] = matrix[x + i][y - i];
                matrix[x + i][y - i] = matrix[x + i][y];
                matrix[x + i][y] = matrix[x + i][y + i];
                matrix[x + i][y + i] = matrix[x][y + i];
                matrix[x][y + i] = matrix[x - i][y + i];
                matrix[x - i][y + i] = matrix[x - i][y];
                matrix[x - i][y] = tmp;
            }
            t--;
        }
        return matrix;
    }





}
