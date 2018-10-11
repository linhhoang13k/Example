package codefights;

/**
 * @author daniel.bubenheim@gmail.com
 */
public class ShowMeWhatYouGot {

    static String showMeWhatYouGot(String s) {
        int[] n = { 0, 3, 5, 9, 13, 17 };
        char[] b = "I LIKE WHAT YOU GOT".toCharArray();
        for (int i = 0; i < 6; i++) {
            if (s.charAt(i) == 49)
                b[n[i]] = "113400".charAt(i);
        }
        return new String(b);
    }
}