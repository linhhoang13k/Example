/*
Given a position of a knight on the standard chessboard, find the number of different moves the knight can perform.

The knight can move to a square that is two squares horizontally and one square vertically, or two squares vertically and one square horizontally away from it. The complete move therefore looks like the letter L. Check out the image below to see all valid moves for a knight piece that is placed on one of the central squares.

Example

    For cell = "a1", the output should be
    chessKnight(cell) = 2.

    For cell = "c2", the output should be
    chessKnight(cell) = 6.

Input/Output

    [execution time limit] 3 seconds (java)

    [input] string cell

    String consisting of 2 letters - coordinates of the knight on an 8 × 8 chessboard in chess notation.

    [output] integer
*/

int chessKnight(String cell) {
    int possibleMoves = 8;
    Character cellChar = cell.charAt(0);
    int cellNum = Character.getNumericValue(cell.charAt(1));
    
    // Check Lines A and H
    if(cellChar == 'a' || cellChar == 'h'){
        possibleMoves -= 4;
        if(cellNum == 1 || cellNum == 8){
            possibleMoves -= 2;
        }
        else if(cellNum == 2 || cellNum == 7){
            possibleMoves -= 1;
        }
    }
    // Check Lines B and G
    else if(cellChar == 'b' || cellChar =='g'){
        possibleMoves -= 2;
        if(cellNum == 1 || cellNum == 8){
            possibleMoves -= 3;
        }
        else if(cellNum == 2 || cellNum == 7){
            possibleMoves -= 2;
        }
    }
    // Check the rest of the lines
    else{
        if(cellNum == 1 || cellNum == 8){
            possibleMoves -= 4;
        }
        else if(cellNum == 2 || cellNum == 7){
            possibleMoves -= 2;
        }
    }
    return possibleMoves;
}

