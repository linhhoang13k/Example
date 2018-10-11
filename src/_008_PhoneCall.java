package Arcade_Core;

public class _008_PhoneCall {
    int phoneCall(int min1, int min2_10, int min11, int s) {
        int minute_counter = 0;
        if (s < min1) return minute_counter;

        // First min
        s -= min1;
        minute_counter++;

        if (s < 9 * min2_10) {
            return minute_counter + s / min2_10;
        }

        // 2-10 min
        minute_counter += 9;
        s -= 9 * min2_10;

        return minute_counter + s / min11;
    }
}
