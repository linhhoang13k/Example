package CodeFightsTasks;

import org.jetbrains.annotations.NotNull;

/**
 * Created by Pasha on 24.01.2018.
 */
public class CFTask13 {
    String reverseParentheses(String s) {
        StringBuilder instanceOfString = new StringBuilder(s);
        return reverseStringBrackets(instanceOfString, 0);
    }
    @NotNull
    public static String reverseStringBrackets(StringBuilder str, int startIndex) {
        for (int i = startIndex; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                reverseStringBrackets(str, i + 1);
            } else if (str.charAt(i) == ')') {
                int endIndex = i - 1;

                StringBuilder newStr = new StringBuilder(str.substring(startIndex, endIndex + 1));
                System.out.println("Newstr equals: " + newStr);
                str.delete(startIndex - 1, endIndex + 2);
                System.out.println(str);
                newStr.reverse();
                str.insert(startIndex - 1, newStr);
                return str.toString();
            }
        }
        return str.toString();
    }

}
