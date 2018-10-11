package Arcade_Intro;

public class _24_minesweeper {
    int[][] minesweeper(boolean[][] matrix) {
        int[][] answer = new int[matrix.length][matrix[0].length];
        for(int rows = 0; rows < matrix.length; rows++)
        {
            for(int columns = 0; columns < matrix[0].length; columns++)
            {
                answer[rows][columns] = convertedFieldValue(matrix, rows, columns);
            }
        }
        return answer;
    }


    private int convertedFieldValue(boolean[][] matrix, int row, int column) {
        return
                boolToInt(matrix, row - 1, column - 1) +
                        boolToInt(matrix, row - 1, column) +
                        boolToInt(matrix, row - 1, column + 1) +
                        boolToInt(matrix, row, column - 1) +
                        boolToInt(matrix, row, column + 1) +
                        boolToInt(matrix, row + 1, column - 1) +
                        boolToInt(matrix, row + 1, column) +
                        boolToInt(matrix, row + 1, column + 1);
    }

    private int boolToInt(boolean[][] matrix, int row, int column) {
        try {
            if (!matrix[row][column]) return 0;
            else return 1;
        } catch (ArrayIndexOutOfBoundsException e) {
            return 0;
        } catch (Exception e) {
            System.out.println("Something went wrong.");
            return 0;
        }
    }
}
