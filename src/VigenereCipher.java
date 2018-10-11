package com.codefights.challenges;

/**
 * Created by zambro on 7/4/17.
 */
public class VigenereCipher {

    static  String incrementCipher(String s, int[] n) {
        char[] x = s.toCharArray();
        for(int i=0;i<n.length;i++)
            for(int j=n[i]-1;j<x.length;j=n[i]+j)
                x[j] = x[j] == 'z' ? 'a': (char)(x[j]+1);
//         if(x[j] == 'z')
//             x[j] = 'a';
//         else
//             x[j] += 1;

        return new String(x);
    }



    public static void main(String[] args) {
        System.out.println(incrementCipher("zzzzzzzzzz", new int[]{2,4,6}));
    }
}
