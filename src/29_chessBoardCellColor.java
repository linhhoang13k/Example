/*
Given two cells on the standard chess board, determine whether they have the same color or not.

Example

    For cell1 = "A1" and cell2 = "C3", the output should be
    chessBoardCellColor(cell1, cell2) = true.

    For cell1 = "A1" and cell2 = "H3", the output should be
    chessBoardCellColor(cell1, cell2) = false.

Input/Output

    [execution time limit] 3 seconds (java)

    [input] string cell1

    [input] string cell2

    [output] boolean

    true if both cells have the same color, false otherwise.
*/

boolean chessBoardCellColor(String cell1, String cell2) {
    
    // Get the cell number
    int firstNumber = Character.getNumericValue(cell1.charAt(1));
    int secondNumber = Character.getNumericValue(cell2.charAt(1));
    
    // Get the cell letter in the form of a number
    char[] columns = "ABCDEFGH".toCharArray();
    int firstLetterPosition = 0;
    int secondLetterPosition = 0;
    for(int index = 0 ; index < columns.length ; index++){
        if( cell1.charAt(0) == columns[index]){
            firstLetterPosition = index + 1;
        }
        if( cell2.charAt(0) == columns[index]){
            secondLetterPosition = index + 1;
        }
    }
    
    String firstCellColor = cellColor(firstNumber, firstLetterPosition);
    String secondCellColor = cellColor(secondNumber, secondLetterPosition);
 
    boolean areSameColor = false;
    if( firstCellColor == secondCellColor){
        areSameColor = true;
    }
    return areSameColor;
}

// Returns the color of a specific cell
String cellColor(int row, int column){
    String color = new String();
    if( (column % 2 == 0) && (row % 2 != 0) ||
        (column % 2 != 0) && (row % 2 == 0) ){
        color = "white";
    }
    else{
        color = "black";
    }   
    return color;
}
