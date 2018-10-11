package CodeFight;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class DynamicProgrammingTest {

    DynamicProgramming dp = new DynamicProgramming();
    @Test
    public void knapsack() {
        int[] val = {60,100,120};
        int[] weight = {10,20,30};
        int capacity = 50;
        int actual = dp.knapsack(weight,val,capacity);
        Assert.assertEquals(220,actual);

    }
}