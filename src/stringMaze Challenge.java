/*
Your task is to determine the number of moves it will take to get from the first character of the given string maze to the last one.

Each character of maze is a lowercase letter of the English alphabet. Each letter is assigned an integer value: 'a' = 1, 'b' = 2, 'c' = 3, and so on, with 'z' = 26. Starting from the first character of the maze, you can move n characters to the right, where n is the value assigned to the letter at your current position. For example, if you are standing on the character 'c', you should move 3 positions to the right.

If you land up on a character that lies farther than the last character of the maze, start over from the beginning and keep counting. For example, if you pass over the last character by four, you will end up at the fourth character from the beginning.

Given the maze, return the number of moves required to get to its last character from its first one as described above. If the algorithm turns out to be an infinite loop that never lands on the last character, return -1 instead.

Example

For maze = "able", the output should be
stringMaze(maze) = 2.

Starting on 'a', move one character right to the 'b'. Since 'b' equals 2, move two more characters right to the 'e'. 'e' is the last character in the maze, so you are finished. This took two moves, so the output should be 2.

For maze = "aced", the output should be
stringMaze(maze) = -1.

Starting on the 'a', move one character right to the 'c'. Since 'c' equals 3, move three more characters right, wrapping around to the 'a' again. 'a' and 'c' form an infinite loop, so the answer is -1.

*/



int stringMaze(String maze) {

  
    int count =0;
    int vima=0;
    int i=1;
    int apomenoun=0;
    
  
    while(i<maze.length())
    {
        count++;
        if(count>100)
        {
            return -1;
        }
        
        vima = (int)maze.charAt(i-1)-96;
        
        if(maze.length()-i >= vima)
        {
            i+=vima;
        }
        
        else
        {
            
            apomenoun = maze.length()-i;
            
            i =   vima - apomenoun;
            i = i%maze.length();
            
            if(i==0)
            {
                break;
            }
        }
    }
    return count;
}


/*shortest solution*/


int c,v,i=1;
int stringMaze(String m) {


  
    while(i<99)  /*loop is gonna break from the c>99 statement which indicates there's infinite loop or from the i==0 statement so number 99 is to make sure everything will work fine */
    {
        c++;
        if(c>99)/* case of infinitive loop ->> return -1*/
            return -1;
        v = (int)m.charAt(i-1)-96;/*number characters we move right according to value of character */
        if(m.length()-i >= v)/*if positions remaining in the string are more than our move we count plus our number of moves to the right */
            i+=v;
        else/*if number of moves exceed the string limit we go back and repeat out moves */
            i +=   v-m.length();
            i %=m.length();
            if(i==0)/*in this case we have finished */
                break;
    }
    return c;
}
