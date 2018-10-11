package Arcade_Core;

public class _025_LeastFactorial {
    int leastFactorial(int n) {
        int k = 1, c = 1;
        while (k < n) k *= c++;
        return k;
    }
}
