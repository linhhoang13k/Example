/*
Given an array of equal-length strings, check if it is possible to rearrange the strings in such a way that after the rearrangement the strings at consecutive positions would differ by exactly one character.

Example

    For inputArray = ["aba", "bbb", "bab"], the output should be
    stringsRearrangement(inputArray) = false;

    All rearrangements don't satisfy the description condition.

    For inputArray = ["ab", "bb", "aa"], the output should be
    stringsRearrangement(inputArray) = true.

    Strings can be rearranged in the following way: "aa", "ab", "bb".
    Input/Output

    [execution time limit] 3 seconds (java)

    [input] array.string inputArray

    A non-empty array of strings of lowercase letters.

    Guaranteed constraints:
    2 ≤ inputArray.length ≤ 10,
    1 ≤ inputArray[i].length ≤ 15.

    [output] boolean
*/

boolean stringsRearrangement(String[] inputArray) {
    
    String[] strings = inputArray.clone();
    int arrayLength = inputArray.length;
    int stringLength = inputArray[0].length();
    boolean isRearrangeable = false;
    for(int arrayIndex = 0; arrayIndex < arrayLength-1; arrayIndex++){
        if(isPossible(inputArray, arrayIndex)){
            isRearrangeable = true;
            break;
        }
    }
    
    return isRearrangeable;
}

// Recursive function. Checks all the possible combinations to find out if it is possible 
// for the array to be rearranged to proper order
boolean isPossible(String inputArray[], int element){
    
    int arrayLength = inputArray.length;
    int stringLength = inputArray[0].length();
    int equalLetters = 0;
    if(isArrayInOrder(inputArray)){
        return true;
    }
    for(int i = element+1 ; i < arrayLength-1 ; i++){
        equalLetters = calculateEqualLetters(inputArray[i],inputArray[element]);
        if(equalLetters == stringLength-1 && element+1 != i){
            inputArray = changePosition (inputArray, element+1, i);
            if(isPossible(inputArray, element)){
                return true;
            }
        }
        else if(equalLetters == stringLength-1 && element+1 == i){
            if(isPossible(inputArray, element+1)){
                return true;
            }
        }
        if(equalLetters == stringLength){
                return false;
        }
    }
    return false;
}

// Finds out if the given array is in proper order
boolean isArrayInOrder(String[] inputArray){
    
    int length = inputArray.length;
    boolean isArrayInOrder = true;
    for(int index = 0; index < length; index++){
        int equalLetters = calculateEqualLetters(inputArray[index],inputArray[index+1]);
        if(equalLetters != length-1){
            isArrayInOrder = false;
            break;
        }
    }
    
    return isArrayInOrder;
}

// Given two strings it calculates the number of their common characters
int calculateEqualLetters(String firstString, String secondString){
    
    int length = firstString.length();
    int commonLettersSum = 0;
    for(int index = 0; index < length ; index++){
        if(firstString.charAt(index) == secondString.charAt(index)){
            commonLettersSum++;
        }
    }
    
    return commonLettersSum;
}

// Changes the possition 
String[] changePosition(String inputArray[], int firstElement, int secondElement){
    
    String helperString = inputArray[secondElement];
    inputArray[secondElement] = inputArray[firstElement];
    inputArray[firstElement] = helperString;
    
    return inputArray;
}

