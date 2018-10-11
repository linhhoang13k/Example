package in.mkp.basic.level11;

import java.util.Arrays;
import java.util.IntSummaryStatistics;

/**
 * Created by mkumar on 3/12/17.
 */
public class DeleteDigit {

    public static void main(final String[] args) {
        DeleteDigit deleteDigit = new DeleteDigit();
        System.out.println(deleteDigit.deleteDigit(231));
    }

    int deleteDigit(int n) {
        final String stringNumber = "" + n;

        final Character[] digitChars = stringNumber.chars().mapToObj(c -> (char)c).toArray(Character[]::new);
        final int[] digits = Arrays.stream(digitChars).mapToInt(i -> i - '0').toArray();
        final IntSummaryStatistics intSummaryStatistics = Arrays.stream(digits).summaryStatistics();
        int min = intSummaryStatistics.getMin();
        final int max = intSummaryStatistics.getMax();

        min = replaceMinIfMaxAndMinAreAdjacent(digits, min, max);

        int multiplier  = 1;
        int deleteNumber = 0;
        boolean deleted = false;
        for (int i = digits.length - 1; i >= 0; --i) {
            if ( !deleted && digits[i] == min) {
                deleted = true;
            }
            else {
                deleteNumber += multiplier * digits[i];
                multiplier *= 10;
            }
        }

        return deleteNumber;
    }

    /* The reason, we had to do this was because, say we have a number: 231 , we simply cannot take away
     * the smallest digit if the largest & smallest digits are adjacent, ie smallest on rightmost side and highest next
     * to it.
     */
    int replaceMinIfMaxAndMinAreAdjacent(final int[] digits, final int min, final int max) {
        int ret = min;

        int countMin = 0;
        int secondMin = max;
        for (int i=0; i < digits.length; ++i) {
            if (min == digits[i]) {
                countMin++;
            }
            if (digits[i] < secondMin  && digits[i] > min) {
                secondMin = digits[i];
            }
        }
        if (digits.length > 2 && countMin == 1 && digits[digits.length-1] == min && digits[digits.length-2] == max) {
            ret = secondMin;
        }

        return ret;
    }
}
