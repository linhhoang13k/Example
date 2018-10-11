package me.cwuyi;

/**
 * Created by xyy on 2017/7/1.
 */
public class _227 {

    public static void main(String[] args) {
        System.out.println(calculate("3+2*2"));
    }

    public static int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        s.replaceAll(" ", "");

        int now = 0;
        char operator = ' ';
        int offset = 0;

        for (int i = offset; i < s.length(); i++) {
            if (s.charAt(i) > '9' || s.charAt(i) < '0') {
                operator = s.charAt(i);
                offset = i;
                break;
            }
        }
        now = Integer.parseInt(s.substring(0, offset));

        if (operator == s.length()) {
            return now;
        }

        switch (operator) {
            case '+' :
                return now + calculate(s.substring(offset + 1));
            case '-' :
                return now - calculate(s.substring(offset + 1));
            case '*' :
                return now * calculate(s.substring(offset + 1));
            case '/' :
                return now / calculate(s.substring(offset + 1));
        }
        return 0;
    }
}
