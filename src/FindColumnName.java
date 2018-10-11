package challenge;

/**
 * Created by JavierSainz on 1/17/17.
 */
public class FindColumnName {
    String FindColumnName(int c) {
        String n = "";
        for(int m; c > 0; c = (c - m) / 26)
            n = (char)(65 + (m = (c - 1) % 26)) + n;
        return n;
    }

    public static void main(String[] args) {
        System.out.println(new FindColumnName().FindColumnName(100));
    }
}
