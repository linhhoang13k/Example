package codefights;

/**
 * count the amount of segments in a seven-segment display
 *
 * @author daniel.bubenheim@gmail.com
 */
public class LineSum {

    static int[] b = {6, 2, 5, 5, 4, 5, 6, 3, 7, 6};
    static long lineSum(long n) {
        return n > 10 ? b[(int) (n % 10)] + lineSum(n / 10) : b[(int) n];
    }

    public static void main(String... args) {
        System.err.println(lineSum(1000000000000000l));
    }
}
