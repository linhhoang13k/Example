package com.pramp;

/**
 * Created by zambro on 5/22/17.
 *
 * https://www.pramp.com/question/KvZ3aL35Ezc5K9Eq9Llp
 *
 * Implement a regular expression function isMatch that supports the '.' and '*' symbols.
 * The function receives two strings - text and pattern - and should return true if the text matches the pattern as a regular expression.
 *
 * For simplicity, assume that the actual symbols '.' and '*' do not appear in the text string and are used as special symbols only in the pattern string.
 *
 * In case you aren’t familiar with regular expressions, the function determines if the text and pattern are the equal,
 * where the '.' is treated as a single a character wildcard (see third example),
 * and '*' is matched for a zero or more sequence of the previous letter (see fourth and fifth examples).

 Explain your algorithm, and analyze its time and space complexities.

 Examples:

 input:  text = "aa", pattern = "a"
 output: false

 input:  text = "aa", pattern = "aa"
 output: true

 input:  text = "abc", pattern = "a.c"
 output: true

 input:  text = "abbb", pattern = "ab*"
 output: true

 input:  text = "acd", pattern = "ab*c."
 output: true
 */
public class BasicRegexParser {

    public static boolean isValid(String text, int t, String pattern, int p) {
        if(t>=text.length()) {
            if(p>=pattern.length()){
                return true;
            } else {
                if(p+1<pattern.length() && pattern.charAt(p+1) == '*')
                    return isValid(text, t, pattern, p+2);
                else
                    return false;
            }
        } else if(p>=pattern.length()){
            return false;
        } else if(p+1<pattern.length() && pattern.charAt(p+1) == '*') {
            if(text.charAt(t) == pattern.charAt(p) || pattern.charAt(p) == '.')
                return isValid(text, t+1, pattern, p) || isValid(text, t, pattern, p+2);
            else
                return isValid(text, t, pattern, p+2); //Case where the text char does not match the pattern first char + *, so move onto the next pattern.
        } else if(text.charAt(t) == pattern.charAt(p) || pattern.charAt(p) == '.') {
            return isValid(text, t+1, pattern, p+1);
        }

        return false;
    }
    public static void main(String[] args) {
        System.out.println(isValid("aaaaaaa",0,"a.*",0));
        System.out.println(isValid("aa",0,"a",0));//false
        System.out.println(isValid("aa",0,"ab",0));//false
        System.out.println(isValid("ba",0,"ab",0));//false
        System.out.println(isValid("ba",0,"a*b.*",0));
        System.out.println(isValid("aaaaaaa",0,"a*",0));
        System.out.println(isValid("aaaaaaa",0,".*b",0)); //false
        System.out.println(isValid("aaaaaaab",0,".*.",0));
        System.out.println(isValid("aaaaaaabbxxxxyz",0,".*b.*xy.*",0));
        System.out.println(isValid("aaaaaaabbxxxxyz",0,".*b.*xy",0)); //false
        System.out.println(isValid("bxxxxy",0,".*b.*xy",0));
        System.out.println(isValid("b",0,"a*c*x*",0));
    }
}

/**
 when text is empty
    if pattern is empty, nothing to check
        return true
    else
        pattern has atleast 2 chars and 2nd char is a *, so lets ignore this useless character + * and continue checking
            isValid(text, t, pattern, p+2)
        else
            return false, we have no text but the next character in pattern is not ignorable(not followed by *)
 if pattern is empty as at this point text has char
    return false
 if pattern has atleast 2 chars and 2nd char is a *
    if text(t) == pattern(p) || pattern(p) == .
        return isValid(text, t-1, pattern, p) || isValid(text, t, patter, p-2)
    else
        Found a useless char followed by *, so ignore it
        return isValid(text, t, pattern, p-2)
 All special cases are handled above, so handle the normal case
 text(t) == pattern(p)
    isValid(text, t+1, pattern, p+1)

 return false;
 */