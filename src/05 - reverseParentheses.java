String reverseParentheses(String s) {
    
    //When you write your code in an IDE and then paste it here, it looks terrible :/

    while (s.contains("(")){
           
            // one line using replace function to replace str between () with its reverse starting from the most inner () to the outer one
            //start at first '(' then add a substring and going to the inner most '('+1 to get the string instead of the '(', then go to the index of the first ')'
            //starting at the index of the last '(' to get the inner most parenthesis string + the last ')'
                
            s = s.replace(("("+s.substring(    s.lastIndexOf("(")+1,       s.indexOf( ")", s.lastIndexOf("(") )            )+")"), 
                           //Replace with a new StringBuilder that is the substring starting at the char after the last '(' 
                          (new StringBuilder(   s.substring(    s.lastIndexOf("(")+1,      s.indexOf( ")", s.lastIndexOf("(") )   )   ).reverse().toString()));
           

        }
        return s;
     
}
