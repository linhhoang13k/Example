/*

Determine if the given number is a power of some non-negative integer.

Example

For n = 125, the output should be
isPower(n) = true;
For n = 72, the output should be
isPower(n) = false.

*/

boolean isPower(int n) {
    if(n==1)
        return true;
    for(int i=2;i<n;i++)
        for(int j=2;j<n;j++)
            if(Math.pow(i,j)==n)
                return true;
    return false;
}
