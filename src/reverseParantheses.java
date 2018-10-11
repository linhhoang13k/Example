String reverseParentheses(String s) {
    String leftPart = "";
    String rightPart = "";
    String middlePart = "";
    int lastOpen = 0;
    int firstClose = 0;
    int i = 0;
    while(i < s.length()) {
        if (s.charAt(i) == '(' || s.charAt(i) == ')') {
            s = reverse(s);
            i = 0;
        } else {
            i++;
        }
    }
    
    return s;
}

String reverse(String s) {
    int lastOpen = 0;
    int firstClose = 0;
    for (int i = 0; i < s.length(); i++) {
        if (s.charAt(i) == '(') {
            lastOpen = i;
        } else if (s.charAt(i) == ')') {
            firstClose = i;
            break;
        }
    }
    
    return s.substring(0, lastOpen) + new StringBuilder(s.substring(lastOpen + 1, firstClose)).reverse().toString() + s.substring(firstClose+1);
}
