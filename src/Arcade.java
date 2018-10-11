public class Arcade {


    public static void main(String[] args) {
        System.out.println("Answer is: "+ matrixElementsSum());
    }


    static int matrixElementsSum() {
        int sum = 0;
        int[][] matrix2 = {{1,1,1},
                {2,2,2},
                {3,3,3}};
        int[][] matrix = {{0, 1, 1, 2},
                {0, 5, 0, 0},
                {2, 0, 3, 3}};

        for (int j = 0; j < matrix[j].length ; j++) {
            for (int i = 0; i < matrix.length ; i++)
                if(matrix[i][j] == 0) {
                    break;
                }
            else
                sum = sum + matrix[i][j];


        }
        return sum;
    }

}