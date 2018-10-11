package evg.codefights.core;

import java.util.*;

public class ChessTavern {

    public static void main(String[] args) {
        System.out.println(new ChessTavern().chessTriangle(2, 3));
        System.out.println(new ChessTavern().chessTriangle(1, 30));
        System.out.println(new ChessTavern().chessTriangle(3, 3));
    }

    boolean bishopAndPawn(String bishop, String pawn) {
        int x1 = bishop.charAt(0) - 'a';
        int y1 = bishop.charAt(1) - '1';
        int x2 = pawn.charAt(0) - 'a';
        int y2 = pawn.charAt(1) - '1';


        return Math.abs(x1 - x2) == Math.abs(y2 - y1);
    }

    int chessKnightMoves(String cell) {
        int col = cell.charAt(0) - 'a';
        int row = cell.charAt(1) - '1';
        int res = 0;
        return isValid(col - 1, row - 2) +
                isValid(col - 2, row - 1) +
                isValid(col + 1, row + 2) +
                isValid(col + 2, row + 1) +
                isValid(col + 1, row - 2) +
                isValid(col + 2, row - 1) +
                isValid(col - 1, row + 2) +
                isValid(col - 2, row + 1);
    }

    int isValid(int col, int row) {
        if (col >= 0 && col <= 7 && row >= 0 && row <= 7) {
            return 1;
        }
        return 0;
    }

    String[] bishopDiagonal(String bishop1, String bishop2) {
        int x1 = bishop1.charAt(0) - 'a';
        int y1 = bishop1.charAt(1) - '1';
        int x2 = bishop2.charAt(0) - 'a';
        int y2 = bishop2.charAt(1) - '1';
        String[] result = new String[2];
        if (x1 + y1 == x2 + y2) {
            while (x1 > 0 && y1 < 7) {
                x1--;
                y1++;
            }
            while (x2 < 7 && y2 > 0) {
                x2++;
                y2--;
            }
            result[0] = new String(new char[]{(char) (x1 + 'a'), (char) (y1 + '1')});
            result[1] = new String(new char[]{(char) (x2 + 'a'), (char) (y2 + '1')});
            return result;
        } else if (x1 - y1 == x2 - y2) {
            while (x1 * y1 > 0) {
                x1--;
                y1--;
            }
            while (x2 < 7 && y2 < 7) {
                x2++;
                y2++;
            }
            result[0] = new String(new char[]{(char) (x1 + 'a'), (char) (y1 + '1')});
            result[1] = new String(new char[]{(char) (x2 + 'a'), (char) (y2 + '1')});
            return result;
        } else {
            if (bishop1.charAt(0) < bishop2.charAt(0)) {
                return new String[]{bishop1, bishop2};
            } else if (bishop1.charAt(0) > bishop2.charAt(0)) {
                return new String[]{bishop2, bishop1};
            } else {
                return bishop1.charAt(1) <= bishop2.charAt(1) ? new String[]{bishop1, bishop2} : new String[]{bishop2, bishop1};
            }
        }
    }

    boolean whoseTurn(String p) {
        String[] arr = p.split(";");
        int wx1 = arr[0].charAt(0) - 'a';
        int wy1 = arr[0].charAt(1) - '1';
        int wx2 = arr[1].charAt(0) - 'a';
        int wy2 = arr[1].charAt(1) - '1';
        int bx1 = arr[2].charAt(0) - 'a';
        int by1 = arr[2].charAt(1) - '1';
        int bx2 = arr[3].charAt(0) - 'a';
        int by2 = arr[3].charAt(1) - '1';
        int w1 = getColor(wx1, wy1);
        int w2 = getColor(wx2, wy2);
        int b1 = getColor(bx1, by1);
        int b2 = getColor(bx2, by2);
        int sum = 0;
        if (w1 == 0) sum += 1;
        if (w2 == 1) sum += 1;
        if (b1 == 1) sum += 1;
        if (b2 == 0) sum += 1;
        return sum % 2 == 0;
    }

    int getColor(int r, int c) {
        return (r + c) % 2;
    }

    int[] chessBishopDream(int[] boardSize, int[] initPosition, int[] initDirection, int k) {
        int[] result = new int[2];
        int len = boardSize[0] * boardSize[1] * 2;
        k = k % (len);

        result[0] = initPosition[0];
        result[1] = initPosition[1];
        for (int i = 0; i < k; i++) {
            if (result[0] == 0 && initDirection[0] == -1) {
                initDirection[0] = 1;
            } else if (result[0] == boardSize[0] - 1 && initDirection[0] == 1) {
                initDirection[0] = -1;
            } else {
                result[0] = result[0] + initDirection[0];
            }

            if (result[1] == 0 && initDirection[1] == -1) {
                initDirection[1] = 1;
            } else if (result[1] == boardSize[1] - 1 && initDirection[1] == 1) {
                initDirection[1] = -1;
            } else {
                result[1] = result[1] + initDirection[1];
            }
        }
        return result;
    }

    int chessTriangle(int n, int m) {
        int result = 0;
        result += findChessTriangle(n, m, 2, 3, 8);
        result += findChessTriangle(n, m, 3, 2, 8);
        result += findChessTriangle(n, m, 3, 3, 8) * 2;
        result += findChessTriangle(n, m, 4, 2, 8);
        result += findChessTriangle(n, m, 2, 4, 8);
        result += findChessTriangle(n, m, 4, 3, 8);
        result += findChessTriangle(n, m, 3, 4, 8);
        return result;
    }

    int findChessTriangle(int h, int w, int sizew, int sizeh, int score) {
        int res = 0;
        for(int i = 0; i <= h - sizeh; i++) {
            for (int j = 0; j <= w - sizew; j++) {
                res += score;
            }
        }
        return res;
    }


}
