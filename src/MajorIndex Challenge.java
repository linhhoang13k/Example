/*
Given a non-negative number, your task is to write this number in base 2 and calculate the sum of positions of 1s that are followed by 0s counting from right.

Example

For number = 83, the output should be
majorIndex(number) = 7.

8310 = 10100112 which has 1's followed by 0's in positions 2 and 5 (reading from the right), so the answer is 2 + 5 = 7.

Positions of the digits to be found are colored red.
*/

int majorIndex(String number) {

    
    BigInteger big = new BigInteger(number);
    String y = big.toString(2);
    System.out.println(y);
    int pos=0;
 
    for(int i=y.length()-1; i>=1; i--)
    {
        if(y.charAt(i)=='1' && y.charAt(i-1)=='0')
        {
            pos+=y.length()-i;
      
        }
    }
    
    return pos;
}


//shorter 
/*

int majorIndex(String n) {

    
    
    n = new BigInteger(n).toString(2);
    int l=n.length(),p=0,i=l-1;

    for(;i>0; i--)
        if(n.charAt(i)=='1' && n.charAt(i-1)=='0')
            p+=l-i;
    return p;
}

*/