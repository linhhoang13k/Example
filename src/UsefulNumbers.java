package in.mkp.challenges;

/**
 * https://codefights.com/challenge/WzAnYbosFHf7DaFuz
 */
public class UsefulNumbers {

    public static void main(String[] args) {
        UsefulNumbers usefulNumbers = new UsefulNumbers();
        System.out.println("usefulNumbers.usefulNumbers(11) = " + usefulNumbers.usefulNumbers(11));
        System.out.println("usefulNumbers.usefulNumbers(20) = " + usefulNumbers.usefulNumbers(20));
    }

    /**
     * This is the brute-force approach.
     * @param k
     * @return
     */
    int usefulNumbers2(int k) {
        int s=0;
        for (int i=0; i < k; ++i) {
            if ((i + k) == (i | k))  {
                s++;
            }
        }
        return s;
    }

    /**
     * This method worked for k = 2^31 .
     * The logic is to count number of zeros (non-trailing ones).
     * Let this value by n. Return 2^n
     *
     * @param k
     * @return
     */
    int usefulNumbers(int k) {
        int i = Integer.highestOneBit(k);
        int s=0;
        while (i > 0) {
            i >>= 1; s++;
        }
        return 1<<(s-Integer.bitCount(k));
    }
}
