/**
 *  Telephone is a game played around the world, in which one person whispers a message to another, this person whispers what she has heard to the next one, and so on, until the last player announces the message she got to the entire group. Errors typically accumulate during this process, so the phrase announced by the last player may differ significantly from the initial one.
 * 
 *  You're given the array messages of message versions: message[0] is the statement the 1st person told the 2nd one (i.e. it is the initial phrase), message[1] is the statement the 2nd person told the 3rd one, etc. The last element of message corresponds to the phrase announced to the entire group by the last player.
 * 
 *  Find the index (0-based) of the first player who failed to reproduce exactly what she should have heard or identify that nobody made a mistake.
 *
 *  Example
 *  
 *  For
 *  
 *  messages = ["CodeFights rocks!",
 *              "CodeFights rocks!", 
 *             "CodeFights folks!",
 *              "Code Fights folks!",
 *              "Code bites folks!"]
 *  the output should be
 *  telephoneGame(messages) = 2.
 *
 *  Input/Output
 *  
 *  [time limit] 3000ms (java)
 *
 *  [input] array.string messages
 *  
 *  Array of at least two non-empty strings.
 *  
 *  Guaranteed constraints:
 *  2 ≤ messages.length ≤ 10,
 *  1 ≤ messages[i].length ≤ 60.
 *  
 *  [output] integer
 *  
 *  The index (0-based) of the first player who failed to reproduce exactly what she heard or -1 if there is no such player.
 */

int telephoneGame(String[] messages) {
    int i = 1;
    while(i < messages.length && messages[i - 1].equals(messages[i]))
        i++;
    return i == messages.length? -1 : i;
}

/**
 *  7/7
 *  All tests passed
 *  Sample tests: 4/4
 *  Hidden tests: 3/3
 *  Score: 300/300
 */