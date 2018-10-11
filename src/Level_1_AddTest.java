package Arcade.Intro;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Trung on 5/2/2017.
 */
public class Level_1_AddTest {

    @Test
    public void add() throws Exception {
        Level_1_Add testClass = new Level_1_Add();
        assertEquals(3, testClass.add(1, 2));
    }

    @Test(expected = AssertionError.class )
    public void addFail() throws Exception {
        Level_1_Add testClass = new Level_1_Add();
        assertEquals(-1, testClass.add(1, 4));
    }

    @Test
    public void addNeg() throws Exception {
        Level_1_Add testClass = new Level_1_Add();
        assertEquals(-2018, testClass.add(-1, -2017));
    }

    @Test
    public void addPosNeg() throws Exception {
        Level_1_Add testClass = new Level_1_Add();
        assertEquals(1, testClass.add(-1, 2));
    }

}