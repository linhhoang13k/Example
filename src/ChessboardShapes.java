package challenges;

import java.util.ArrayList;
import java.util.List;

public class ChessboardShapes {

    public static void main(String[] args) {
        String[] squares = new String[] { "g2", "h1" };
        System.out.println(ChessboardShapes(squares));
    }

    static int ChessboardShapes(String[] squares) {
        int[][] b = new int[8][8];
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[i].length; j++) {
                b[i][j] = (i + 1 * j + 1) % 2 == 0 ? 0 : 1;
                System.out.print(b[i][j] + " ");
            }
            System.out.println();
        }
        for (int k = 0; k < squares.length; k++) {
            char[] p = squares[k].toCharArray();
            b[p[0] - 97][56 - p[1]] = 0;
        }
        List<Integer> t = new ArrayList<Integer>();
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[i].length; j++) {
                if(b[i][j] == 0)
                    t.add(findCont(b, i, j));
            }
            System.out.println();
        }
        
        return 0;
    }

    private static int findCont(int[][] b, int i, int j) {
        int c = 0;
        for (int m = i; m < b.length; m++) {
            for (int n = j; n < b[m].length; n++) {
            }
        }
        return c;
    }
}
