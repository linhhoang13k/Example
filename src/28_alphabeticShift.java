/*
Given a string, replace each its character by the next one in the English alphabet (z would be replaced by a).

Example

For inputString = "crazy", the output should be
alphabeticShift(inputString) = "dsbaz".

Input/Output

    [execution time limit] 3 seconds (java)

    [input] string inputString

    Non-empty string consisting of lowercase English characters.

    Guaranteed constraints:
    1 ≤ inputString.length ≤ 10.

    [output] string

    The result string after replacing all of its characters.
*/

    

String alphabeticShift(String inputString) {
    char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    int stringLength = inputString.length();
    StringBuilder builderString = new StringBuilder();
    
    for(int letter = 0; letter < stringLength; letter ++){
        for(int index = 0 ; index < 26; index++){
            
            if( inputString.charAt(letter) == alphabet[index] && index != 25){
                builderString.append(alphabet[index+1]);
            }
            else if(inputString.charAt(letter) == alphabet[index] && index == 25){
                builderString.append(alphabet[0]);
            }
        }
    }
    String shiftedString = builderString.toString();
    return shiftedString;
}