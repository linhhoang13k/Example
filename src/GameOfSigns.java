package com.codefights.challenges;

import java.util.Arrays;

/**
 * Created by zambro on 7/12/17.
 * https://codefights.com/challenge/uMQAhyc2uv8RfzbyH
 *
 * You are in a field of tiles, m. Each tile may or may not have a sign on it.

 There are 4 possible types of signs:

 "S" is your starting point;
 "F" is the finish;
 "R" means that you have to turn 90 degrees clockwise;
 "L" means that you have to turn 90 degrees counterclockwise.
 Empty tiles are represented with the character "-".

 Your starting direction is d.

 The steps of the game are:

 Start from the tile with the sign "S", pointing to the direction d;
 Move forward until you reach a sign or the edge of the field;
 If you reach a sign, do what it says depending on the sign;
 If you reach the edge of the field, the game ends.
 Your task is to return true if you have reached the finish sign at the end of the game, or false if you have not.

 Example
 For

 m = ["S-R",
 "F-R"]
 and d = "R", the output should be
 gameOfSigns(m, d) = true
 */
public class GameOfSigns {

    static boolean gameOfSigns(String[] m, String d) {
        int row = 0;
        int col = 0;

        char[][] c= new char[m.length][m[0].length()];
        char currState;
        char prevState = d.charAt(0);
        for(int i=0;i<m.length;i++) {
            c[i] = m[i].toCharArray();

            if (m[i].contains("S")) {
                row = i;
                col = m[i].indexOf('S');
            }
        }

        System.out.println(row+" , "+col);
        System.out.println(Arrays.deepToString(c));

        while( row>=0 && row<m.length && col>=0 && col<m[0].length()){
            if(c[row][col] == 'F')
                return true;

            currState = c[row][col];
            switch (currState){
                case 'R':
                    if(prevState == 'U') {
                        col++;
                        prevState =  'R';
                    }
                    else if(prevState == 'D') {
                        col--;
                        prevState = 'L';
                    }
                    else if(prevState == 'R') {
                        row++;
                        prevState = 'D';
                    }
                    else if(prevState == 'L') {
                        row--;
                        prevState = 'U';
                    }
                    break;

                case 'L':
                    if(prevState == 'U') {
                        col--;
                        prevState = 'L';
                    } else if(prevState == 'D') {
                        col++;
                        prevState = 'R';
                    } else if(prevState == 'R') {
                        row--;
                        prevState = 'U';
                    } else if(prevState == 'L') {
                        row++;
                        prevState = 'D';
                    }
                    break;

                default:
                    if(prevState == 'U')
                        row--;
                    else if(prevState == 'D')
                        row++;
                    else if(prevState == 'R')
                        col++;
                    else if(prevState == 'L')
                        col--;
                    break;


            }
        }
        return false;
    }

    static boolean gameOfSignsOptimized(String[] m, String d) {
        int x=0,y=0;
        int h="URDL".indexOf(d);
        for (int r=0;r<m.length;++r)
            if (m[r].contains("S")) {
                y=r;
                x=m[r].indexOf("S");
            }
        while (x>=0 & x<m[0].length() & y>=0 & y<m.length)
        {
            switch (m[y].charAt(x))
            {
                case 'F': return true;
                case 'R': h=(h+1)%4; break;
                case 'L': h=(h+3)%4;
            }
            y+=(h-1)%2;
            x-=(h-2)%2;
        }
        return false;

    }


    public static void main(String[] args) {
        String[] m = {"S-R",
                "F-R"};
        System.out.println(gameOfSigns(m,"R"));
        String[] m1 = {"LS",
                "LF"};
        System.out.println(gameOfSigns(m1,"L"));
        String[] m2 = {"R-----R---",
                "----------",
                "----------",
                "R-----L--R",
                "L--------R",
                "----------",
                "L----FS---",
                "----------",
                "----------",
                "----------"};
        System.out.println(gameOfSigns(m2,"U"));
    }

}
