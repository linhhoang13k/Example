package in.mkp.challenges;

import java.util.Arrays;
import java.util.HashSet;
import java.util.IntSummaryStatistics;
import java.util.Set;

/**
 * https://codefights.com/challenge/WEurBmxNGxnuXxuHt
 */
public class SuccessivePrimes {

    public static void main(String[] args) {
        SuccessivePrimes successivePrimes = new SuccessivePrimes();
        System.out.println("successivePrimes.successivePrimes() = "
                + successivePrimes.successivePrimes(new int[]{151, 139, 149, 173, 163, 127, 137, 113, 167, 157}));
        System.out.println("successivePrimes.successivePrimes() = "
                + successivePrimes.successivePrimes(new int[]{739, 743, 751, 757, 761, 769, 773, 787, 797, 809, 811, 821, 823, 827, 829, 839, 853, 857,
                859, 863, 877, 881, 883, 887, 907, 911, 919, 929, 937, 941, 947, 953, 967, 971, 977, 983, 991, 997, 1013}));
    }

    /**
     *  Using the strategy described here: https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes
     *
     *  Pseudocode:
     *
     Input: an integer n > 1.

     Let A be an array of Boolean values, indexed by integers 2 to n,
     initially all set to true.

     for i = 2, 3, 4, ..., not exceeding √n:
     if A[i] is true:
     for j = i2, i2+i, i2+2i, i2+3i, ..., not exceeding n:
     A[j] := false.

     Output: all i such that A[i] is true.

     The time complexity of this algorithm is O(n log log n)

     *
     *
     * @param primes
     * @return
     */

    int successivePrimes(int[] primes) {
        IntSummaryStatistics intSummaryStatistics = Arrays.stream(primes).parallel().summaryStatistics();
        Set<Integer> set = new HashSet<>();
        for (int i : primes) {
            set.add(i);
        }
        int max = intSummaryStatistics.getMax();
        int min = intSummaryStatistics.getMin();
        int sqrt = (int) Math.sqrt(max);

        boolean[] b = new boolean[max+1];
        for (int i = 2; i <= max; ++i) {
            b[i]=true;
        }
        for (int i=2; i <= sqrt; ++i) {
          if (b[i]) {
              int k=0;
              int p = (int)Math.pow(i, 2);
              for (int j = p; j < max; ++k, j=p + (k*i)) {
                  b[j]=false;
              }
          }
        }

        for (int i=min; i < max; ++i) {
            if (b[i] && !set.contains(i))
                return i;
        }
        return 0;
    }
}
