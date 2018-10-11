package CodeFight;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MZBotTest {

    @Test
    public void allianceVersusMonster() {
        int[] healthPoints = {4, 10, 10, 10};
        int[] attackDamage = {10, 1, 1, 1};
        int expected = 0;
        int actual =  mzBot.allianceVersusMonster(healthPoints,attackDamage);
        Assert.assertEquals(expected,actual);

        healthPoints = new int[]{10, 3, 3, 3};
        attackDamage = new int[]{2, 1, 5, 1};
        expected = 2;
        actual =  mzBot.allianceVersusMonster(healthPoints,attackDamage);
        Assert.assertEquals(expected,actual);

        healthPoints = new int[]{11, 4, 4, 4};
        attackDamage = new int[]{1, 1, 1, 1};
        expected = 2;
        actual =  mzBot.allianceVersusMonster(healthPoints,attackDamage);
        Assert.assertEquals(expected,actual);

    }

    MZBot mzBot = new MZBot();

    @Test
    public void farmingResources() {
        int[] friendlyTroops = {17, 18, 6};
        int[] enemyTroops = {19, 16, 6};
        int[] loggingCamp = {18, 19};
        int[][] impassableCells = {{17,19},{18,18},{19,18}};
        boolean expected = true;
        boolean actual = mzBot.farmingResources(friendlyTroops,enemyTroops,loggingCamp,impassableCells);
        Assert.assertTrue(actual);

        friendlyTroops = new int[]{-2, 2, 3};
        enemyTroops = new int[]{1, 0, 9};
        loggingCamp = new int[]{0, 0};
        impassableCells = new int[][]{};
        Assert.assertTrue(mzBot.farmingResources(friendlyTroops,enemyTroops,loggingCamp,impassableCells));
    }
}