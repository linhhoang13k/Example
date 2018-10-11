import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ArmstrongNumbersTest {
    private ArmstrongNumbers sut;

    @Test
    public void zeroIsArmstrong() {
        int checkingNumber = 0;
        sut = new ArmstrongNumbers(checkingNumber);
        boolean result = sut.isArmstrongNumber(checkingNumber);
        assertEquals(true, result);
    }

    @Test
    public void oneDigitNumberAlwaysIsArmstrong() {
        int checkingNumber = 9;
        sut = new ArmstrongNumbers(checkingNumber);
        boolean result = sut.isArmstrongNumber(checkingNumber);
        assertEquals(true, result);
    }

    @Test
    public void twoDigitNumberIsNotArmstrong1() {
        int checkingNumber = 15;
        sut = new ArmstrongNumbers(checkingNumber);
        boolean result = sut.isArmstrongNumber(checkingNumber);
        assertEquals(false, result);
    }

    @Test
    public void twoDigitNumberIsNotArmstrong2() {
        int checkingNumber = 99;
        sut = new ArmstrongNumbers(checkingNumber);
        boolean result = sut.isArmstrongNumber(checkingNumber);
        assertEquals(false, result);
    }

    @Test
    public void threeDigitNumberIsArmstrong() {
        int checkingNumber = 371;
        sut = new ArmstrongNumbers(checkingNumber);
        boolean result = sut.isArmstrongNumber(checkingNumber);
        assertEquals(true, result);
    }

    @Test
    public void threeDigitNumberIsNotArmstrong() {
        int checkingNumber = 674;
        sut = new ArmstrongNumbers(checkingNumber);
        boolean result = sut.isArmstrongNumber(checkingNumber);
        assertEquals(false, result);
    }

    @Test
    public void fourDigitNumberIsArmstrong() {
        int checkingNumber = 8208;
        sut = new ArmstrongNumbers(checkingNumber);
        boolean result = sut.isArmstrongNumber(checkingNumber);
        assertEquals(true, result);
    }

    @Test
    public void fourDigitNumberIsNotArmstrong() {
        int checkingNumber = 9753;
        sut = new ArmstrongNumbers(checkingNumber);
        boolean result = sut.isArmstrongNumber(checkingNumber);
        assertEquals(false, result);
    }

}
