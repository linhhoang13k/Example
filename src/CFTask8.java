package CodeFightsTasks;

/**
 * Created by Pasha on 22.01.2018.
 */
public class CFTask8 {
    int matrixElementsSum(int[][] matrix) {
        int totalPriceOfAllTheRooms = 0;
        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[j][i] != 0)
                    totalPriceOfAllTheRooms += matrix[j][i];
                else
                    break;
            }
        }
        return totalPriceOfAllTheRooms;
    }

}
