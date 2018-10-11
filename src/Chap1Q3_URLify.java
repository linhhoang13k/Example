package Array_Strings;

/**
 * Created by Trung on 6/6/2017.
 */

import java.util.Arrays;

/**
 * Problem statement: Replace all space in string with '%20'. Assume sufficient length at end to hold additional chars.
 * If use Java, use char array.
 *
 * Example: Input: "Mr John Doe  ", 11
 *          Output: "Mr%20John%20Doe"
 * Solution:
 *          Go over the input, whenever a space is found, shift the input array twice to the right starting from end.
 */
public class Chap1Q3_URLify {

    public static String urlify(char[] input, int length) {
        int index = 0;
        while (index < input.length) {
            if (input[index] == ' ') {
                length += shiftRight(input, index, length);
                length += shiftRight(input, index, length);
                input[index] = '%';
                input[index + 1] = '2';
                input[index + 2] = '0';
            }
                index++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i =0; i < input.length; i++) {
            sb.append(input[i]);
        }
        return sb.toString();

    }

    private static int shiftRight(char[] input, int index, int length) {
        for (int i = length - 1; i > index; i--) {
            input[i + 1] = input[i];
        }
        return 1;
    }

    public static void main(String...args) {
        char[] a = {'M', 'r', ' ', 'J', 'o', 'h', 'n', ' ', 'D', 'o', 'e'};
        char[] input = new char[15];
        for (int i = 0; i < 11; i++) {
            input[i] = a[i];
        }
        System.out.println(Arrays.toString(input));

        System.out.println(
                urlify(input, 11));
    }
}
