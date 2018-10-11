/*
Given a string, return its encoding defined as follows:

First, the string is divided into the least possible number of disjoint substrings consisting of identical characters
for example, "aabbbc" is divided into ["aa", "bbb", "c"]
Next, each substring with length greater than one is replaced with a concatenation of its length and the repeating character
for example, substring "bbb" is replaced by "3b"
Finally, all the new strings are concatenated together in the same order and a new string is returned.
Example

For s = "aabbbc", the output should be
lineEncoding(s) = "2a3bc".
*/

String lineEncoding(String s) {

    int c=1,i=0;
    String n="";
    if(s.length()<2)
    {
        return "1"+s;
    }
    for(;i<s.length()-1; i++)
    {
        if(s.charAt(i) == s.charAt(i+1))
        {
            c++;
        }
        else
        {
            if(c>1)
            {
            n += c+ ""+ s.charAt(i) ;
            c=1;
            }
            else
            {
                n += ""+ s.charAt(i);
            }
        }
        if(i==s.length()-2)
        {
            if(c>1)
            {
            n+= c+ ""+ s.charAt(i+1) ;
            }
            else
            {
                n+= ""+ s.charAt(i+1) ;
            }
        }
    }
    return n;
    
}
