import java.util.*;

public class StringComparer {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String y = in.next();
        int x = in.nextInt();


        ArrayList<String> subs = new ArrayList<String>();
        StringBuilder d = new StringBuilder("");

        for (int i = 0; i < x; i++) {
            d.append(y.charAt(i));
        }

        subs.add(new String(d));

        for (; x < y.length(); x++) {
            d.delete(0, 1);
            d.append(y.charAt(x));
            subs.add(new String(d));
        }

        Collections.sort(subs);

        System.out.println(subs.get(0));
        System.out.println(subs.get(subs.size() - 1));
        in.close();

    }
}
