int permutationShift(int[] permutation) {
  int minShift = 0,
      maxShift = 0;
  for (int i = 0; i < permutation.length; i++) {
    if (permutation[i] - i > maxShift) {
      maxShift =  permutation[i] - i ;
    }
    if (permutation[i] - i < minShift) {
      minShift = permutation[i] - i;
    }
  }
  return maxShift - minShift;
}

/*
Define the permutation element shift as the difference between the element's value and its index. For example, 
for permutation [1, 0, 2, 3] of array [0, 1, 2, 3] shifts for the respective elements are [1, -1, 0, 0].

Define the permutation shift as the difference between the maximal and the minimal element shifts among all of the permutation elements.

Given a permutation of integers from 0 to n - 1 for some integer n, find its shift.

Example

For permutation = [1, 0, 2, 3], the output should be
permutationShift(permutation) = 2.
*/
