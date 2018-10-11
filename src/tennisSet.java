/* 

In tennis, a set is finished when one of the players wins 6 games and the other one wins less than 5, or, if both players win at least 5 games, until one of the players win 7 games.

Determine if it is possible for a tennis set to be finished with the score score1 : score2.

Example

For score1 = 3 and score2 = 6, the output should be
tennisSet(score1, score2) = true;
For score1 = 8 and score2 = 5, the output should be
tennisSet(score1, score2) = false;
For score1 = 6 and score2 = 5, the output should be
tennisSet(score1, score2) = false.
*/

import java.io.*;

class myCode
{
    public static void main (String[] args) throws java.lang.Exception
    {
        System.out.println(tennisSet(7,2));
    }
    
    public static boolean tennisSet(int score1, int score2) {
    if(((score1<5 || score2<5)&& (score1==6 || score2==6))||
      ((score1>=5 && score2>=5) && (score1==7 || score2==7)) && score1!=score2) return true;
    return false;


    }
}
