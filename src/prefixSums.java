int[] prefixSums(int[] a) {
    int s = 0;
    for (int i = 0; i < a.length; i++){
        s = a[i] += s;
    }
    return a;
}

/*Another Solution*/
int[] prefixSums(int[] a) {
for(int i=1;i<a.length;i++)
    a[i] += a[i-1];
return a;
}
/*Another Solution*/
int[] prefixSums(int[] a) {
    int[] result = new int[a.length];
    result[0] = a[0];
    for(int i = 1; i < a.length; i++) {
        result[i] = a[i] + result[i-1];
    }
    return result;
}
/*
Construct an array b of prefix sums of the given array a.

b is defined as:
  b[0]   = a[0]
  b[1]   = a[0] + a[1]
  b[2]   = a[0] + a[1] + a[2]
  ...
  b[n - 1] = a[0] + a[1] + ... + a[n - 1]
where n is the length of a.

For a = [1, 2, 3], the output should be
prefixSums(a) = [1, 3, 6].

b would be equal to [1, 1 + 2, 1 + 2 + 3] = [1, 3, 6]
*/
