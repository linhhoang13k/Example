package com.sleepsoft.challenges.uber;

import com.sleepsoft.test.BaseTest;
import org.junit.Test;

/**
 * Created by agermenos on 8/22/16.
 */
public class Parker extends BaseTest {
    boolean parkingSpot(int[] carDimensions, int[][] parkingLot, int[] luckySpot) {
        if ((carDimensions[0]<=parkingLot[0].length) && (carDimensions[1]<= parkingLot.length)
            || (carDimensions[0]<=parkingLot.length) && (carDimensions[1]<= parkingLot[0].length))
            return ((fitsVert(carDimensions, luckySpot)||fitsHor(carDimensions, luckySpot)) && canPark(carDimensions, parkingLot, luckySpot));
        else return false;
    }

    private boolean canPark(int[] carDimensions, int[][] parkingLot, int[] luckySpot) {
        // check horizontal
        boolean checking=true;
        if (carDimensions[0]>carDimensions[1]) {
            for (int y = luckySpot[0]; y <= luckySpot[2]; y++) {
                checking = checking & checkLine(parkingLot[y], luckySpot[1], luckySpot[3], true);
            }
            if (!checking) {
                checking = true;
                for (int y = luckySpot[0]; y <= luckySpot[2]; y++) {
                    checking = checking & checkLine(parkingLot[y], luckySpot[1], luckySpot[3], false);
                }
            }
        }
        else {
            for (int x = luckySpot[1]; x <= luckySpot[3]; x++) {
                int line[] = loadLine(x, parkingLot);
                checking = checking & checkLine(line, luckySpot[0], luckySpot[2], true);
            }
            if (!checking) {
                checking = true;
                for (int x = luckySpot[1]; x <= luckySpot[3]; x++) {
                    int line[] = loadLine(x, parkingLot);
                    checking = checking & checkLine(line, luckySpot[0], luckySpot[2], false);
                }
            }
        }
        return checking;
    }

    private int[] loadLine(int x, int parkingLot[][]) {
        int[] line = new int[parkingLot.length];
        for (int k=0; k<parkingLot.length; k++) {
            line[k]=parkingLot[k][x];
        }
        return line;
    }

    private boolean fitsVert(int[] carDimensions, int[] luckySpot) {
        if ((carDimensions[0]==luckySpot[3]-luckySpot[1]+1)
                && (carDimensions[1]==luckySpot[2]-luckySpot[0]+1))
            return true;
        else return false;
    }

    private boolean fitsHor(int[] carDimensions, int[] luckySpot){
        if ((carDimensions[0]==luckySpot[2]-luckySpot[0]+1)
                && (carDimensions[1]==luckySpot[3]-luckySpot[1]+1))
            return true;
        else return false;
    }

    private boolean check(int start, int end, int line[]){
        boolean retVal = true;
        for (int k = start; k <= end; k++){
            if (line[k] == 1) {
                retVal = false;
                break;
            }
        }
        return retVal;
    }

    private boolean checkLine(int line[], int origin, int end, boolean isForward) {
        boolean check;
        if (isForward) check = check(0, end, line);
        else check = check(origin, line.length-1, line);
        return check;
    }


    @Test
    public void test(){
        prepare("Test 2\t", parkingSpot(new int[]{3,2}, new int[][]{
                {1,0,1,0,1,0}, 
                {1,0,0,0,1,0}, 
                {0,0,0,0,0,1}, 
                {1,0,0,0,1,1}},
                new int[]{1, 1, 2, 3}));
        prepare("Test 5\t", parkingSpot(new int[]{4,2}, new int[][]{
                    {0,0,0,1}, 
                    {0,0,0,0}, 
                    {0,0,1,1}},
                new int[]{0, 0, 1, 3}));
        prepare("Test 7\t", parkingSpot(new int[]{5,3}, new int[][]{{1,1,1,1,1,0,1,1,1,1},
                                                                     {0,1,0,0,1,0,0,0,0,0}, 
                                                                     {0,0,0,0,0,0,0,0,1,0}, 
                                                                     {0,0,0,0,0,0,0,0,0,0}, 
                                                                     {0,0,0,0,0,0,0,0,0,1}, 
                                                                     {0,0,0,0,0,0,0,0,1,0}, 
                                                                     {0,0,1,0,0,0,0,0,0,0}, 
                                                                     {1,0,0,0,0,0,0,0,0,0}}, 
                                                            new int[]{1, 3, 5, 5}));
        prepare("Test 11\t", parkingSpot(new int[]{2,1}, new int[][]{
                    {1,1,1,1}, 
                    {1,0,0,0}, 
                    {1,0,1,0}},
                new int[]{1, 2, 1, 3}));
    }


}
