int[] prefixSumsToSuffixSums(int[] prefixSums) {
    int[] suffix = new int[prefixSums.length];
    suffix[0] = prefixSums[prefixSums.length - 1];
    for (int i = 1; i < suffix.length; i++) {
        suffix[i] = suffix[0] - prefixSums[i-1];
    }
    return suffix;
}

/*
Given the prefix sums of some array A, return suffix sums for the same array, i.e. an array B that:

B[0] = A[0] + A[1] + A[2] + ... + A[n - 1]
B[1] =        A[1] + A[2] + ... + A[n - 1]
...
B[n - 2] =             A[n - 2] + A[n - 1]
B[n - 1] =                        A[n - 1]

For prefixSums = [1, 3, 6, 10, 15], the output should be
prefixSumsToSuffixSums(prefixSums) = [15, 14, 12, 9, 5].

You may verify that the initial array A is [1, 2, 3, 4, 5] (just try to calculate the prefix and suffix sums for it).

https://codefights.com/tournaments/5Qdmk2atwLLHJmDfz/D
*/
