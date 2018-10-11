/**
 * Created by Trung on 3/30/2017.
 */
package Easy;

import java.util.Stack;

/**
 * Problem statement:
 *      Given a string containing just the characters '(', ')', '{', '}', '[' and ']',
 *      determine if the input string is valid. The brackets must close in the correct order,
 *      "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 * Solution:
 *      - Use a stack to keep track of opening parentheses (or expected closing ones, as the LeetCode solution uses).
 *      - If the character in the string is not matched with expected one popped from stack, return false.
 */
public class _20_ValidParenthesesMain {


    public static boolean isValid(String s) {
        if (s.length() == 0 || s == null) return false;
        Stack<Character> data = new Stack<>();
        boolean match = true;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                data.push(c);
            } else {
                if (data.isEmpty()) return false;
                char beginChar = data.pop();
                if (c == ')' && beginChar != '(') {
                    match = false;
                } else if (c == '}' && beginChar != '{') {
                    match = false;
                } else if (c == ']' && beginChar != '[') {
                    match = false;
                }

            }
        }
        if (!match || !data.isEmpty()) return false;
        return true;
    }

    /**
     * Short solution from LeetCode.
     * Keep track of WHAT-ARE-EXPECTED but not WHAT-ARE-SEEN (i.e store the expected closing parentheses instead of
     * the beginning ones read from the string s.
     *
     * @param s
     * @return
     */
    public boolean _solution_isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();
    }
    public static void main(String...args) {
        System.out.println(isValid("+"));
    }


}
