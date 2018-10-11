package CodeFightsTasks;

/**
 * Created by Pasha on 23.01.2018.
 */
public class CFTask11 {
    boolean isLucky(int n) {
        int theFirstHalf = 0;
        int theSecondHalf = 0;
        String stringOfN = String.valueOf(n);
        for (int i = 0, j = stringOfN.length() - 1; i < stringOfN.length() / 2; i++, j--) {
            theFirstHalf += Integer.parseInt(String.valueOf(stringOfN.charAt(i)));
            theSecondHalf += Integer.parseInt(String.valueOf(stringOfN.charAt(j)));
        }
        return theFirstHalf == theSecondHalf;
    }
}
