import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CenturyFromYearTest {

    @Test
    public void testCenturyFromYear() {
        int expectedCentury = 20;

        int testYear = 1905;

        int actualCenturyFromYear = CenturyFromYear.centuryFromYear(testYear);
        assertEquals(expectedCentury, actualCenturyFromYear);
    }

    @Test
    public void testCenturyFromYear2() {
        int expectedCentury = 17;

        int testYear = 1700;

        int actualCenturyFromYear = CenturyFromYear.centuryFromYear(testYear);
        assertEquals(expectedCentury, actualCenturyFromYear);
    }

    @Test
    public void testCenturyFromYear3() {
        int expectedCentury = 2;

        int testYear = 200;

        int actualCenturyFromYear = CenturyFromYear.centuryFromYear(testYear);
        assertEquals(expectedCentury, actualCenturyFromYear);
    }

    @Test
    public void testCenturyFromYear4() {
        int expectedCentury = 1;

        int testYear = 45;

        int actualCenturyFromYear = CenturyFromYear.centuryFromYear(testYear);
        assertEquals(expectedCentury, actualCenturyFromYear);
    }
}
