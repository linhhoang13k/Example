/*

In tennis, a set is finished when one of the players wins 6 games and the other one wins less than 5, or, if both players win at least 5 games, until one of the players wins 7 games.

Determine if it is possible for a tennis set to be finished with the score score1 : score2.

Example

    For score1 = 3 and score2 = 6, the output should be
    tennisSet(score1, score2) = true.

    For score1 = 8 and score2 = 5, the output should be
    tennisSet(score1, score2) = false.

    Since both players won at least 5 games, the set would've ended once one of them won the 7th one.

    For score1 = 6 and score2 = 5, the output should be
    tennisSet(score1, score2) = false.

Input/Output

    [execution time limit] 3 seconds (java)

    [input] integer score1

    Number of games won by the 1st player, non-negative integer.

    Guaranteed constraints:
    0 ≤ score1 ≤ 10.

    [input] integer score2

    Number of games won by the 2nd player, non-negative integer.

    Guaranteed constraints:
    0 ≤ score2 ≤ 10.

    [output] boolean

    true if score1 : score2 represents a possible score for an ended set, false otherwise.

*/


boolean tennisSet(int score1, int score2) {

    boolean isFinished = false;
    if(isRightScore(score1,score2) == true || isRightScore(score2,score1) == true){
        isFinished = true;
    }
    
    return isFinished;
}

public boolean isRightScore(int player1, int player2){
    
    boolean isRight= false;
    if(player1 == 7 && (player2 == 6 || player2 == 5) ){
        isRight = true;
    }
    if(player1 == 6 && player2 < 5){
        isRight = true;
    }
    
    return isRight;
}