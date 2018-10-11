package Arcade_Intro;

public class _50_chessKnight {
    int chessKnight(String cell) {
        int result = 0;

        Character field = cell.charAt(0);
        int number =  Character.getNumericValue(cell.charAt(1));

        if(field + 2 <= 'h' && number -1 >= 1) result++;
        if(field + 2 <= 'h' && number +1 <= 8) result++;
        if(field + 1 <= 'h' && number -2 >= 1) result++;
        if(field + 1 <= 'h' && number +2 <= 8) result++;

        if(field - 2 >= 'a' && number -1 >= 1) result++;
        if(field - 2 >= 'a' && number +1 <= 8) result++;
        if(field - 1 >= 'a' && number -2 >= 1) result++;
        if(field - 1 >= 'a' && number +2 <= 8) result++;

        return result;
    }
}
