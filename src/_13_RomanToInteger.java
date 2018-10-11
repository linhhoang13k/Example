/**
 * Created by Trung on 3/29/2017.
 */
package Easy;
/***
 * Problem statement:
 *      Given a roman number, convert it to an integer.
 *      Input is guaranteed to be from 1 to 3999.
 */
public class _13_RomanToInteger {
    private static int getInt(char c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }

    private static int romanToInt(char a, char b) {
        if (a == b) return -1;
        switch (a) {
            case 'I':
                if (b == 'V' || b == 'X') {
                    return getInt(b) - 1;
                }
            case 'X':
                if (b == 'L' || b == 'C') {
                    return getInt(b) - 10;
                }
            case 'C':
                if (b == 'D' || b == 'M') {
                    return getInt(b) - 100;
                }
            default:
                return 0;
        }
    }

    private static int romanToInt(String s) {
        int ans = 0;
        int i = 0;
        while (true) {
            char c = s.charAt(i);
            c = Character.toUpperCase(c);
            if ((c == 'I' || c == 'X' || c == 'C') && i + 1 < s.length()) {
                int n = romanToInt(c, Character.toUpperCase(s.charAt(i + 1)));
                if (n > 0) {
                    i += 2;
                 } else  {
                        ans += getInt(c);
                        i++;
                    }

            } else {
                ans += getInt(c);
                i++;
            }
            if (i >= s.length()) {
                return ans;
            }
        }
    }

    public static void main(String... args) {
        System.out.println(romanToInt("dcxxi"));
    }
}
