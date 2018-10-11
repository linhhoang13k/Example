package com.paigeruppel.codefights.challenges;

import java.util.*;

public class NthSmallestInteger {


    public int findNthSmallestMultiple(int[] a, int n) {
        Set s = new TreeSet<Integer>();
        int i = 1;
        for (int c : a) {
            i = 1;
            while (i < n)
                s.add(c * i++);
        }
        return (int) s.toArray()[n - 1];
    }
}
