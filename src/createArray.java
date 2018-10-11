/*

Given an integer size, return array of length size filled with 1s.

Example

For size = 4, the output should be
createArray(size) = [1, 1, 1, 1].

*/

int[] createArray(int size) {
    int res[]=new int[size];
    for(int i=0;i<size;i++)
        res[i]=1;
    return res;
}
