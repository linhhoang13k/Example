/*
Given a rectangular matrix of characters, add a border of asterisks(*) to it.

Example

For

picture = ["abc",
           "ded"]

the output should be

addBorder(picture) = ["*****",
                      "*abc*",
                      "*ded*",
                      "*****"]

Input/Output

    [execution time limit] 3 seconds (java)

    [input] array.string picture

    A non-empty array of non-empty equal-length strings.

    Guaranteed constraints:
    1 ≤ picture.length ≤ 5,
    1 ≤ picture[i].length ≤ 5.

    [output] array.string

    The same matrix of characters, framed with a border of asterisks of width 1.

*/
    
String[] addBorder(String[] picture) {
    int stringLength = picture[0].length();
    int arrayLength = picture.length;

    ArrayList<String> list = new ArrayList<String>();
    StringBuilder upDownBorder = new StringBuilder();
    StringBuilder borderedElements = new StringBuilder();
    
    // Make strings filled with asterisks
    for(int letterIndex=0; letterIndex < stringLength+2 ; letterIndex++){
        upDownBorder.append('*');
        borderedElements.append('*');
    }
    
    for(int stringIndex = 0; stringIndex < arrayLength+2; stringIndex++){
        // Add the asterisk strings to the top and bottom
        if( (stringIndex == 0) || (stringIndex == arrayLength+1) ){
            list.add(stringIndex,upDownBorder.toString());
        // Replace the given strings to the rest of the asterisk strings
        }else{
            borderedElements.replace(1, stringLength+1, picture[stringIndex - 1]);
            list.add(stringIndex,borderedElements.toString());  
        }
    }
    
    String newMatrix[] = list.toArray(new String[list.size()]);
    return newMatrix;
}