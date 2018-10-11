package com.codefights.challenges;

/**
 * Created by zambro on 6/1/17.
 * You have a seaMap of part of the Caribbean Sea, represented as a 2D array. The map shows the positions of dangerous cliffs that a wise sea dog should steer clear of.

 As the captain of the most notorious pirate ship on the high seas, you're not afraid of these little rocks and are willing to navigate your ship through them. However, you're mildly curious about the number of cliff lines in the area. You assume that cliffs form a line if they are connected to each other, i.e. if each cliff has another cliff directly to the left, to the right, above, or below it.

 Looking at the seaMap, calculate the number of cliff lines on it.

 Example

 For

 seaMap = [[0,1,1],
 [0,1,1],
 [0,0,0]]
 the output should be
 countCliffs(seaMap) = 1.

 There is only one cliff line on the seaMap, which consists of 4 cliffs and forms a square.
 */
public class CliffCounter {
    static int countCliffs(int[][] s) {
        int count = 0, n=s.length, m=s[0].length;
        boolean[][] visited = new boolean[n][m];
        for(int i=0;i<s.length;i++){
            for(int j=0;j<s[0].length;j++){
                if(s[i][j] == 1 && !visited[i][j]){
                    count++;
                    markVisited(visited, s, i, j);
                }
            }
        }
        return count;
    }

    private static void markVisited(boolean[][] visited, int[][]s, int i, int j) {
        if(i<0 || i>=s.length || j<0 || j>=s[0].length)
            return;
        if(s[i][j] == 1 && !visited[i][j]) {
            visited[i][j] = true;
            markVisited(visited, s, i+1, j);
            markVisited(visited, s, i-1, j);
            markVisited(visited, s, i, j+1);
            markVisited(visited, s, i, j-1);
        }

    }


    public static void main(String[] args) {
        int[][] s = {{0,1,1},
                     {0,1,1},
                     {0,0,0}};
        System.out.println(countCliffs(s));
        int[][] s1 = {{1,0,1},
                      {1,0,1},
                      {1,1,1}};
        System.out.println(countCliffs(s1));
        int[][] s2 = {{1,0,1},
                {1,0,1},
                {1,0,1}};
        System.out.println(countCliffs(s2));
    }

}
