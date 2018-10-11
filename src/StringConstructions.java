package arcade.mirroLake;

/**
 * Created by JavierSainz on 11/13/16.
 */
public class StringConstructions {
    int stringsConstruction(String A, String B) {
        char start = 'a';
        //'z' - 'a' + 1 = 26
        int[] chars = new int[26];
        for (int i = 0; i < B.length(); i++) {
            chars[B.charAt(i) - start]++;
        }
        int count = 0;
        while (true) {
            for (int i = 0; i < A.length(); i++) {
                int charIndex = A.charAt(i) - start;
                if (chars[charIndex] < 1) {
                    return count;
                }
                chars[charIndex]--;
            }
            count++;
        }
    }

    public static void main(String[] args) {
        System.out.println(new StringConstructions().stringsConstruction("abc", "abccba"));
    }
}
