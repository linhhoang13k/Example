package codefights;

/**
 * @author daniel.bubenheim@gmail.com
 */
public class TextIt {

    public static String texting(String s) {
        StringBuilder b = new StringBuilder();
        int x = 0, sum = 1;
        for (int c : s.chars().toArray()) {
            if (c == x) {
                int o = b.length(), l = (""+ sum).length();
                String u = b.substring(o - 2);
                int d = o - u.length();
                if (sum != 1) d -= l;
                b.delete(d, o).append(++sum + u);
                continue;
            } else {
                sum = 1;
            }
            int factor = ((c - 76) / 3 - 7), r = c - 76 - factor + factor * 8;
            if (r > 73) {
                r--;
            }
            if (r == 80) r = 74;
            if (r % 10 == 0 || r > 100) r -= 7;
            if (r == -191 && x != -191) {
                b.append("01");
            }
            else {
                b.append(r);
            }
            x = c;
        }
        return b.toString();
    }





}