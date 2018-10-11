package Arcade_Core;

public class _016_metrocard {
    int[] metroCard(int lastNumberOfDays) {
        if (lastNumberOfDays == 30) return new int[]{31};
        if (lastNumberOfDays == 28) return new int[]{31};
        return new int[]{28, 30, 31};
    }
}
