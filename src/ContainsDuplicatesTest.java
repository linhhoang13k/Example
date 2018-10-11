package interviewpractice.commonTechniquesBasic;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author benmakusha
 */
public class ContainsDuplicatesTest {

    private ContainsDuplicates contains = new ContainsDuplicates();

    private int[] inputArray = new int[] {1, 2, 3, 1};
    private int[] inputArray2 = new int[] {3, 1};
    private int[] inputArray3 = new int[] {1, 1, 1, 3, 3, 4, 3, 2, 4, 2};
    private int[] inputArray4 = new int[] {};
    private int[] inputArray5 = new int[] {1};
    private int[] inputArray6 = new int[] {-1200000005, -1200000005};
    private int[] inputArray7 = new int[] {0, 4, 5, 0, 3, 6};
    private int[] inputArray8 = new int[] {1, 2, 3, 4};
    private int[] inputArray9 = new int[] {0, 1, 0, -1};
    private int[] inputArray10 = new int[] {2};

    @Test
    public void testContainsDuplicatesOne() {
        boolean result = contains.containsDuplicates(inputArray);
        assertTrue(result);
    }

    @Test
    public void testContainsDuplicatesTwo() {
        boolean result = contains.containsDuplicates(inputArray2);
        assertFalse(result);
    }

    @Test
    public void testContainsDuplicatesThree() {
        boolean result = contains.containsDuplicates(inputArray3);
        assertTrue(result);
    }

    @Test
    public void testContainsDuplicatesFour() {
        boolean result = contains.containsDuplicates(inputArray4);
        assertFalse(result);
    }

    @Test
    public void testContainsDuplicatesFive() {
        boolean result = contains.containsDuplicates(inputArray5);
        assertFalse(result);
    }

    @Test
    public void testContainsDuplicatesSix() {
        boolean result = contains.containsDuplicates(inputArray6);
        assertTrue(result);
    }

    @Test
    public void testContainsDuplicatesSeven() {
        boolean result = contains.containsDuplicates(inputArray7);
        assertTrue(result);
    }

    @Test
    public void testContainsDuplicatesEight() {
        boolean result = contains.containsDuplicates(inputArray8);
        assertFalse(result);
    }

    @Test
    public void testContainsDuplicatesNine() {
        boolean result = contains.containsDuplicates(inputArray9);
        assertTrue(result);
    }

    @Test
    public void testContainsDuplicatesTen() {
        boolean result = contains.containsDuplicates(inputArray10);
        assertFalse(result);
    }
}