/*

Given two arrays of integers a and b, obtain the array formed by the elements of a followed by the elements of b.

Example

For a = [2, 2, 1] and b = [10, 11], the output should be
concatenateArrays(a, b) = [2, 2, 1, 10, 11].

*/

int[] concatenateArrays(int[] a, int[] b) {
    int res[]=new int[a.length+b.length];
    int k=0;
    for(int i=0;i<a.length;i++){
        res[k]=a[i];
        k++;
    }
    for(int i=0;i<b.length;i++){
        res[k]=b[i];
        k++;
    }
    return res;
}
