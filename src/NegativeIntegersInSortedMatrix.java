package Own;

public class NegativeIntegersInSortedMatrix {

    //Count Negative Integers in Row/Column-Wise Sorted Matrix
    public static void main(String[] args) {
        int arr[][] = new int[][]{{-3, -2, -1, 1},
                {-2, 2, 3, 4},
                {4, 5, 7, 8}};

        int count = 0;
        int startColumn = arr[0].length-1;
        for (int row = 0; row < arr.length; row++) {
            for (int column = startColumn; column >= 0; column--) {
                if (arr[row][column] < 0) {
                    count += column + 1;
                    startColumn = column;
                    break;
                }
            }
        }

        System.out.println("The number of negative numbers are: " + count);


    }
}
