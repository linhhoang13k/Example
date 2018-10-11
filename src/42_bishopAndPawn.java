/*
Given the positions of a white bishop and a black pawn on the standard chess board, determine whether the bishop can capture the pawn in one move.

The bishop has no restrictions in distance for each move, but is limited to diagonal movement. Check out the example below to see how it can move:

Example

    For bishop = "a1" and pawn = "c3", the output should be
    bishopAndPawn(bishop, pawn) = true.

    For bishop = "h1" and pawn = "h3", the output should be
    bishopAndPawn(bishop, pawn) = false.

Input/Output

    [execution time limit] 3 seconds (java)

    [input] string bishop

    Coordinates of the white bishop in the chess notation.

    [input] string pawn

    Coordinates of the black pawn in the same notation.

    [output] boolean

    true if the bishop can capture the pawn, false otherwise.
*/

/*
The solution is constructed using the fact that the absolute value of the difference between two diagonal positions
that the bishop can move to are either 9 or 11.
*/
boolean bishopAndPawn(String bishop, String pawn) {
    boolean isPossible =  false;
    int bishopNum = positionInInt(bishop);
    int pawnNum = positionInInt(pawn);
    int diff = Math.abs(bishopNum - pawnNum);
    if((diff % 9 == 0) || (diff % 11 == 0)){
        isPossible = true;
    }
    return isPossible;
}

// Given a string it replaces the position into an integer
int positionInInt(String inputString){
    String replacedString = inputString.replace('a','1').replace('b','2')
        .replace('c','3').replace('d','4').replace('e','5')
        .replace('f','6').replace('g','7').replace('h','8');
    int num = Integer.parseInt(replacedString);  
    return num;
}

