/*
Let's consider a sequence X1 = 1, X2 = 1 ^ 2, ..., Xn = 1 ^ ... ^ n, where ^ is a bitwise xor.

Given l and r, find the value of Xl ^ Xl + 1 ^ ... ^ Xr.

Example

For l = 1 and r = 5, the output should be
rangeConsecutiveXor(l, r) = 7;
For l = 3 and r = 4, the output should be
rangeConsecutiveXor(l, r) = 4.
*/


int rangeConsecutiveXor(int l, int r) {
    int t = 0;
    for (;r>=0;r-=2) 
        t ^= r ^ (r<l ? r+1-(l-r) % 2 : 0);
    
    return t;
}

