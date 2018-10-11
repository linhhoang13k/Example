package CodeFight;

import java.util.*;

public class MZBot {

    public boolean farmingResources(int[] fTrp, int[] eTrp, int[] loggingCamp, int[][] impassableCells) {
        int[][] worldMap = new int[41][41];
        for(int[] arr : worldMap)
            Arrays.fill(arr,Integer.MAX_VALUE);
        for(int[] cell:impassableCells){
            worldMap[shiftCoord(cell[0])][shiftCoord(cell[1])] = Integer.MAX_VALUE-1;
        }
        worldMap[shiftCoord(fTrp[0])][shiftCoord(fTrp[1])]=0;

        int[][] worldMap2 = new int[41][41];
        for(int[] arr : worldMap2)
            Arrays.fill(arr,Integer.MAX_VALUE);

        for(int[] cell:impassableCells){
            worldMap2[shiftCoord(cell[0])][shiftCoord(cell[1])] = Integer.MAX_VALUE-1;
        }
        worldMap2[shiftCoord(eTrp[0])][shiftCoord(eTrp[1])]=0;

//        System.arraycopy(worldMap,0,worldMap2,0,worldMap.length);
        int[][][] pathF = findPath( new int[]{0,shiftCoord(fTrp[0]),shiftCoord(fTrp[1])}
                , new int[]{0,shiftCoord(loggingCamp[0]),shiftCoord(loggingCamp[1])}
                , worldMap);
        int timeF = worldMap[shiftCoord(loggingCamp[0])][shiftCoord(loggingCamp[1])]*fTrp[2];
        int[][][] pathE = findPath( new int[]{0,shiftCoord(eTrp[0]),shiftCoord(eTrp[1])}
                , new int[]{0,shiftCoord(loggingCamp[0]),shiftCoord(loggingCamp[1])}
                , worldMap2);
        int timeE = worldMap2[shiftCoord(loggingCamp[0])][shiftCoord(loggingCamp[1])]*eTrp[2];
        return timeF < timeE;
    }
    //for each cell
//0-distance
//1-x
//2-y
    int[][][] findPath(int[] src, int[] dst, int[][] worldMap){
        int[][][] path = new int[41][41][3];
        int[][] d = {{-1,0},{0,-1},{1,-1},{1,0},{0,1},{-1,1}};
        PriorityQueue<int[]> minQueue = new PriorityQueue<>(1600,(c1, c2)->{return c1[0]-c2[0];});
        minQueue.add(src);

        while(!minQueue.isEmpty()){
            int[] cell= minQueue.poll();
            if(cell[1]==dst[1] && cell[2]==dst[2]){
                //gotchas
                break;
            }
            //navigate to the adjacent cell
            for(int i=0;i<d.length;i++){
                int nextRow = cell[1]+d[i][0];
                int nextCol = cell[2]+d[i][1];
                if(!isViolate(nextRow,nextCol,src,worldMap)){
                    if(worldMap[nextRow][nextCol] > cell[0]+1){
                        worldMap[nextRow][nextCol]=cell[0]+1;
                        //update path
                        path[nextRow][nextCol][0]=cell[0]+1;
                        path[nextRow][nextCol][1]=cell[1];
                        path[nextRow][nextCol][2]=cell[2];
                        minQueue.add(new int[]{cell[0]+1,nextRow,nextCol});
                    }
                }
            }
        }
        return path;
    }

    boolean isViolate(int row, int col, int[] src, int[][] worldMap){
        if(row<0 || row > 40 || col<0 || col>40
                || worldMap[row][col]==Integer.MAX_VALUE-1
                || (row==src[1] && col==src[2]))
            return true;
        return false;
    }

    int shiftCoord(int coord){
        return coord + 20;
    }

    public int allianceVersusMonster(int[] h, int[] atk) {
        int[][] heroes = new int[h.length-1][2];
        //0 - monster
        //step 1 - each hero inflict maximum damange but stay alive
        for(int i=1;i<h.length;i++){
            int hit = h[i]/atk[0];
            if(h[i]%atk[0]==0) //no hitpoint left, better reduce hit to stay alive
                hit--;
            if(hit<=0)
                continue;
            h[0]-= hit*atk[i];
            if(h[0]<=0)
                return h.length-1;
            h[i]-= hit*atk[0];
        }
        //OOPS - the monster still alive
        //step 2 - now any hero can die with 1 hit
        //sort hero by damage, highest alive hero attack first to try to kill monster
        //as soon as possible thus maximize the surviving heroes
        for(int i=1;i<h.length;i++){
            heroes[i-1][0]=h[i];
            heroes[i-1][1]=atk[i];
        }

        Arrays.sort(heroes,(ar1, ar2)->{
            return ar2[1]-ar1[1];
        });
        int i=0;
        for(;i<heroes.length && h[0]>0;i++){
            h[0]-=heroes[i][1];
        }

        return h[0]>0?0:heroes.length - i + 1;
    }

    public void testing(){
        Stack<Integer> stk = new Stack<>();

        Queue<Integer> queue = new LinkedList<>();
    }

    /*
    * XXIV , XXIX
    * */
    public int romanToInt(String roman){
        String[] romanChars={"X"};
        int[]    val ={};
        return 0;
    }
}
