int differentSubstringsTrie(String inputString) {
    HashSet<String> s= new HashSet<String>();
       String str="";
       for(int i= inputString.length() ; i>-1 ; i--){
          for(int j = 0; j <= inputString.length()-i ; j++){
          str = inputString.substring(j , j+i);
          if(!str.equals(""))s.add(str);
        }
    }
    return s.size();
}

/*
Given a string, find the number of different non-empty substrings in it.

Note : A substring of a string S is another string S' that occurs in S. 
For example, "Fights" is a substring of "CodeFights", but "CoFi" isn't.

For inputString = "abac", the output should be
differentSubstringsTrie(inputString) = 9.
They are:

"a", "b", "c",
"ab", ac", "ba",
"aba", "bac",
"abac"
*/
