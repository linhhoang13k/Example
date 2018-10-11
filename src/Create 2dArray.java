/*Given array of integers lengths, create an array of arrays output such that output[i] consists of lengths[i] elements and output[i][j] = j.

Example

For lengths = [1, 2, 0, 4], the output should be

create2DArray(lengths) = [[0], 
                          [0, 1], 
                          [], 
                          [0, 1, 2, 3]]
*/


int[][] create2DArray(int[] lengths) {
    int [][] ans = new int[lengths.length][];
    for(int i = 0; i<lengths.length; i++){
        ans[i] = new int[lengths[i]];
        for(int j = 0; j<lengths[i]; j++){
            ans[i][j] = j;
        }
    }
    return ans;
}
