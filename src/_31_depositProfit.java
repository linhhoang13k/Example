package Arcade_Intro;

public class _31_depositProfit {
    int depositProfit(int deposit, int rate, int threshold) {
        return (int)Math.ceil(Math.log((double)threshold / deposit) / Math.log(1 + rate / 100.0));
    }
}
