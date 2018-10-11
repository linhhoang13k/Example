package codefights;

import java.util.stream.IntStream;

/**
 * @author danielbubenheim@gmail.com
 */
public class PagesNumbering {

    public static int pagesNumbering2(int n) {
        int s = 0;
        for (int i = 0; i < n; i++) {
            s += ("" + i).length();
            s += (int)(Math.log10(i)+1);;
        }
        return s;
    }

    public static int pagesNumbering(int n) {
        return IntStream.range(1, n + 1).map(e -> ("" + e).length()).sum();
    }


}
