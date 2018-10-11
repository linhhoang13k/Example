/*
You are given a string s that consists of English letters, punctuation marks, whitespace characters and brackets. It is guaranteed that the brackets in s form a regular bracket sequence.

Your task is to reverse the strings in each pair of matching parenthesis, starting from the innermost one.

Example

For string "s = a(bc)de" the output should be
reverseParentheses(s) = "acbde".
*/

/*FIRST SOLUTION */

String reverseParentheses(String s) {
int a;
   while ((a = s.lastIndexOf('(')) >= 0)/*FIND LAST INDEX OF ( BRACKET  so while a parenthesis exists loop*/
    {
        String f = s.substring(a + 1, s.indexOf(')', a));
        s = s.replace("(" + f + ")", new StringBuilder(f).reverse());
    }
    
    return s;
}

/* SECOND SOLUTION */

String reverseParentheses(String s) {

   Matcher m = Pattern.compile("\\((\\w*)\\)").matcher(s);
        return m.find() ? reverseParentheses(m.replaceFirst(""+new StringBuilder(m.group(1)).reverse())) : s;
}

/*THIRD SOLUTION   */

String reverseParentheses(String s) {

   String r;
    char c;
    for(int i, j; (j = i = s.lastIndexOf("(")) >= 0 ; 
               s=s.substring(0,i)+r+s.substring(j+1))
        for(r = "" ; (c = s.charAt(++j)) > 41 ; )
            r = c + r;

    return s;
}


/*MINE SOLUTION*/
String reverseParentheses(String s) {

    String newS="";
    int firstp =0;
    int lastp =0;
    for(int i=0; i<s.length(); i++)
    {
        if(s.charAt(i) == '(')
        {
            firstp =i;
            break;
        }
        else
        {
            newS +=s.charAt(i);
        }
    }
    for(int i = s.length()-1; i>firstp; i--)
    {
        if(s.charAt(i) == ')')
        {
            lastp =i;
            break;
        }
    }
    int a=0;
    for(int i=lastp-1; i> firstp; i--)
    {
        if(s.charAt(i) != ')')
        {
            newS +=s.charAt(i);
        }
        else
        {
            for(int j=i-1; j> firstp; j--)
            {
                if(s.charAt(j) =='(')
                {
                    for(int w=j+1; w<=i-1; w++)
                    {
                        newS += s.charAt(w);
                         a = w;
                        
                    }
                    a=j;
                    
                    break;
                }
                 
            }
            i=a;
            
        }
       
    }
    for(int i=lastp +1; i<s.length(); i++)
    {
        newS += s.charAt(i);
    }
    
    return newS;
}



