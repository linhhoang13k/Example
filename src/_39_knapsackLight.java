package Arcade_Intro;

public class _39_knapsackLight {
    int knapsackLight(int value1, int weight1, int value2, int weight2, int maxW) {
        // Carry both
        if (weight1 + weight2 <= maxW) return value1 + value2;

        // One exceeds, other doesn't
        if (weight1 <= maxW && weight2 > maxW) return value1;
        if (weight2 <= maxW && weight1 > maxW) return value2;

        // None exceeds, but both of them do if added --> take more valuable
        if (weight1 + weight2 > maxW && weight1 <= maxW && weight2 <= maxW) return Math.max(value1, value2);

        // Both too heavy
        return 0;
    }

}
