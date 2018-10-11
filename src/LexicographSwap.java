package com.paigeruppel.interviewpractice.hashtables;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class LexicographSwap {
    private int[] parent;
    private int count;

    public String swapLexOrder(String str, int[][] pairs) {
        // build all connected indices
        Arrays.sort(pairs[0]);
        for (int[] i : pairs) {
           int root = i[0];
           int branch = i[1];


        }
        return "dbca";
    }


//    public LexicographSwap(int n) {
//        parent = new int[n];
//        count = n;
//        for (int i = 0; i < n ; i++) {
//            parent[i] = i;
//        }
//    }
//
//    public int getCount() {
//        return count;
//    }
//
//    public int find(int p) {
//        validate(p);
//        while (p != parent[p]) {
//            p = parent[p];
//        }
//        return p;
//    }
//
//    private void validate(int p) {
//        int n = parent.length;
//        if (p < 0 || p >= n){
//            return;
//        }
//    }
//
//    public boolean connected(int p, int q) {
//        return find(p)== find(q);
//    }
//
//    public void union(int p, int q) {
//        int rootP = find(p);
//        int rootQ = find(q);
//        if (rootP == rootQ) return;
//        parent[rootP] = rootQ;
//        count--;
//    }
//



}
