package Arcade_Core;

public class _032_rounders {
    int rounders(int value) {
        int decimalMultiplier = 1;
        while (value >= 10) {
            decimalMultiplier *= 10;
            int r = 0;
            if (value % 10 >= 5)
                r = 1;
            value /= 10;
            value += r;
        }
        return decimalMultiplier * value;
    }
}
