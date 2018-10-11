
/**
 * Created by Trung on 3/30/2017.
 */
package Easy;

/**
 * Problem statement:
 *      Determine a longest common prefix (a substring that starts at beginning of a string) of the strings in the array.
 *
 * Solution:
 *      Repeatedly check each character of other strings against a char of the first string that is in same index.
 */
public class _14_LongestCommonPrefixMain {

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length > 0) {
            StringBuilder ans = new StringBuilder();
            boolean notDone = true, match;
            int i = 0;
            while (notDone) {
                match = true;
                char a;
                if (i < strs[0].length() && strs.length > 0 && !strs[0].equals("")) {
                    a = strs[0].charAt(i);
                    for (int j = 1; j < strs.length; j++) {
                        if (strs[j].length() - 1 >= i) {
                            char b = strs[j].charAt(i);
                            if (a != b) {
                                notDone = false;
                                break;
                            }
                        } else {
                            match = false;
                        }
                    }
                    if (match && notDone) {
                        ans.append(a);
                    }
                    i++;
                } else {
                    notDone = false;
                }
            }
            return ans.toString();
        } else {
            return "";
        }
    }

    /**
     * One of many solutions.
     *
     * @param strs
     * @return
     */
    public static String _solution_longestCommonPrefix(String[] strs) {
        if (strs.length == 0 || strs == null) return "";
        else {
            String pre = strs[0];
            int i = 1;
            while (i < strs.length) {
                while (strs[i].indexOf(pre) != 0) {
                    pre = pre.substring(0, pre.length() - 1);
                }
                i++;
            }
            return pre;
        }
    }


    public static void main(String... args) {
        String[] input = new String[5];
        input[0] = "abcdsggfg";
        input[1] = "abcdhgfhj";
        input[2] = "abckfnmf";
        input[3] = "abdnfjsfkjnblbafak";
        input[4] = "abddoienn";
        System.out.println(longestCommonPrefix(input));
    }
}
