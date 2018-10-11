/*
Given the final position and score of a CodeFighter in a tournament, return the number of coins and XP they will get.

Here is how these values can be calculated:

coins: 2000 * (1 / 2)position, where / is integer division;
XP: 2 * score if position equals 1 and score otherwise.
Example

For position = 1 and score = 500, the output should be
codefightsTournament(position, score) = [2000, 1000].

For position = 6 and score = 100, the output should be
codefightsTournament(position, score) = [62, 100].
*/

int[] codefightsTournament(int p, int s) {

    int[] a = new int[2];
    
    a[0] = (int)(4000*Math.pow(0.5,p));
    a[1]=(p>1)?s:2*s;
    return a;
    
}

//shortest

int[] codefightsTournament(int p, int s) {

    
   int[] a = {(int)(4000*Math.pow(0.5,p)),(p=(p>1)?s:2*s)};
    
    
    return a;
    
}
