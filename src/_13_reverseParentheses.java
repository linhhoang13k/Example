package Arcade_Intro;

public class _13_reverseParentheses {
    String reverseParentheses(String s) {
        // If the string doesn't contain any "(" we are done.
        if(s.lastIndexOf('(') == -1) return s;

        // Else find the last "(" --> either the most "inner" parentheses
        // or the last one in a sting like "abc(ab)cd(ef)asd".

        // Take the first part, without "(". (substring is inclusive on startIndex, but exclusive on endIndex)
        String firstPart =  s.substring(0, s.lastIndexOf('('));

        // Take the string between the two parentheses. indexOf can take two arguments, second being the startFrom
        String middleWithoutParentheses = s.substring(s.lastIndexOf('(') +1, s.indexOf(')', s.lastIndexOf('(')));
        middleWithoutParentheses = new StringBuilder(middleWithoutParentheses).reverse().toString();

        // Take last part
        String lastPart = s.substring(s.indexOf(')', s.lastIndexOf('(')) +1);

        // Repeat recursively with the new string
        return reverseParentheses(firstPart + middleWithoutParentheses + lastPart);
    }
}
