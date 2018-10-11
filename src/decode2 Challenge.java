/*
A squared encoding in a simple encoding algorithm that can be used to encrypt messages of moderate importance. To encrypt a message consisting of lowercase English letters, the following steps should be taken:

consider message characters one by one;
each letter is assigned to a number: 'a' to 1, 'b' to 2, and so on, with 'y' assigned to 25 and 'z' assigned to 0;
take a value assigned to the character, calculate its square modulo 26, and add the letter assigned to the obtained result to the answer.
Given a message, your task is to encode it using the squared encoding algorithm.

Example

For message = "hello", the output should be
decode2(message) = "lynnq".

Here's why:

'h' -> 82 % 26 = 64 % 26 = 12 -> 'l';
'e' -> 52 % 26 = 25 % 26 = 25 -> 'y';
'l' -> 122 % 26 = 144 % 26 = 14 -> 'n';
'o' -> 152 % 26 = 225 % 26 = 17 -> 'q'.
*/

String decode2(String m) {

    String s ="";
    for(int i=0; i<m.length(); i++)
    {
        if(m.charAt(i)=='z')
        {
            s+='z';
            continue;
        }
      s+= (char)(((Math.pow(((int)m.charAt(i) -96),2)% 26)+96)) ;
    }
    return s;
}
