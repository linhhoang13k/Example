package me.cwuyi;


import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by xyy on 2017/6/1.
 */
public class _0601 {
    public static void main(String[] args) {
//        System.out.println(lengthOfLongestSubstring("dvdf"));
//        System.out.println(longestPalindrome(""));
        System.out.println(largestNumber(new int[]{2, 1}));
    }

    public static int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) return 0;
        int h = 0;
        int ret = 0;

        for(int i = h; i < s.length(); i++) {
            int index = s.substring(0, i).indexOf(s.charAt(i), h);
            if(index != -1) {
                ret = ret > i-h ? ret : i-h;
                h = index + 1;
            }
        }

        return ret > s.length()-h ? ret : s.length()-h;
    }

    public static String longestPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i = s.length()-1; i >= 0; i--) {
            sb.append(s.charAt(i));
        }
        return lcs(s, sb.toString());
    }

    public static String lcs(String s1, String s2) {
        int[][] retArray = new int[s1.length()][s2.length()];
        int maxLength = 0;
        int endToS1 = -1;

        for(int i = 0; i < s1.length(); i++) {
            Arrays.fill(retArray[i], 0);
        }
        for(int i = 0; i < s1.length(); i++) {
            for(int j = 0; j < s2.length(); j++) {
                if(s1.charAt(i) == s2.charAt(j)) {
                    if(i == 0 || j == 0) {
                        retArray[i][j] = 1;
                    } else {
                        retArray[i][j] = retArray[i-1][j-1] + 1;
                    }
                }
                if(retArray[i][j] > maxLength) {
                    if(retArray[i][j] == s1.length() || isPalindrome(s1.substring(i - retArray[i][j] + 1, i + 1))){
                        maxLength = retArray[i][j];
                        endToS1 = i;
                    }
                }
            }
        }

        return s1.substring(endToS1 - maxLength + 1, endToS1 + 1);
    }

    public static boolean isPalindrome(String s) {
        for(int i = 0; i < s.length()/2; i++) {
            if(s.charAt(i) != s.charAt(s.length()-i-1)) {
                return false;
            }
        }
        return true;
    }

    public static String largestNumber(int[] nums) {
        if(nums == null || nums.length == 0) return "";
        StringBuilder sb = new StringBuilder();
        String[] strS = new String[nums.length];
        for(int i = 0; i < nums.length; i++) {
            strS[i] = nums[i] +  "";
        }
        Arrays.sort(strS, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String s1 = o1 + o2;
                String s2 = o2 + o1;
                return s1.compareTo(s2);
            }
        });

        if(strS[strS.length-1].charAt(0) == '0') return "0";

        for(String str : strS) {
            sb.insert(0,str);
        }
        return sb.toString();
    }

}
