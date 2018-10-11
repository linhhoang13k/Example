import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WhatTimeIsItTest {

    private WhatTimeIsIt sut;

    @Test
    public void toSmallInput() {
        double angle = -3;
        sut = new WhatTimeIsIt(angle);
        String result = sut.currentTime(angle);
        assertEquals("Incorrect value", result);
    }

    @Test
    public void toBigInput() {
        double angle = 555;
        sut = new WhatTimeIsIt(angle);
        String result = sut.currentTime(angle);
        assertEquals("Incorrect value", result);
    }

    @Test
    public void noon1() {
        double angle = 360;
        sut = new WhatTimeIsIt(angle);
        String result = sut.currentTime(angle);
        assertEquals("12:00", result);
    }

    @Test
    public void noon2() {
        double angle = 0;
        sut = new WhatTimeIsIt(angle);
        String result = sut.currentTime(angle);
        assertEquals("12:00", result);
    }

    @Test
    public void simpleTest1() {
        double angle = 90;
        sut = new WhatTimeIsIt(angle);
        String result = sut.currentTime(angle);
        assertEquals("03:00", result);
    }

    @Test
    public void simpleTest2() {
        double angle = 180;
        sut = new WhatTimeIsIt(angle);
        String result = sut.currentTime(angle);
        assertEquals("06:00", result);
    }

    @Test
    public void mediumTest1() {
        double angle = 75.5;
        sut = new WhatTimeIsIt(angle);
        String result = sut.currentTime(angle);
        assertEquals("02:31", result);
    }

    @Test
    public void mediumTest2() {
        double angle = 234.5;
        sut = new WhatTimeIsIt(angle);
        String result = sut.currentTime(angle);
        assertEquals("07:49", result);
    }

    @Test
    public void hardTest1() {
        double angle = 22.458742;
        sut = new WhatTimeIsIt(angle);
        String result = sut.currentTime(angle);
        assertEquals("12:44", result);
    }

    @Test
    public void hardTest2() {
        double angle = 144.6870002;
        sut = new WhatTimeIsIt(angle);
        String result = sut.currentTime(angle);
        assertEquals("04:49", result);
    }
}
