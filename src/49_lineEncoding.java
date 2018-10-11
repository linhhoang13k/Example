/*
Given a string, return its encoding defined as follows:

    First, the string is divided into the least possible number of disjoint substrings consisting of identical characters
        for example, "aabbbc" is divided into ["aa", "bbb", "c"]
    Next, each substring with length greater than one is replaced with a concatenation of its length and the repeating character
        for example, substring "bbb" is replaced by "3b"
    Finally, all the new strings are concatenated together in the same order and a new string is returned.

Example

For s = "aabbbc", the output should be
lineEncoding(s) = "2a3bc".

Input/Output

    [execution time limit] 3 seconds (java)

    [input] string s

    String consisting of lowercase English letters.

    Guaranteed constraints:
    4 ≤ s.length ≤ 15.

    [output] string

    Encoded version of s.
*/


String lineEncoding(String s) {
    
    StringBuilder finalString = new StringBuilder();
    s = s + '@';// Add junk value at the end of the string to avoid OutOfBoundException
    
    int sameLetterSum = 0;
    char letter = s.charAt(0);
    for(int i=0 ; i < s.length()-1 ; i++){
        // If the next letter is the same continue to next letter
        if(letter == s.charAt(i+1)){
            sameLetterSum++;
        }
        // If the next letter is different add the result in the final string
        else{
            if(sameLetterSum == 0){
                finalString.append(letter);
            }
            else{
                sameLetterSum += 1;
                String sum = String.valueOf(sameLetterSum) ;
                finalString.append(sum + letter);
                sameLetterSum = 0;
            }
            sameLetterSum = 0;
            letter = s.charAt(i+1);
        }
        
    }
    
    return finalString.toString();
}


