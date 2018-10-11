/**You have a string s that consists of English letters, punctuation marks, whitespace characters, and brackets. It is guaranteed that the parentheses in s form a regular bracket sequence.

Your task is to reverse the strings contained in each pair of matching parentheses, starting from the innermost pair. The results string should not contain any parentheses.

Example

For string s = "a(bc)de", the output should be
reverseParentheses(s) = "acbde".

Input/Output

[time limit] 3000ms (java)
[input] string s

A string consisting of English letters, punctuation marks, whitespace characters and brackets. It is guaranteed that parentheses form a regular bracket sequence.

Constraints:
5 = s.length = 55.

[output] string**/

String reverseParentheses(String s) {
    int innerOpenedBracket = s.lastIndexOf('(');
    
    while(innerOpenedBracket != -1){
        String temp = s.substring(0, innerOpenedBracket);
        int innerClosedBracket = s.indexOf(')', innerOpenedBracket);
        temp += new StringBuffer(s.substring(innerOpenedBracket+1, innerClosedBracket)).reverse().toString();
        temp += s.substring(innerClosedBracket+1);
        s = temp;
        innerOpenedBracket = s.lastIndexOf('(');
    }
    
    return s;
}
