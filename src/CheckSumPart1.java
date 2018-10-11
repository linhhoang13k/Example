package in.mkp.challenges;

import java.util.Arrays;

/**
 * Created by mkumar on 3/12/17.
 */
public class CheckSumPart1 {

    public static void main(final String[] args) {
        CheckSumPart1 checkSumPart = new CheckSumPart1();
        System.out.println(checkSumPart.checksum_part1(29104150021L));
    }

    int checksum_part1(long barcode) {
        final String string = pad(barcode);
        int sum = 0;
        final Character[] digitChars = string.chars().mapToObj(c -> (char) c).toArray(Character[]::new);
        final int[] digits = Arrays.stream(digitChars).mapToInt(i -> i - '0').toArray();

        for (int i = 0; i < digits.length; ++i) {
            sum += digits[i] * (i % 2 == 0 ? 3 : 1);
        }

        return determineNearestPowerOf10(sum) - sum;
    }

    private int determineNearestPowerOf10(final int i) {
        return (i % 10) == 0 ? i : (10 - (i % 10)) + i;
    }

    private String pad(final long barcode) {
        return String.format("%011d", barcode);
    }
}
