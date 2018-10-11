package arcade.mirroLake;

import util.Chronometer;

/**
 * Created by JavierSainz on 1/20/17.
 */
public class MostFrequentDigitSum {

    int maxDigits = 5;
    int length =  maxDigits * 9 + 1; //plus 1 to discard 0 position
    int mostFrequentDigitSum(int n) {
        int[] sums = new int[length];
        while (n > 0) {
            int sum = sumDigits(n);
            sums[sum]++;
            n -= sum;
        }
        int mostFrequentSum = 0;
        int frequency = 0;
        for (int i = 1; i < length; i++) {
            if (frequency <= sums[i]) {
                mostFrequentSum = i;
                frequency = sums[i];
            }
        }
        return mostFrequentSum;
    }

    public int sumDigits( int n ) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        MostFrequentDigitSum instance = new MostFrequentDigitSum();
        instance.mostFrequentDigitSum(99999);
        instance.mostFrequentDigitSum(99999);
        //micro benchmark
        Chronometer c = Chronometer.start();
        instance.mostFrequentDigitSum(88);
        System.out.println(c.time());
    }
}
