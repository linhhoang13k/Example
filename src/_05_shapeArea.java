package Arcade_Intro;

public class _05_shapeArea {
    int shapeArea(int n) {
        return n == 1 ? 1 : shapeArea(n-1) + 2*n + 2*(n-2);
    }

    int shapeAreaBetter(int n) {
        return (n*n) + ((n-1)*(n-1));
    }
}
