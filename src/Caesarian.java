/**
    Caesarian shift (Caesar cipher) is a method used in 
    cryptography where a string message is encrypted by 
    shifting the letters n times.

    You are given an integer n, which can be positive,
    negative or zero. Positive values indicate right 
    shifts, and negative values indicate left shifts.

    Given a message and n, return message encrypted by the shift n.

    Example

    For message = "abc" and n = 3, the output should be
    caesarian(message, n) = "def".

    "a", shifted to the right 3 times, becomes "d",
     "b" becomes "e" and "c" becomes "f".

    For message = "egg" and n = -1, the output should be
    caesarian(message, n) = "dff".

    Input/Output

    [time limit] 3000ms (java)
    [input] string message: The message to be encrypted.

    Constraints: 0 ≤ message.length ≤ 500.

    [input] integer n: The shift value.

    Constraints: -2 · 109 ≤ n ≤ 2 · 109.

    [output] string: Encrypted message.
*/

/*
    Author: Casey Langford
    Date: 9/9/16

    My solution passed all tests, but was about twice as long as
    the winning solutions after I reduced the charachter count.
*/

public class Caesarian{
    public static void main(String[] args){
        Caesarian test = new Caesarian();

        System.out.println(test.caesarian("abc", 3));
        System.out.println(test.caesarian("stargazing", -3023));
    }

    String caesarian(String message, int n) {
        String str="";
        int b = 0;

        if(Math.abs(n) > 26){
            n %= 26;
        }
        for(int i = 0; i < message.length(); i++){
            // b is the ascii value of each character + the offset
            b = (int)message.charAt(i) + n;
            // if b > value of 'z', go to front of the alphabet
            if(b > 122){
                b = b % 122 + 96;
            }
            // if b < value of 'a', go to end of the alphabet
            if(b < 97){
                b = 123 - (97 - b);
            }
            // Add the character to the return string
            str += String.valueOf((char)b);
        }
        return str;
    }   
}


