/*
Given an array of integers, find the maximal absolute difference between any two of its adjacent elements.

Example

For inputArray = [2, 4, 1, 0], the output should be
arrayMaximalAdjacentDifference(inputArray) = 3.

Input/Output

    [execution time limit] 3 seconds (java)

    [input] array.integer inputArray

    Guaranteed constraints:
    3 ≤ inputArray.length ≤ 10,
    -15 ≤ inputArray[i] ≤ 15.

    [output] integer

    The maximal absolute difference.
*/

int arrayMaximalAdjacentDifference(int[] inputArray) {
    int arrayLength = inputArray.length;
    int[] newArray = inputArray.clone();
    int difference = 0;
    int maxDifference = 0;
    for(int arrayIndex=0; arrayIndex < arrayLength - 1; arrayIndex++){
        difference = Math.abs(newArray[arrayIndex] - newArray[arrayIndex+1]);
        if(difference > maxDifference){
            maxDifference = difference;
        }
    }
    return maxDifference;
}
