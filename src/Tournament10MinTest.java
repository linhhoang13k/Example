package CodeFight;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by tranpham on 3/14/18.
 */
public class Tournament10MinTest {
    @Test
    public void permuteDotInString() throws Exception {
        tnm.permuteDotInString("Hello");
    }

    @Test
    public void mod() throws Exception {
        Assert.assertEquals(2306996%16,tnm.mod(2306996,16));

    }

    @Test
    public void higherVersion() throws Exception {
        Assert.assertEquals(true,tnm.higherVersion("1.2.2","1.2.0"));
    }

    @Test
    public void firstMultiple() throws Exception {
    }


    @Test
    public void unusualLexOrder() throws Exception {
        String[] words= {"nigeb","ta","eht","gninnigeb"};
        String[] expected = {"ta","nigeb","gninnigeb","eht"};
        String[] actual= tnm.unusualLexOrder(words);
        Assert.assertArrayEquals(expected,actual);
    }

    @Test
    public void maxSubmatrixSum() throws Exception {
        int[][]matrix= {{1,12,11,10},
                        {4,3,2,9},
                {5,6,7,8}};
        int n= 2;
        int m= 1;
        int expected = 19;
        int actual = tnm.maxSubmatrixSum(matrix,n,m);
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void robotWalk() throws Exception {
        int[] a = {4, 4, 3, 2, 2, 3};
        boolean expected = true;
        boolean actual =  tnm.robotWalk(a);
        Assert.assertEquals(expected,actual);

        int[] b = {10, 3, 10, 2, 5, 1, 2};
        expected = false;
        actual =  tnm.robotWalk(b);
        Assert.assertEquals(expected,actual);

    }


    @Test
    public void cyclicQueue() throws Exception {
    }


    @Test
    public void electionsWinners() throws Exception {
        int[] votes = {5, 1, 3, 4, 1};
        int k = 0;
        int expected = 0;
        int actual=tnm.electionsWinners(votes,k);
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void maximizeNumberRoundness() throws Exception {
        int expected = 1;
        int actual = tnm.maximizeNumberRoundness(11020000);
        Assert.assertEquals(1,actual);
    }

    @Test
    public void patternMatching() throws Exception {
        String smStr=" abc   a aa  a a ";
//        String[] nonW = smStr.split(" ");
        while (smStr.indexOf("  ")>=0)
            smStr=smStr.trim().replace("  "," ");
        String res="";
//        for (int i=0;i<nonW.length;i++){
//            if (!nonW[i].isEmpty()) {
//                res+=nonW[i].trim();
//                if(i<nonW.length-1)
//                    res+=" ";
//            }
//        }

        System.out.println(smStr);
    }

    Tournament10Min tnm = new Tournament10Min();
    @Test
    public void spiralNumbers() throws Exception {
        int n=3;
        int[][] expected = {{1,2,3},{8,9,4},{7,6,5}};
        int[][] actual = tnm.spiralNumbers(3);
        System.out.println(Arrays.deepToString(actual));
        Assert.assertArrayEquals(expected,actual);
    }

    int makeArrayConsecutive2(int[] statues) {
        return 0;
    }

    String whoseMove(String lastPlayer, boolean win) {
        if(win){
            return lastPlayer;
        }
        return lastPlayer.equals("black")?"white":"black";
    }

}