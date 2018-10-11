package Arcade_Core;

public class _029_AdditionWithoutCarrying {
    int additionWithoutCarrying(int param1, int param2) {
        if (param1 == 0 || param2 == 0) return param1 + param2;
        return additionWithoutCarrying(param1 / 10, param2 / 10) * 10 + (param1 + param2) % 10;
    }
}
