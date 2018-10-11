package evg.codefights.core;

public class LoopTunnel {

    public static void main(String[] args) {

    }

    int leastFactorial(int n) {
        long res = 1;
        for(int i = 1; i <= n; i++) {
            res *= i;
            if (res >= n) {
                return (int) res;
            }
        }
        return 0;
    }

    int countSumOfTwoRepresentations2(int n, int l, int r) {
        int res = 0;
        for(int i = l; i <= r; i++) {
            int t = n - i;
            if (t >= i && t <= r) {
                res++;
            }
        }
        return res;
    }

    int magicalWell(int a, int b, int n) {
        int res = 0;
        for(int i = 0; i < n; i++) {
            res += a*b;
            a++;
            b++;
        }
        return res;
    }

    int lineUp(String commands) {
        int res = 0;
        int state1 = 0;
        int state2 = 0;
        for(int i = 0; i < commands.length(); i++) {
            char ch = commands.charAt(i);
            if (ch == 'L') {
                if (state1 == 0) {
                    state1 = 3;
                } else {
                    state1--;
                }
                state2++;
            } else if (ch == 'R') {
                if (state2 == 0) {
                    state2 = 3;
                } else {
                    state2--;
                }
                state1++;
            } else {
                state1 += 2;
                state2 += 2;
            }
            state1 %= 4;
            state2 %= 4;
            if (state1 == state2) {
                res++;
            }
        }
        return res;
    }

    boolean increaseNumberRoundness(int n) {
        while (n != 0) {
            if (n % 10 != 0) {
                break;
            }
            n /= 10;
        }
        while (n != 0) {
            int b = n % 10;
            if (b == 0) {
                return true;
            }
            n /= 10;
        }
        return false;
    }

    int candles(int candlesNumber, int makeNew) {
        int res = candlesNumber;
        int left = candlesNumber;

        while (left >= makeNew) {
            res += left / makeNew;
            left = left % makeNew + left / makeNew;
        }
        return res;
    }

    int countBlackCells(int n, int m) {
        return n + m - gcd(n, m) + (gcd(n,m) - 1) * 2;
    }

    int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }




}
