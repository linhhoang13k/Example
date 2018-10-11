package in.mkp.basic.level11;

/**
 * Created by mkumar on 3/12/17.
 */
public class LineEncoding {

    public static void main(final String[] args) {
        LineEncoding lineEncoding = new LineEncoding();
        System.out.println(lineEncoding.lineEncoding("aabbbc"));
    }

    String lineEncoding(String s) {
        final StringBuilder stringBuilder = new StringBuilder();
        final int len = s.length();
        char last = 0;
        int count = 0;

        for (int i = 0 ; i < len; ++i) {
            final char currentChar = s.charAt(i);
            if (currentChar == last) {
                count++;
            }
            else {
                // Start of string.
                if (last == 0) {
                    last = currentChar;
                }
                // The current char differs from the last one.
                else if (currentChar != last) {
                    last = encode(stringBuilder, last, count, currentChar);
                }
                count = 1;
            }
        }
        encode(stringBuilder, last, count, ' ');
        return stringBuilder.toString();
    }

    private char encode(final StringBuilder stringBuilder,
                        final char last,
                        final int count,
                        final char currentChar) {
        char ret;
        // Since there is only one char, no need to prefix count.
        if (count == 1) {
            stringBuilder.append(last);
            ret = currentChar;
        }
        // Prefix the count.
        else {
            stringBuilder.append(count).append(last);
            ret = currentChar;
        }
        return ret;
    }
}
