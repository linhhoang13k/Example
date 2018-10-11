package Arcade_Intro;

import junit.framework.TestCase;
import org.junit.jupiter.api.Test;

public class _01_addTest extends TestCase {
    private final _01_add testObj = new _01_add();

    @Test
    public void test_1_add(){
        assertEquals(testObj.add(1,2),3);
        assertEquals(testObj.add(0,1),1);
        assertEquals(testObj.add(0,0),0);
    }
}