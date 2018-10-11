package Array_Strings;

/**
 * Created by Trung on 6/8/2017.
 *
 * Problem statement: Determine if strings are 1 edit or zero edits away to be equal.
 *
 * Example: pale, ple ==> True.
 *          pales, pale ==> True.
 *          pale, bake ==> False.
 *
 */
public class Chap1Q5_OneAway {

    /**
     * Solution discussed in book.
     *
     * @param a
     * @param b
     * @return
     */
    public static boolean isOneAway(String a, String b) {
        if (Math.abs(a.length() - b.length()) > 1) return false;

        String shorter = a.length() < b.length() ? a : b;
        String longer = a.length() < b .length() ? b : a;

        int indexShort = 0, indexLong = 0;
        boolean foundDiff = false;
        while (indexShort < shorter.length() && indexLong < longer.length()) {
            if (shorter.charAt(indexShort) != longer.charAt(indexLong)) {
                if (foundDiff) return false; //More than 1 edit away (different in more than 1 character)
                foundDiff = true;
                if (shorter.length() == longer.length())  {//Replace, move shorter index
                    indexShort++;
                }

            } else {
                indexShort++;
            }
            indexLong++;
        }
        return true;
    }

    public static void main(String...args) {
        isOneAway("pale", "pie");
    }
}
