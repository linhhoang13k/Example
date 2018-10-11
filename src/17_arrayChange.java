/*
You are given an array of integers. On each move you are allowed to increase exactly one of its element by one. Find the minimal number of moves required to obtain a strictly increasing sequence from the input.

Example

For inputArray = [1, 1, 1], the output should be
arrayChange(inputArray) = 3.

Input/Output

    [execution time limit] 3 seconds (java)

    [input] array.integer inputArray

    Guaranteed constraints:
    3 ≤ inputArray.length ≤ 105,
    -105 ≤ inputArray[i] ≤ 105.

    [output] integer

    The minimal number of moves needed to obtain a strictly increasing sequence from inputArray.
    It's guaranteed that for the given test cases the answer always fits signed 32-bit integer type.
*/

int arrayChange(int[] inputArray) {
    int[] newArray= inputArray.clone();
    int arrayLength = newArray.length;
    int moves = 0;
    
    for(int index = 0; index < arrayLength-1 ;index++){
        int difference = newArray[index] - newArray[index+1] ;
        if(difference>=0){
            moves += difference + 1;
            newArray[index+1] += difference + 1;
        }
    }
    return moves;
}
