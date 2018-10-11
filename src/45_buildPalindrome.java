/*
Given a string, find the shortest possible string which can be achieved by adding characters to the end of initial string to make it a palindrome.

Example

For st = "abcdc", the output should be
buildPalindrome(st) = "abcdcba".

Input/Output

    [execution time limit] 3 seconds (java)

    [input] string st

    A string consisting of lowercase latin letters.

    Guaranteed constraints:
    3 ≤ st.length ≤ 10.

    [output] string
*/

String buildPalindrome(String st) {
    String reversedString = new StringBuilder(st).reverse().toString();
    String palindrome = st;
    int length = st.length();
    
    if(st.equals(reversedString) == false){
        int depth = 0;
        for(int i = 1; i < length; i++){
            String first = st.substring(length-i);
            String second = reversedString.substring(0,i);
            if(first.equals(second))
                depth = i;
        }
        palindrome = st + reversedString.substring(depth);
    }
    
    return palindrome;
}