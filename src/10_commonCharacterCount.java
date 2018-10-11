/*
Given two strings, find the number of common characters between them.

Example

For s1 = "aabcc" and s2 = "adcaa", the output should be
commonCharacterCount(s1, s2) = 3.

Strings have 3 common characters - 2 "a"s and 1 "c".

Input/Output

    [time limit] 3000ms (java)

    [input] string s1

    A string consisting of lowercase latin letters a-z.

    Guaranteed constraints:
    1 ≤ s1.length ≤ 15.

    [input] string s2

    A string consisting of lowercase latin letters a-z.

    Guaranteed constraints:
    1 ≤ s2.length ≤ 15.

    [output] integer

*/

int commonCharacterCount(String s1, String s2) {
    String firstString = s1;
    String secondString = s2;
    int commonCharacters = 0;
    int firstComparisonCount =0;
    int secondComparisonCount = 0;
    int firstStringLength = firstString.length();
    int secondStringLength = secondString.length();
    int[] checkedLetters = new int[firstStringLength];
    
    for(int i=0;i<firstStringLength;i++){
        checkedLetters[i]=0;
    }
    
    for(int letter = 0; letter < firstStringLength; letter++){
        firstComparisonCount = 0;
        secondComparisonCount = 0; 
        
        //check for repetition of the letter in the same string
        if(checkedLetters[letter] == 0){//avoid checking a duplicate a second time
            for(int letterCheck = 0 ; letterCheck < firstStringLength; letterCheck++){
                if((letter != letterCheck) && (firstString.charAt(letter) == firstString.charAt(letterCheck))){
                    firstComparisonCount++;
                    checkedLetters[letterCheck] = 1;
                }
            }
            //check for common characters on the second string
            for(int secondStringLetter = 0; secondStringLetter < secondStringLength ;s econdStringLetter++){
                if(firstString.charAt(letter) == secondString.charAt(secondStringLetter)){
                    secondComparisonCount++;
                }
            }
            //calculate the total number of common characters
            if(secondComparisonCount < firstComparisonCount+1){
                commonCharacters += secondComparisonCount;
            }else{
                commonCharacters += firstComparisonCount+1;
            }
        }
    }
    
    return commonCharacters;
}
