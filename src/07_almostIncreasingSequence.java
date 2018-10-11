/*Given a sequence of integers as an array, determine whether it is possible to 
obtain a strictly increasing sequence by removing no more than one element from 
the array.
For sequence = [1, 3, 2, 1], the output should be
almostIncreasingSequence(sequence) = false;
There is no one element in this array that can be removed in order to get a 
strictly increasing sequence.

[input] array.integer sequence
Guaranteed constraints:
2 ≤ sequence.length ≤ 105,
-105 ≤ sequence[i] ≤ 105.

[output] boolean
Return true if it is possible to remove one element from the array in order to get a strictly increasing sequence, otherwise return false.
*/


boolean almostIncreasingSequence(int[] sequence) {
    int sequenceLength = sequence.length;
    boolean noWrongPairs = true;
    for(int element = 0; element < sequenceLength - 1; element++) {
        if(sequence[element] >= sequence[element+1]) {
            if(noWrongPairs) {
                if((element != 0) && (element != sequenceLength-2)) {
                    if(sequence[element+1] <= sequence[element-1]) {
                        if(sequence[element+2] <= sequence[element]) {
                            return false;
                        }
                        element++;
                    }
                }
                noWrongPairs = false;
            } else {
                return false;
            }
        }
    }
    return true;
}

