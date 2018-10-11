package arcade.edgeoftheocean;

import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTimeout;

public class    almostIncreasingSequenceTest {

    public static boolean almostIncreasingSequence(int[] sequence) {
        int adjacentViolationCount = 0;
        for (int j=0; j < sequence.length - 1; j++) {
            if (sequence[j] >= sequence[j+1]) {
                adjacentViolationCount++;
            }
        }

        int nonAdjacentViolationCount = 0;
        for (int i = 0; i < sequence.length - 2; i++) {
            if (sequence[i] >= sequence[i+2]) {
                nonAdjacentViolationCount++;
            }
        }

        return (adjacentViolationCount < 2) &&
               (adjacentViolationCount + nonAdjacentViolationCount <= 2);
    }

    @Test
    public void sequenceOfTwoElementsIsAlwaysIncreasing() {
        int[] sequence = new int[] { 1, 1 };    // Test 10
        boolean actual = almostIncreasingSequence(sequence);
        assertEquals(true, actual);
    }

    @Test
    public void sequenceOfIncreasingElementsIsIncreasing() {
        int[] sequence = new int[] { 1, 2, 3 };
        boolean actual = almostIncreasingSequence(sequence);
        assertEquals(true, actual);

        sequence = new int[] { 123, -17, -5, 1, 2, 3, 12, 43, 45 }; // Test 16
        actual = almostIncreasingSequence(sequence);
        assertEquals(true, actual);
    }

    @Test
    public void sequenceWithJustOneAnomalyIsIncreasing() {
        int[] sequence = new int[] { 1, 3, 2 }; // Test 2
        boolean actual = almostIncreasingSequence(sequence);
        assertEquals(true, actual);

        sequence = new int[] {10, 1, 2, 3, 4, 5};  // Test 5
        actual = almostIncreasingSequence(sequence);
        assertEquals(true, actual);

        sequence = new int[] {0, -2, 5, 6};  // Test 7
        actual = almostIncreasingSequence(sequence);
        assertEquals(true, actual);

        sequence = new int[] { 1, 2, 3, 4, 3, 6 };  // Test 14
        actual = almostIncreasingSequence(sequence);
        assertEquals(true, actual);

        sequence = new int[] { 1, 2, 3, 4, 99, 5, 6 };  // Test 15
        actual = almostIncreasingSequence(sequence);
        assertEquals(true, actual);

        sequence = new int[] { 3, 5, 67, 98, 3 };  // Test 17
        actual = almostIncreasingSequence(sequence);
        assertEquals(true, actual);
    }

    @Test
    public void sequenceWithTwoOrMoreAnomaliesIsNotIncreasing() {
        int[] sequence = new int[] {1, 3, 2, 1}; // Test 1
        boolean actual = almostIncreasingSequence(sequence);
        assertEquals(false, actual);

        sequence = new int[] { 1, 4, 10, 4, 2 }; // Test 4
        actual = almostIncreasingSequence(sequence);
        assertEquals(false, actual);

        sequence = new int[] { 10, 1, 2, 3, 4, 5, 6, 1 }; // Test 13
        actual = almostIncreasingSequence(sequence);
        assertEquals(false, actual);
    }

    @Test
    public void sequenceWithMoreThanTwoOfSameValueIsNotIncreasing()
    {
        int[] sequence = new int[] {1, 1, 1, 2, 3}; // Test 6
        boolean actual = almostIncreasingSequence(sequence);
        assertEquals(false, actual);

        sequence = new int[] { 1, 2, 5, 5, 5 }; // Test 12
        actual = almostIncreasingSequence(sequence);
        assertEquals(false, actual);
    }

    @Test
    public void sequenceWithManyNonAdjacentAnomalyIsNotIncreasing() {
        int[] sequence = new int[] {1, 2, 1, 2}; // Test 3
        boolean actual = almostIncreasingSequence(sequence);
        assertEquals(false, actual);

        sequence = new int[] {1, 2, 3, 4, 5, 3, 5, 6}; // Test 8
        actual = almostIncreasingSequence(sequence);
        assertEquals(false, actual);

        sequence = new int[] {40, 50, 60, 10, 20, 30}; // Test 9
        actual = almostIncreasingSequence(sequence);
        assertEquals(false, actual);

        sequence = new int[] {-4, 0, -2, 3, 4, 5, 8, 6, 10}; // Test 9
        actual = almostIncreasingSequence(sequence);
        assertEquals(false, actual);
    }

    @Test
    public void sequenceWithOneNonAdjacentAnomalyIsIncreasing() {
        int[] sequence = new int[] {1, 2, 5, 3, 5}; // Test 11
        boolean actual = almostIncreasingSequence(sequence);
        assertEquals(true, actual);
    }

    @Test
    public void detectionOccursWithinTimeLimit() {
        int[] sequence = new int[100000];
        for (int i = 0; i < sequence.length - 1; i++) {
            sequence[i] = i;
        }
        assertTimeout(Duration.ofMillis(3000), () -> {
            boolean ignored = almostIncreasingSequence(sequence);
        });
    }
}
