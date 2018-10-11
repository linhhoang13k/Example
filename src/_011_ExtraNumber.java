package Arcade_Core;

public class _011_ExtraNumber {
    int extraNumber(int a, int b, int c) {
        if (a == b) return c;
        if (a == c) return b;
        return a;
    }

    int extraNumber2(int a, int b, int c) {
        return a == b ? c : a == c ? b : a;
    }


    int extraNumber3(int a, int b, int c) {
        return a ^ b ^ c;
    }
}
