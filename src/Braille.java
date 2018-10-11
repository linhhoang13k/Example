package challenge;

import java.util.Arrays;

/**
 * Created by JavierSainz on 12/16/16.
 */
public class Braille {

    String brAIlle(String[] message) {
        String[] s = message;
        int l = s.length, m;
        String r = "", d = "[?]", c, e = r;
        char p = ' ';
        boolean b = false, w, y = b;
        String[] a = new String[]{"1", "12", "14", "145", "15", "124", "1245", "125", "24", "245", "13", "123",
                "134", "1345", "135", "1234", "12345", "1235", "234", "2345", "136", "1236", "2456", "1346", "13456",
                "1356", "3456"};
        if (l < 3)
            return d;
        int i = 3;
        //concat in the first 3 lines
        for (; i < l; i++)
            s[i % 3] += s[i];
        m = Math.max(Math.max(s[0].length(), s[1].length()), s[2].length());
        //same size in the 3 first lines
        for (i = 0; i < 3; s[i] = l > 0 ? s[i] + String.format("%" + l + "s", "") : s[i], i++)
            l = m - s[i].length();

        char[] t = (s[0] + s[1] + s[2]).toCharArray();
        for (i = 0; i + 2 < m;) {
            c = e + (t[i] > p ? 1 : e) + (t[m + i] > p ? 2 : e) + (t[2 * m + i] > p ? 3 : e)
                    + (t[i + 2] > p ? 4 : e) + (t[m + i + 2] > p ? 5 : e) + (t[2 * m + i + 2] > p ? 6 : e);
            w = e(t, ++i, m);
            if (c.equals(a[26])) {
                b = true;
                continue;
            }
            if ((i += 2) < 3 * m)
                y = e(t, i , m);
            l = Arrays.asList(a).indexOf(c);
            r += l < 0 | w  | y? d : (char) ((b ? '1' : 'a') + l);
            b = false;
        }
        return r;
    }

    boolean e(char[] a, int i, int m) {
        return a[i] + a[m + i] + a[2 * m + i] != 3 * ' ';
    }

    public static void main(String[] args) {
        System.out.println(new Braille().brAIlle(new String[]{
                "# # #   # # # #  #  #   #   #   # #   #",
                "          #   #  # #              # #  ",
                "#       #   # #  #  # # # # #   #   #  "
        }));
    }

}
