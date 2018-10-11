/*
Reverse bits of a given 32 bits unsigned integer.

Example:

Input: 43261596
Output: 964176192
Explanation: 43261596 represented in binary as 00000010100101000001111010011100, 
             return 964176192 represented in binary as 00111001011110000010100101000000.
*/

public class ReverseBits {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
       int sum = 0;
        int multi = 1;
        int mask = 1;
        for(int i =31; i>=0; i--){
            if((n & (1 << i))!=0){
                sum += multi;
            }
            multi *= 2;
        }
        return sum;
    }
}