package me.cwuyi;

import java.util.Scanner;

/**
 * Created by XIA on 2017/7/6.
 */
public class NE_2017_1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = Integer.parseInt(in.nextLine());
        int[] caps = new int[num];
        for (int i = 0; i < num; i++) {
            caps[i] = in.nextInt();
        }
        int k = in.nextInt();
        int d = in.nextInt();

        System.out.println(maxHelper(k, d, caps, 0));
    }

    private static int maxHelper(int k, int d, int[] caps, int from) {
        if (from >= caps.length || k <= 0) return 1;
        int max = Integer.MIN_VALUE;
        for (int i = from; i < caps.length && i - from < d; i++) {
            max = Math.max(1*maxHelper(k, d, caps, from+1), caps[from] * maxHelper(k-1, d, caps, from+1));
        }
        return max;
    }
}
