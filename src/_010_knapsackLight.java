package Arcade_Core;

public class _010_knapsackLight {
    int knapsackLight(int value1, int weight1, int value2, int weight2, int maxW) {
        int val = 0;

        if (weight1 + weight2 <= maxW) return value1 + value2;

        if (weight1 <= maxW) {val = value1;}

        if (weight2 <= maxW && value2 > val) val = value2;

        return val;

    }
}
