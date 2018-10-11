/*
Given a string, find the number of different characters in it.

Example

For s = "cabca", the output should be
differentSymbolsNaive(s) = 3.

There are 3 different characters a, b and c.

Input/Output

    [execution time limit] 3 seconds (java)

    [input] string s

    A string of lowercase latin letters.

    Guaranteed constraints:
    3 ≤ s.length ≤ 15.

    [output] integer
*/

int differentSymbolsNaive(String s) {
    int distinctCharacters = (int) s.chars().distinct().count(); 
    return distinctCharacters;
}
