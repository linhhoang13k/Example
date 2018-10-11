package codefights;

import java.util.stream.IntStream;

/**
 * @author daniel.bubenheim@gmail.com
 */
public class BuildSum {

    public static double buildSum(int n) {
        return n == 0 ? 1 : Math.pow(n, n) + buildSum(--n);
    }

    public static void main(String[] args) {
        IntStream.range(0,10).forEach(i -> System.out.printf("%d: %s\n", i, (int) buildSum(i)));
    }
}