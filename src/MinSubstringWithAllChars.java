package interviewpractice.commonTechniquesBasic;

/**
 * @author benmakusha
 */
public class MinSubstringWithAllChars {

    String minSubstringWithAllChars(String s, String t) {
        int count[] = new int[26];
        for (int i = 0; i < t.length(); i++) {
            count[t.charAt(i) - 'a']++;
        }
        String result = "";
        for (int i = 0; i < s.length() - 1; i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                char charIndexTracker[] = s.substring(i, j).toCharArray();
                int temp[] = new int[26];
                for (int k = 0; k < charIndexTracker.length; k++) {
                    temp[charIndexTracker[k] - 'a']++;
                }
                boolean ok = true;
                for (int k = 0; k < 26; k++) {
                    if (count[k] != 0 && temp[k] < count[k]) {
                        ok = false;
                        break;
                    }
                }
                if (ok && (result == "" || result.length() > j - i))
                    result = s.substring(i, j);
            }
        }
        return result;
    }
}
