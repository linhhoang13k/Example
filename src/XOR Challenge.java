/*
Given two positive integers a and b, return the bitwise XOR of all the integers in range [a, b].

Example

For a = 2 and b = 4, the output should be
rangeXOR(a, b) = 5.

Here's why:

210 ^ 310 ^ 410 = 0102 ^ 0112 ^ 1002 = 1012 = 510.
*/

int rangeXOR(int a, int b) {
int s=a;
  
    for(int i=a+1; i<=b; i++)
    {
      
        s = s^i;
       
    }
    return s;
}
