/*
A string is said to be beautiful if b occurs in it no more times than a; c occurs in it no more times than b; etc.

Given a string, check whether it is beautiful.

Example

    For inputString = "bbbaacdafe", the output should be
    isBeautifulString(inputString) = true;
    For inputString = "aabbb", the output should be
    isBeautifulString(inputString) = false;
    For inputString = "bbc", the output should be
    isBeautifulString(inputString) = false.

Input/Output

    [execution time limit] 3 seconds (java)

    [input] string inputString

    A string of lowercase letters.

    Guaranteed constraints:
    3 ≤ inputString.length ≤ 50.

    [output] boolean
*/

boolean isBeautifulString(String inputString) {
    // Calculate the number of times a letter appears in the string
    char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    int[] letterSum = new int[26];
    int stringLength = inputString.length();
    for(int letterIndex = 0; letterIndex < stringLength; letterIndex++){
        for(int alphabetIndex = 0; alphabetIndex < 26; alphabetIndex++){
            if(inputString.charAt(letterIndex) == alphabet[alphabetIndex]){
                letterSum[alphabetIndex]++;
            }
        }
    }
    // Check if the beautiful assumption is true
    boolean isBeautiful = true;
    for(int index = 0; index < 25; index++){
        if(letterSum[index] < letterSum[index+1]){
            isBeautiful = false;
        }
    }
    return isBeautiful;
}