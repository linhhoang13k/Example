package com.codefights.arcade.intro;

/**
 * Created by zambro on 4/17/17.
 */
public class KnightMoves {

    public static int chessKnight(String cell) {
        int moves=0;
        if(cell.charAt(0) + 2 <= 'h' && cell.charAt(1) + 1 <= '8')
            moves++;
        if(cell.charAt(0) + 2 <= 'h' && cell.charAt(1) - 1 >= '1')
            moves++;
        if(cell.charAt(0) - 2 >= 'a' && cell.charAt(1) + 1 <= '8')
            moves++;
        if(cell.charAt(0) - 2 >= 'a' && cell.charAt(1) - 1 >= '1')
            moves++;


        if(cell.charAt(0) + 1 <= 'h' && cell.charAt(1) + 2 <= '8')
            moves++;
        if(cell.charAt(0) + 1 <= 'h' && cell.charAt(1) - 2 >= '1')
            moves++;
        if(cell.charAt(0) - 1 >= 'a' && cell.charAt(1) + 2 <= '8')
            moves++;
        if(cell.charAt(0) - 1 >= 'a' && cell.charAt(1) - 2 >= '1')
            moves++;

        return moves;
    }



    public static void main(String[] args) {
        System.out.println(chessKnight("c2"));
    }
}
