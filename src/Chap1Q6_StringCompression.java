package Array_Strings;

/**
 * Created by Trung on 6/10/2017.
 *
 * Problem statement: Given a string, compress it. Assume the string only has upper and lower case character a - z.
 *
 * Example: aabbccc ==> a2b2c3
 */
public class Chap1Q6_StringCompression {

    public static String compress(String s) {
        int index1 = 0;
        StringBuilder sb = new StringBuilder();
        while (index1 < s.length()) {
            char c = s.charAt(index1);
            int count = 1;
            sb.append(c);
            int index2 = index1 + 1;
            while (index2 < s.length() && s.charAt(index2) == c) {
                count++;
                index2++;
            }
            index1 = index2;
            sb.append(count);
        }
        return sb.length() < s.length() ? sb.toString() : s;
    }
}
