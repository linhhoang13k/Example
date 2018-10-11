package me.cwuyi;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Created by xyy on 2017/6/28.
 * 2147483646
 * 2147483647
 */
public class _0628 {

    public static void main(String[] args) {

        long s = System.currentTimeMillis();
//        System.out.println(rangeBitwiseAnd(2147483646, 2147483647));
        System.out.println(add(123, 456));
        System.out.println("time cost: " + (System.currentTimeMillis() - s) + " ms");
    }

    public int numIslands(char[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    numIslandsHelper(grid, i, j);
                    res++;
                }
            }
        }
        return 0;
    }

    private void numIslandsHelper(char[][] grid, int from1, int from2) {
        if (from1 < 0 || from2 < 0 || from1 >= grid.length || from2 >= grid[from1].length) return;
        if (grid[from1][from2] == '0') return;
        grid[from1][from2] = '0';
        numIslandsHelper(grid, from1-1, from2);
        numIslandsHelper(grid, from1+1, from2);
        numIslandsHelper(grid, from1, from2-1);
        numIslandsHelper(grid, from1, from2+1);
    }

    public static int rangeBitwiseAnd(int m, int n) {
        int res = m;
        int fromRadix = 0;
        int toRadix = 0;

        while (fromRadix < 32 && (1 << fromRadix) <= m) {
            fromRadix++;
        }
        toRadix = fromRadix;
        fromRadix--;
        while (toRadix < 32 && (1 << toRadix) <= n) {
            toRadix++;
        }

        if (toRadix - fromRadix > 1) return 0;

        for (int i = m; i <= n; i++) {
            res &= i;
            if (i == Integer.MAX_VALUE) break;
        }

        return res;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] in = new int[numCourses];
        LinkedList<Integer> zeroInList = new LinkedList<>();

        int left = numCourses;

        for (int i = 0; i < numCourses; i++) {
            int temp = 0;
            for (int j = 0; j < numCourses; j++) {
                temp += prerequisites[j][i];
            }
            in[i] = temp;
            if (temp == 0) zeroInList.offer(i);
        }


        while (!zeroInList.isEmpty()) {
            int next = zeroInList.poll();
            for (int i = 0; i < numCourses; i++) {
                if (prerequisites[next][i] == 1) {
                    in[i]--;
                    if (in[i] == 0) {
                        zeroInList.offer(i);
                    }
                }
                prerequisites[next][i] = 0;
            }
            left--;
        }

        if (left == 0) return true;
        return false;
    }

    public static int add(int num1,int num2) {

        while(num2 != 0) {
            int temp = (num1 ^ num2);
            num2 = (num1&num2) << 1;
            num1 = temp;
        }
        return num1;
    }

}
