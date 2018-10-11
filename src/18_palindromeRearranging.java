/*
Given a string, find out if its characters can be rearranged to form a palindrome.

Example

For inputString = "aabb", the output should be
palindromeRearranging(inputString) = true.

We can rearrange "aabb" to make "abba", which is a palindrome.

Input/Output

    [execution time limit] 3 seconds (java)

    [input] string inputString

    A string consisting of lowercase English letters.

    Guaranteed constraints:
    1 ≤ inputString.length ≤ 50.

    [output] boolean

    true if the characters of the inputString can be rearranged to form a palindrome, false otherwise.
*/

/* 
The solution is based on the fact that for the string to be a palindrome,
It must consist of letters which are used even-number times and maximum
one letter which is used odd-number times.
*/
boolean palindromeRearranging(String inputString) {
    
    int stringLength = inputString.length();
    
    // Create an array of the alphabet
    char[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p',
                       'q','r','s','t','u','v','w','x','y','z'};
    int[] alphabetSum = new int[26];
    // Count the times that each letter is used
    for(int stringChar = 0; stringChar < stringLength; stringChar++){
        for(int alphabetChar = 0; alphabetChar < 26; alphabetChar++){
            if(inputString.charAt(stringChar) == alphabet[alphabetChar]){
                alphabetSum[alphabetChar]++;
            }
        }
    }
    // Count the number of letters that are used odd-number times
    int oddLettersNum = 0;
    for(int alphabetChar=0; alphabetChar < 26; alphabetChar++){
        if(alphabetSum[alphabetChar] % 2 != 0){
            oddLettersNum++;
        }
    }
    // Check if the letters which are used odd-number times are more than one.
    boolean isRearrangeable = true;
    if(oddLettersNum > 1){
        isRearrangeable = false;
    }
    return isRearrangeable;
}


