package in.mkp.basic.level11;

/**
 * Created by mkumar on 3/12/17.
 */
public class ChessKnight {

    public static void main(final String[] args) {
        ChessKnight chessKnight = new ChessKnight();
        System.out.println(chessKnight.chessKnight("a1"));
    }

    int chessKnight(String cell) {
        int count = 0;
        final int row = cell.charAt(0) - 'a';
        final int col = cell.charAt(1) - '1';

        if (isValid(row - 2, col - 1)) count++;
        if (isValid(row - 1, col - 2)) count++;
        if (isValid(row + 1, col - 2)) count++;
        if (isValid(row + 2, col - 1)) count++;
        if (isValid(row + 2, col + 1)) count++;
        if (isValid(row + 1, col + 2)) count++;
        if (isValid(row - 2, col + 1)) count++;
        if (isValid(row - 1, col + 2)) count++;

        return count;
    }

    private boolean isValid(final int row, final int col) {
        return (row < 1 || row > 8 || col < 1 || col > 8) ? false : true;
    }
}
