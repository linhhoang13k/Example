/*
Run-length encoding (RLE) is a very simple form of lossless data compression in which runs of data (that is, sequences in which the same data value occurs in many consecutive data elements) are stored as a single data value and count, rather than as the original run.

Given a string s, your task is to encode it using the RLE.

Example

For s = "aabbbccc", the output should be
encode(s) = "a2b3c3".
*/

String encode(String s) {
    int c=1,i=0;
    String n="";
    if(s.length()<2)
    {
        return s+"1";
    }
    for(;i<s.length()-1; i++)
    {
        if(s.charAt(i) == s.charAt(i+1))
        {
            c++;
        }
        else
        {
            n += s.charAt(i) +""+c;
            c=1;
        }
        if(i==s.length()-2)
        {
            n+=s.charAt(i+1) +""+c;
        }
    }
    return n;
}


/* SMALLEST SOLUTION */ 


String encode(String s) {
    String a = "";
    
    for (String t : s.split("(?<=(.))(?!\\1)"))
        a = a + t.charAt(0) + t.length();
    
    return a;
}
/*
char c, d, C[];
String encode(String s) {
    
    
    for(char e : C = (s+1).toCharArray())
        if(e == c)
            d++;
        else{
            s = d > 0 ? s + c + d*1 : "";
            d = 1;
            c = e;
        }
    
    return s;
}*/
