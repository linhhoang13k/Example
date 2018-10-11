/**
 * Created by Trung on 3/11/2017.
 */

package Easy;

/**
 * Problem statement:
 *      Given an integer, reverse it.
 *      The result is 0 if overflow occurs.
 *
 * Solution:
 *      Turn the integer to a string with concatenation.
 *      Reverse the string using StringBuilder.
 *      If there is sign, switch it to beginning of string.
 *      Try to parse and catch the exception. If there is one, overflow occurs.
 */
public class _7_ReverseIntegerMain {

    private static int reverse(int x) {
        String s = x+"";
        String reverse = reverse(s);
        if (reverse.charAt(reverse.length() - 1) == '-') {
            reverse = switchSign(reverse);
        }
        int ans = 0;
        try {
            ans = Integer.parseInt(reverse);
        } catch (NumberFormatException e) {
            return 0;
        }
        return ans;
    }

    private static String switchSign(String reverse) {
        StringBuilder sb = new StringBuilder();
        sb.append(reverse.charAt(reverse.length() - 1));
        for (int i = 0; i < reverse.length() - 1; i++) {
            sb.append(reverse.charAt(i));
        }
        return sb.toString();
    }

    private static String reverse(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    public static void main(String ... args) {
        int x = -123;

        System.out.println("Reverse Integer: " + reverse(x));
    }
}
