package evg.codefights.core;

import java.util.*;
import java.util.stream.Stream;

public class WaterfallOfIntegration {

    //for tests
    public static void main(String[] args) {
        WaterfallOfIntegration w = new WaterfallOfIntegration();
        System.out.println("true == " + w.correctNonogram(5, new String[][]{
                {"-", "-", "-", "-", "-", "-", "-", "-"},
                {"-", "-", "-", "2", "2", "1", "-", "1"},
                {"-", "-", "-", "2", "1", "1", "3", "3"},
                {"-", "3", "1", "#", "#", "#", ".", "#"},
                {"-", "-", "2", "#", "#", ".", ".", "."},
                {"-", "-", "2", ".", ".", ".", "#", "#"},
                {"-", "1", "2", "#", ".", ".", "#", "#"},
                {"-", "-", "5", "#", "#", "#", "#", "#"}
        }));
        System.out.println("false == " + w.correctNonogram(5, new String[][]{
                {"-", "-", "-", "-", "-", "-", "-", "-"},
                {"-", "-", "-", "-", "-", "1", "-", "-"},
                {"-", "-", "-", "3", "3", "2", "5", "5"},
                {"-", "-", "3", ".", ".", ".", "#", "#"},
                {"-", "2", "2", "#", "#", "#", "#", "#"},
                {"-", "-", "5", "#", "#", "#", "#", "#"},
                {"-", "-", "5", "#", "#", "#", "#", "#"},
                {"-", "-", "2", ".", ".", ".", "#", "#"}
        }));

//        int row = 50; int col = 100;
//        System.out.println("row=" + row + " col=" + col);
//        for(int i = 0; i < 296; i++) {
//            System.out.println(w.getIndexRow(row, col, i) + ", " + w.getIndexCol(row, col, i) + " = " + i);
//        }
//
//        Arrays.stream(new WaterfallOfIntegration().contoursShifting(new int[][]{
//                {1, 2, 3, 4},
//                {5, 6, 7, 8},
//                {9, 10, 11, 12},
//                {13, 14, 15, 16},
//                {17, 18, 19, 20}
//        })).forEach(i -> System.out.println(Arrays.toString(i)));

//        Arrays.stream(new WaterfallOfIntegration().contoursShifting(new int[][]{
//                {238, 239, 240, 241, 242, 243, 244, 245}
//        })).forEach(i -> System.out.println(Arrays.toString(i)));
//        Arrays.stream(new WaterfallOfIntegration().contoursShifting(new int[][]{
//                {238},
//                {239},
//                {240},
//                {241},
//                {242},
//                {243},
//                {244},
//                {245}
//        })).forEach(i -> System.out.println(Arrays.toString(i)));

    }

    boolean sudoku(int[][] grid) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int sum = 0;
                for (int x = i * 3; x < i * 3 + 3; x++) {
                    for (int y = j * 3; y < j * 3 + 3; y++) {
                        sum ^= grid[x][y];
                    }
                }
                if (sum != 1) {
                    return false;
                }
            }
        }
        int[] rows = new int[9];
        int[] cols = new int[9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                rows[i] ^= grid[j][i];
                cols[i] ^= grid[i][j];
            }
        }
        for (int i = 0; i < 9; i++) {
            if (rows[i] != 1 || cols[i] != 1) {
                return false;
            }
        }
        return true;
    }

    int[][] minesweeper(boolean[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new int[0][0];
        }
        int n = matrix.length;
        int m = matrix[0].length;

        int[][] res = new int[n][m];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j]) {
                    int top = Math.max(0, i - 1);
                    int bottom = Math.min(n - 1, i + 1);
                    int left = Math.max(0, j - 1);
                    int right = Math.min(m - 1, j + 1);
                    for (int r = top; r <= bottom; r++) {
                        for (int c = left; c <= right; c++) {
                            if (r == i && c == j) {
                                continue;
                            }
                            res[r][c]++;
                        }
                    }
                }

            }
        }
        return res;
    }

    int[][] boxBlur(int[][] image) {
        int resRow = image.length - 2;
        int resCol = image[0].length - 2;
        int[][] res = new int[resRow][resCol];
        for (int i = 0; i < resRow; i++) {
            for (int j = 0; j < resCol; j++) {
                int sum = 0;
                for (int r = i; r < i + 3; r++) {
                    for (int c = j; c < j + 3; c++) {
                        sum += image[r][c];
                    }
                }
                res[i][j] = sum / 9;
            }
        }
        return res;
    }

    int[][] contoursShifting(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        System.out.println(row + " " + col);
        for (int i = 0; i < (row + 1) / 2 && i < (col + 1) / 2; i++) {
            int c = col - i * 2;
            int r = row - i * 2;
            int total;
            if (c == 1 || r == 1) {
                total = Math.max(c, r) - 1;
            } else {
                total = (r - 1) * 2 + (c - 1) * 2 - 1;
            }
            System.out.println(total);
            if (i % 2 == 0) { // clockwise
                int tmp = matrix[getIndexRow(r, c, total) + i][getIndexCol(r, c, total) + i];
                for (int j = total; j > 0; j--) {
                    matrix[getIndexRow(r, c, j) + i][getIndexCol(r, c, j) + i] = matrix[getIndexRow(r, c, j - 1) + i][getIndexCol(r, c, j - 1) + i];
                }
                matrix[getIndexRow(r, c, 0) + i][getIndexCol(r, c, 0) + i] = tmp;
            } else {
                int tmp = matrix[getIndexRow(r, c, 0) + i][getIndexCol(r, c, 0) + i];
                for (int j = 0; j < total; j++) {
                    matrix[getIndexRow(r, c, j) + i][getIndexCol(r, c, j) + i] = matrix[getIndexRow(r, c, j + 1) + i][getIndexCol(r, c, j + 1) + i];
                }
                matrix[getIndexRow(r, c, total) + i][getIndexCol(r, c, total) + i] = tmp;
            }
        }
        return matrix;
    }

    int getIndexRow(int row, int col, int num) {
        if (num - col < 0) { //top
            return 0;
        } else if (num - col - row + 1 < 0) { //right col
            return num - col + 1;
        } else if (num - col * 2 - row + 2 < 0) { //bottom
            return row - 1;
        } else {
            return (row - 2) - (num - col - (row - 1) - (col - 1));
        }
    }

    int getIndexCol(int row, int col, int num) {
        if (num - col < 0) { //top
            return num;
        } else if (num - col - row + 1 < 0) { //right col
            return col - 1;
        } else if (num - col * 2 - row + 2 < 0) { //bottom
            return col - 2 - (num - col - row + 1);
        } else {
            return 0;
        }
    }

    int polygonPerimeter(boolean[][] matrix) {
        int res = 0;
        int row = matrix.length;
        int col = matrix[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (!matrix[i][j]) {
                    continue;
                }
                if (i == 0 || i > 0 && !matrix[i - 1][j]) {
                    res++;
                }
                if (i == row - 1 || i < row - 1 && !matrix[i + 1][j]) {
                    res++;
                }
                if (j == col - 1 || j < col - 1 && !matrix[i][j + 1]) {
                    res++;
                }
                if (j == 0 || j > 0 && !matrix[i][j - 1]) {
                    res++;
                }
            }
        }
        return res;
    }

    int[] gravitation(String[] rows) {
        List<Integer> list = new ArrayList<>();
        int len = rows.length;
        int count = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < rows[0].length(); i++) {
            int n = 0;
            int c = 0;
            for (int j = len - 1; j >= 0; j--) {
                if (rows[j].charAt(i) == '.') {
                    c++;
                } else {
                    n += c;
                    c = 0;
                }
            }
            if (min > n) {
                min = n;
                count = 1;
            } else if (min == n) {
                count++;
            }
            list.add(n);
        }
        int[] res = new int[count];
        int r = 0;
        for (int i = 0; i < list.size(); i++) {
            if (min == list.get(i)) {
                res[r++] = i;
            }
        }
        return res;
    }

    boolean isInformationConsistent(int[][] evidences) {
        for (int i = 0; i < evidences[0].length; i++) {
            int last = 0;
            for (int j = 0; j < evidences.length; j++) {
                if (evidences[j][i] != 0 && last != 0 && evidences[j][i] != last) {
                    return false;
                }
                if (last == 0) {
                    last = evidences[j][i];
                }
            }
        }
        return true;
    }

    boolean correctNonogram(int size, String[][] nonogramField) {
        int row = nonogramField.length - size;
        int col = nonogramField[0].length - size;
        StringBuilder[][] rows = new StringBuilder[size][2];
        StringBuilder[][] cols = new StringBuilder[size][2];
        for (int i = 0; i < nonogramField.length; i++) {
            for (int j = 0; j < nonogramField[0].length; j++) {
                if (i < row && j < col) {
                    continue;
                }
                int rowIndex = i - row;
                int colIndex = j - col;
                if (rowIndex >= 0 && rows[rowIndex][0] == null) {
                    rows[rowIndex][0] = new StringBuilder();
                    rows[rowIndex][1] = new StringBuilder();
                }
                if (colIndex >= 0 && cols[colIndex][0] == null) {
                    cols[colIndex][0] = new StringBuilder();
                    cols[colIndex][1] = new StringBuilder();
                }
                String s = nonogramField[i][j];
                StringBuilder pattern;
                if (i >= row && j >= col) {
                    cols[colIndex][1].append(s);
                    rows[rowIndex][1].append(s);
                    continue;
                }
                if (i < row) {
                    pattern = cols[colIndex][0];
                } else {
                    pattern = rows[rowIndex][0];
                }
                if ("-".equals(s)) {
                    pattern.append("(\\.*)");
                } else {
                    int black = Integer.parseInt(s);
                    pattern.append("(\\#{").append(black).append("})").append("(\\.*)");
                }
            }
        }
        return Stream.concat(Stream.of(rows), Stream.of(cols)).allMatch(sbt -> sbt[1].toString().matches(sbt[0].toString()));
    }

}
