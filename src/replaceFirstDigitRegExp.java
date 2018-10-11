/*

The algorithm must replace the first digit in a string with '#' character.

It's guaranteed that the input string contains at least one digit.

Example

For input = "There are 12 points", the output should be
replaceFirstDigitRegExp(input) = "There are #2 points".
*/


//solution 1
String replaceFirstDigitRegExp(String input) {
   return input.replaceFirst("[0-9]", "#");
}

//solution 2

String replaceFirstDigitRegExp(String input) {
    Pattern p = Pattern.compile("[0-9]{1}");
        Matcher matcher = p.matcher(input);


        return  matcher.replaceFirst("#");    
}


//solution diki m 

String replaceFirstDigitRegExp(String input) {
System.out.println((int)'1');
    StringBuilder s = new StringBuilder(input);
    for(int i=0; i<input.length(); i++)
    {
       if((int)input.charAt(i)>=48 && (int)input.charAt(i)<=57)
       {
           s.setCharAt(i, '#');
           break;
       }
    }
    return s.toString();
}

