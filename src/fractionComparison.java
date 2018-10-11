char fractionComparison(int[] a, int[] b) {
    float A = (float)a[0] / (float)a[1];
    float B = (float)b[0] / (float)b[1];
    return A == B ? '=' : A < B ? '<' : '>';
}

/*
Compare the two given fractions.

For a = [3, 4] and b = [6, 8], the output should be
fractionComparison(a, b) = '=';
For a = [3, 2] and b = [2, 5], the output should be
fractionComparison(a, b) = '>';
For a = [3, 5] and b = [2, 3], the output should be
fractionComparison(a, b) = '<'.
*/
