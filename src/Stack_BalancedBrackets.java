package HackerRank;

import java.util.*;

/**
 * Problem details at:
 * https://www.hackerrank.com/challenges/ctci-balanced-brackets
 *
 * In a nutshell, use a stack to determine whether at string of brackets: {} [] () contains only paired closed bracekts
 */
public class Stack_BalancedBrackets {

    static char[] openBrackets = {'(', '[', '{'};

    public static boolean isBalanced(String expression) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            // check if next char is an open bracket
            boolean openBracketFound = false;
            for (char openBracket : openBrackets) {
                if (expression.charAt(i) == openBracket)
                    openBracketFound = true;
                break;
            }
            // a new open bracket, add to the stack
            if (openBracketFound) {
                stack.push(expression.charAt(i));
            // a closed bracket, check if there's a matching open one previously
            } else {
                if (stack.size() > 0) {
                    char previousBracket = stack.pop();
                    System.out.println("This bracket: " + expression.charAt(i));
                    System.out.println("Previous bracket: " + previousBracket);
                    switch (expression.charAt(i)) {
                        case ')':
                            if (previousBracket != '(')
                                return false;
                            break;
                        case ']':
                            if (previousBracket != '[')
                                return false;
                            break;
                        case '}':
                            if (previousBracket != '{')
                                return false;
                            break;
                        default:
                            return false;
                    }
                // nothing else in the stack, brackets therefore not balanced
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            String expression = in.next();
            System.out.println( (isBalanced(expression)) ? "YES" : "NO" );
        }
    }
}
