package me.cwuyi;

import java.util.Queue;

/**
 * Created by xyy on 2017/7/2.
 */
public class LCContest39 {

    public static void main(String[] args) {
        System.out.println(findDerangement(12323));
//        System.out.println(Math.sqrt(4) % 1 == 0);
    }

    public static boolean judgeSquareSum(int c) {
        int one = 0;
        int another = c - one * one;

        while (one <= another) {
            if (Math.sqrt(another) % 1 == 0) {
                return true;
            }
            one++;
            another = c - one * one;
        }
        return false;
    }

    public static int findDerangement(int n) {
        if (n >= 1000000007) return (-2 % 1000000007);
        long ret = 1;
        for (long i = 1; i <= n; i++) {
            ret = ((ret % 1000000007) * (i % 1000000007)) % 1000000007;
        }
        return (int)(ret - (2 % 1000000007));
    }


}
