package me.cwuyi;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * Created by XIA on 2017/7/5.
 */
public class _150 {
    public static void main(String[] args) {
        System.out.println(evalRPN(new String[]{"4", "13", "5", "/", "+"}));
    }

    public static int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) return 0;
        LinkedList<String> stack = new LinkedList();
        Set<String> operators = new HashSet<>();
        operators.add("+");
        operators.add("-");
        operators.add("*");
        operators.add("/");
        for (String token : tokens) {
            if (operators.contains(token)) {
                int one = Integer.parseInt(stack.pop());
                int two = Integer.parseInt(stack.pop());
                if (token.equals("+")) {
                    stack.push(one + two + "");
                } else if (token.equals("-")) {
                    stack.push(two - one + "");
                } else if (token.equals("*")) {
                    stack.push(one * two + "");
                } else if (token.equals("/")) {
                    stack.push(two / one + "");
                }
                continue;
            }
            stack.push(token);
        }
        return Integer.parseInt(stack.pop());
    }
}
