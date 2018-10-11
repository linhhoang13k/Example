/*
Given a positive integer num, write a function which returns True if num is a perfect square else False.

Note: Do not use any built-in library function such as sqrt.

Example 1:

Input: 16
Returns: True
Example 2:

Input: 14
Returns: False
*/

class ValidSquare {
    public boolean isPerfectSquare(int num) {
        long r = num;
        while(r*r>num){
            r = (r+num/r)/2;
        }
        if(r*r == num){
            return true;
        }
        return false;
    }
}