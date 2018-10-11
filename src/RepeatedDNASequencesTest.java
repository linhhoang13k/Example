package interviewpractice.commonTechniquesAdvanced;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author benmakusha
 */
public class RepeatedDNASequencesTest {

    private RepeatedDNASequences repeated = new RepeatedDNASequences();

    private String inputDNAOne = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
    private String[] expectedOutput1 = new String[] {"AAAAACCCCC", "CCCCCAAAAA"};
    private String inputDNATwo = "";
    private String inputDNAThree = "A";
    private String inputDNAFour = "";
    private String inputDNAFive = "GAGAGAGAGAGAG";
    private String[] expectedOutput2 = new String[] {"AGAGAGAGAG", "GAGAGAGAGA"};
    private String inputDNASix = "AAAAAGGGGGAAAAAGGGGGGAAAAACCCCTTT";
    private String[] expectedOutput3 = new String[] {"AAAAAGGGGG", "GGGGGAAAAA"};
    private String inputDNASeveb = "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA" +
            "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA" +
            "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA" +
            "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA" +
            "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA" +
            "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
    private String[] expectedOutput4 = new String[] {"AAAAAAAAAA"};

    @Test
    public void testRepeatedDNASequencesOne() {
        String[] result = repeated.repeatedDNASequences(inputDNAOne);
        assertArrayEquals(expectedOutput1, result);
    }

    @Test
    public void testRepeatedDNASequencesTwo() {
        String[] result = repeated.repeatedDNASequences(inputDNATwo);
        assertArrayEquals(new String[0], result);
    }

    @Test
    public void testRepeatedDNASequencesThree() {
        String[] result = repeated.repeatedDNASequences(inputDNAThree);
        assertArrayEquals(new String[]{}, result);
    }

    @Test
    public void testRepeatedDNASequencesFour() {
        String[] result = repeated.repeatedDNASequences(inputDNAFour);
        assertArrayEquals(new String[]{}, result);
    }

    @Test
    public void testRepeatedDNASequencesFive() {
        String[] result = repeated.repeatedDNASequences(inputDNAFive);
        assertArrayEquals(expectedOutput2, result);
    }

    @Test
    public void testRepeatedDNASequencesSix() {
        String[] result = repeated.repeatedDNASequences(inputDNASix);
        assertArrayEquals(expectedOutput3, result);
    }

    @Test
    public void testRepeatedDNASequencesSeven() {
        String[] result = repeated.repeatedDNASequences(inputDNASeveb);
        assertArrayEquals(expectedOutput4, result);
    }
}