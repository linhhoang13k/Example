package com.paigeruppel.codefights.challenges;

public class ExponentComparison {

    /*

    Let A = a^(b^(c^d)) and B = x^(y^(z^t)).
    You have to compare A and B.

    a --> d ==> m[0] --> m[3]
    */

    public int compare2Power(int[] m) {
        double cd = Math.pow(m[2], m[3]);
        double zt = Math.pow(m[6], m[7]);
        if (cd == zt) {
            return 0;
        }
        return (cd > zt) ? 1 : -1;
    }
}
