package Arcade_Core;

public class _018_arraypacking {
    int arrayPacking(int[] a) {
        int sum = 0;
        for ( int i = 0 ; i < a.length ; i++)
            sum += Math.pow(2, 8 * i) * a[i];
        return sum;
    }
}
