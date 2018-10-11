package arcade.mirroLake;

import java.util.HashMap;

/**
 * Created by JavierSainz on 11/14/16.
 */
public class SubstitutionCipher {
    boolean isSubstitutionCipher(String string1, String string2) {
        HashMap<Character, Character> map = new HashMap<>(string1.length());
        for (int index = 0; index < string1.length(); index++) {
            char c1 = string1.charAt(index);
            char c2 = string2.charAt(index);
            if (map.containsKey(c1)) {
                if (map.get(c1) != c2) {
                    return false;
                }
            } else if (map.containsValue(c2)) {
                return false;
            } else {
                map.put(c1, c2);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new SubstitutionCipher().isSubstitutionCipher("aacb", "aabc"));
    }
}
