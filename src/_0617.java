package me.cwuyi;

import java.util.Arrays;

/**
 * Created by xyy on 2017/6/17.
 */
public class _0617 {
    public static void main(String[] args) {
//        System.out.println(trailingZeroes(1808548329));
        System.out.println(titleToNumber("AA"));
    }



    public static int trailingZeroes(int n) {
        int fiveCount = 0;
        for(long i = 5; n/i > 0; i*=5) {
            fiveCount += (n/i);
        }
        return fiveCount;
    }

    public static String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();

        while(n > 0) {
            n--;
            sb.insert(0, (char)('A' + n % 26));
            n = n / 26;
        }
        return sb.toString();
    }

    public static int titleToNumber(String s) {
        int ret = 0;
        int radix = 1;

        for(int i = s.length() - 1; i >= 0; i--) {
            ret += ((s.charAt(i) - 'A' + 1) * radix);
            radix *= 26;
        }
        return ret;
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int[][] record = new int[nums1.length][nums2.length];
        for(int i = 0; i < record.length; i++) {
            Arrays.fill(record[i], -1);
        }

        for(int i = 0; i < nums1.length; i++) {
            for(int j = 0; j < nums2.length; j++) {
                if(nums1[i] == nums2[j]) {

                }
            }
        }



        return null;
    }


}
