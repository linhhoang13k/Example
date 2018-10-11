/*
Given a string, output its longest prefix which contains only digits.

Example

For inputString="123aa1", the output should be
longestDigitsPrefix(inputString) = "123".

Input/Output

    [execution time limit] 3 seconds (java)

    [input] string inputString

    Guaranteed constraints:
    3 ≤ inputString.length ≤ 35.

    [output] string

*/


String longestDigitsPrefix(String inputString) {
    try{
        String[] digits = inputString.split("[^0-9]+");
        return digits[0];
    }
    catch(ArrayIndexOutOfBoundsException exception){
        return "";
    }
}
