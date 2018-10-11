package com.pramp;

/**
 * Created by zambro on 5/21/17.
 *
 * https://www.pramp.com/question/61ojWAjLJbhob2nP2q1O
 *
 * The deletion distance of two strings is the minimum number of characters you need to delete in the two strings
 * in order to get the same string. For instance, the deletion distance between "heat" and "hit" is 3:

 By deleting 'e' and 'a' in "heat", and 'i' in "hit", we get the string "ht" in both cases.
 We cannot get the same string from both strings by deleting 2 letters or fewer.
 Given the strings str1 and str2, write an efficient function deletionDistance that
 returns the deletion distance between them.

 Examples:

 input:  str1 = "dog", str2 = "frog"
 output: 3

 input:  str1 = "some", str2 = "some"
 output: 0

 input:  str1 = "some", str2 = "thing"
 output: 9

 input:  str1 = "", str2 = ""
 output: 0
 */
public class DeletionDistance {

    public static int deletionDistance(String one, String two) {
        if(one == null || one.isEmpty()) {
            return two == null?0:two.length();
        }

        if(two == null || two.isEmpty()) {
            return one == null?0:one.length();
        }

        if(one.charAt(0) == two.charAt(0)) {
            return deletionDistance(one.substring(1, one.length()), two.substring(1, two.length()));
        } else {
            return 1 + Math.min(deletionDistance(one.substring(1,one.length()), two),
                    deletionDistance(one, two.substring(1,two.length())));
        }
    }

    public static int deletionDistanceOptimized(String one, String two) {
        int[][] matrix = new int[one.length()+1][two.length()+1];
        for(int i=0;i<one.length()+1;i++) {
            for(int j=0;j<two.length()+1;j++) {
                if(j==0) {
                    matrix[i][j] = i;
                } else if(i==0) {
                    matrix[i][j] = j;
                } else if(one.charAt(i-1) == two.charAt(j-1)) {
                    matrix[i][j] = matrix[i-1][j-1];
                } else {
                    matrix[i][j] = 1+Math.min(matrix[i-1][j], matrix[i][j-1]);
                }
            }
        }

        return matrix[one.length()][two.length()];
    }

    public static void main(String[] args) {
        System.out.println(deletionDistance("dog",""));
        System.out.println(deletionDistance("","frog"));
        System.out.println(deletionDistance("dog","frog"));
        System.out.println(deletionDistance("some","some"));
        System.out.println(deletionDistance("some","ome"));
        System.out.println(deletionDistance("some","thing"));
        System.out.println(deletionDistance("soie","thing"));
        System.out.println(deletionDistance("car","racer"));

        System.out.println(deletionDistanceOptimized("dog",""));
        System.out.println(deletionDistanceOptimized("","frog"));
        System.out.println(deletionDistanceOptimized("dog","frog"));
        System.out.println(deletionDistanceOptimized("some","some"));
        System.out.println(deletionDistanceOptimized("some","ome"));
        System.out.println(deletionDistanceOptimized("some","thing"));
        System.out.println(deletionDistanceOptimized("soie","thing"));
        System.out.println(deletionDistanceOptimized("car","racer"));
    }
}
