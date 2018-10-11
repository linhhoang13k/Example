/*

Only Survivor

Some guys holding swords are playing a game. This game will be the last one for most of them.

The rules of the game are the following: the players are standing in a circle. Person number 1 starts the game by killing the guy to the left of him. After that, the next living person to his left kills his the closest person to their left of him who is still alive. The game continues until there's only one person left.

Your task is, given the number of players playing the game, to find the last survivor and return the one-based position of that person. Assume that the person who starts the game has number 1, and the players are enumerated in the clockwise direction.

Example

For n = 10, the output should be
onlySurviver(n) = 5.
*/

//Source http://mathforum.org/library/drmath/view/55862.html


int onlySurviver(int players) {
    int n=0;
    int count=0;
    while(n<=players)
    {
        
        n= (int)Math.pow((double)2,(double)count);
        count++;
    }
    int k= players - (n/2);
    int survivor = 2*k +1;
    
 
    return survivor;
    
}
