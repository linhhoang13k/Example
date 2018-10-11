package arcade.islandofknowledge;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AvoidObstaclesTest {

    @Test
    public void ObstaclesAreAdjacent_LowEndOfRange_TwoObstacles() {
        int[] inputArray = new int[] { 2, 3 };
        assertEquals(4, avoidObstacles(inputArray));
    }

    @Test
    public void ObstaclesAreAdjacent_LowEndOfRange_ThreeObstacles() {
        int[] inputArray = new int[] { 2, 3, 4 };
        assertEquals(5, avoidObstacles(inputArray));
    }

    @Test
    public void ObstaclesAreNotAdjacent() {
        int[] inputArray = new int[] {5, 3, 6, 7, 9};
        assertEquals(4, avoidObstacles(inputArray));
    }

    @Test
    public void ArrayIsSorted_ObstaclesAreAdjacent_HighEndOfRange_TwoObstacles() {
        int[] inputArray = new int[] { 9, 10 };
        assertEquals(4, avoidObstacles(inputArray));
    }

    @Test
    public void ManyObstacles_SingleJump() {
        int[] inputArray = new int[] {1, 4, 10, 6, 2};
        assertEquals(7, avoidObstacles(inputArray));
    }

    @Test
    public void InputRangeIsUpTo40() {
        int[] inputArray = new int[] {1, 2,  5, 7, 13, 16, 20, 22, 23, 24, 25, 30, 33, 35, 39, 40 };
        assertEquals(9, avoidObstacles(inputArray));
    }

    private int avoidObstacles(int[] inputArray) {
        List<Integer> obstacles = Arrays.stream(inputArray).boxed().collect(Collectors.toList());

        int jumpLength = 2;
        while (jumpLength <= 40) {
            if (!anyObstacles(obstacles, jumpLength)) return jumpLength;
            jumpLength++;
        }
        return jumpLength;
    }

    private boolean anyObstacles(List<Integer> obstacles, int jumpLength) {
        int currentPosition = jumpLength;
        while (currentPosition <= 40) {
            if (obstacles.contains(currentPosition)) return true;
            currentPosition += jumpLength;
        }
        return false;
    }
}
