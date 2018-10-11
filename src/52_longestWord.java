/*
Define a word as a sequence of consecutive English letters. Find the longest word from the given string.

Example

For text = "Ready, steady, go!", the output should be
longestWord(text) = "steady".

Input/Output

    [execution time limit] 3 seconds (java)

    [input] string text

    Guaranteed constraints:
    4 ≤ text.length ≤ 50.

    [output] string

    The longest word from text. It's guaranteed that there is a unique output.
*/

String longestWord(String text) {
    String parts[] = text.split("[^a-zA-Z]");
    int maxLength = 0;
    int maxLengthIndex = 0;
    for(int i = 0; i < parts.length; i++){
        if(parts[i].length() > maxLength){
            maxLength = parts[i].length();
            maxLengthIndex = i;
        }
    }
    return parts[maxLengthIndex];
}