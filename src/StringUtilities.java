import java.util.HashMap;
import java.util.Map;

public class StringUtilities {

    /**
     * https://codefights.com/challenge/kMZk3NzQ8Qx3qrPiA
     **/
    public static int longestSubstring(String s, int m) {
        char[] charArray = s.toCharArray();

        boolean addCharacter = true;
        int startIndex = 0;
        int endIndex = 0;
        int longestSubstring = 0;

        Map<Character, Integer> charCountMap = new HashMap<>();
        while (endIndex < s.length()) {
            if (addCharacter) {
                addCharacterToMap(charArray[endIndex], charCountMap);
            }

            if (charCountMap.size() <= m) {
                if (m == charCountMap.size() && endIndex - startIndex + 1 > longestSubstring) {
                    longestSubstring = endIndex - startIndex + 1;
                }
                addCharacter = true;
                endIndex++;
            } else {
                removeCharacterFromMap(charArray[startIndex], charCountMap);
                addCharacter = false;
                startIndex++;
            }
        }
        return longestSubstring;
    }

    private static void removeCharacterFromMap(Character c, Map<Character, Integer> charCountMap) {
        if (charCountMap.containsKey(c)) {
            if (charCountMap.get(c) == 1) {
                charCountMap.remove(c);
            } else {
                charCountMap.put(c, charCountMap.get(c) - 1);
            }
        }
    }

    private static void addCharacterToMap(Character c, Map<Character, Integer> charCountMap) {
        if (charCountMap.containsKey(c)) {
            charCountMap.put(c, charCountMap.get(c) + 1);
        } else {
            charCountMap.put(c, 1);
        }
    }
}
