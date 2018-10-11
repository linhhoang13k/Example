package exercise13;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;

public class ArithmeticTest {

    private exercise13.Arithmetic underTest;

    @Before
    public void setup() {
        underTest = new exercise13.Arithmetic();
    }

    @Test
    public void arithmeticExpressionA2PlusB3C5IsTrue() {
        assertTrue(underTest.isArithmeticExpression(2, 3, 5));
    }

    @Test
    public void arithmeticExpressionA8DividedB2C4IsTrue() {
        assertTrue(underTest.isArithmeticExpression(8, 2, 4));
    }

    @Test
    public void arithmeticExpressionA8B3C4IsFalse() {
        assertFalse(underTest.isArithmeticExpression(8, 3, 4));
    }

    @Test
    public void arithmeticExpressionA6SubtractB3C3IsTrue() {
        assertTrue(underTest.isArithmeticExpression(6, 3, 3));
    }

    @Test
    public void arithmeticExpressionA9MultipliedB2C18IsTrue() {
        assertTrue(underTest.isArithmeticExpression(9, 2, 18));
    }
}
