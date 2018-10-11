package arcade.mirroLake;

/**
 * Created by JavierSainz on 11/14/16.
 */
public class CreateAnagram {
    int createAnagram(String s, String t) {
        char startPoint = 'A';
        int[] counters = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counters[s.charAt(i) - startPoint]++;
            counters[t.charAt(i) - startPoint]--;
        }
        int replacementOperations = 0;
        for(int count : counters) {
            if (count > 0) {
                replacementOperations += count;
            }
        }
        return replacementOperations;
    }

    public static void main(String[] args) {
        System.out.println(new CreateAnagram().createAnagram("AABAA", "BBAAA"));
    }
}
