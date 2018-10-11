import java.util.Scanner;

public class DiagonalDifference {

    public static int getDiagonalDifference() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a[][] = new int[n][n];
        for(int a_i = 0; a_i < n; a_i++){
            for(int a_j = 0; a_j < n; a_j++){
                a[a_i][a_j] = in.nextInt();
            }
        }

        int sum1 = 0, sum2 = 0;
        for(int i = 0; i < a.length; i++){
            sum1 += a[i][i];
            sum2 += a[i][a.length - i - 1];
        }

        return Math.abs(sum1 - sum2);
    }
}
