/*
Given an array of strings, return another array containing all of its longest strings.

Example

For inputArray = ["aba", "aa", "ad", "vcd", "aba"], the output should be
allLongestStrings(inputArray) = ["aba", "vcd", "aba"].

Input/Output

    [time limit] 3000ms (java)

    [input] array.string inputArray

    A non-empty array.

    Guaranteed constraints:
    1 ≤ inputArray.length ≤ 10,
    1 ≤ inputArray[i].length ≤ 10.

    [output] array.string

    Array of the longest strings, stored in the same order as in the inputArray.
*/

String[] allLongestStrings(String[] inputArray) {

    int longestLength = 0;
    int arrayLength = inputArray.length;
    int newString = 0;
    int newArraySize = 0;
    
    // Find the longest string length in the array
    for(int string = 0; string < arrayLength; string++){
        if(inputArray[string].length() > longestLength){
            longestLength = inputArray[string].length();
        }
    }
    // Build the new array
    ArrayList<String> stringList = new ArrayList<String>();
    for(int string = 0; string< arrayLength; string++){
        if(inputArray[string].length() == longestLength){
            stringList.add(inputArray[string]);
        }
    }

    String[] longestStrings = stringList.stream().toArray(String[]::new);
    return longestStrings;
}

