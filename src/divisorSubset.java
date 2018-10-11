/*
Given an array of integers subset and an integer n, find the number of integers between 1 and n, inclusive, whose set of divisors contains subset as a subset.

Example

For subset = [2, 3] and n = 13, the output should be
divisorsSubset(subset, n) = 2.

Input/Output
*/

boolean d(int[] s,int n)
{
    boolean b=false;
    for(int i=0;i<s.length;i++)
        {b=(n%s[i]==0);
        if(!b)
        return false;}
    return true;
}
int divisorsSubset(int[] subset, int n) {
    int c=0;
    for(int i=1;i<=n;i++)
        if(d(subset,i))
            c++;
    return c;
}
