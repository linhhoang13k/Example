/*
Correct variable names consist only of Latin letters, digits and underscores and they can't start with a digit.

Check if the given string is a correct variable name.

Example

    For name = "var_1__Int", the output should be
    variableName(name) = true;
    For name = "qq-q", the output should be
    variableName(name) = false;
    For name = "2w2", the output should be
    variableName(name) = false.

Input/Output

    [execution time limit] 3 seconds (java)

    [input] string name

    Guaranteed constraints:
    1 ≤ name.length ≤ 10.

    [output] boolean

    true if name is a correct variable name, false otherwise.

*/

boolean variableName(String name) {
    int nameLength = name.length();
    boolean isCorrect = true;
    
    
    for(int index = 0; index < nameLength; index++){
        if( (Character.isDigit(name.charAt(index)) && index!=0) || 
              (Character.isLetter(name.charAt(index))) ||
               (name.charAt(index) == '_')
          ){
            isCorrect = true;
        }else{
            isCorrect = false;
            break;
        }
    }
    return isCorrect;
}