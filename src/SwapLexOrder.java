package com.github.chen0040.codefights.hashtables;


import java.util.*;


/**
 * Created by xschen on 4/8/2017.
 */
public class SwapLexOrder {
   public static void main(String[] args) {
      Solution s = new Solution();

      String str = "fixmfbhyutghwbyezkveyameoamqoi";
      int[][] pairs =new int[][] { new int [] {8,5},
              new int [] {10,8},
              new int [] {4,18},
              new int [] {20,12},
              new int [] {5,2},
              new int [] {17,2},
              new int [] {13,25},
              new int [] {29,12},
              new int [] {22,2},
              new int [] {17,11}
      };

      String output = s.swapLexOrder(str, pairs);
      System.out.println(output);
   }
   public static class Solution {
      String swapLexOrder(String str, int[][] pairs) {
         int n = pairs.length;
         if(n == 0){
            return str;
         }

         String result = str;

         List<List<Integer>> permutations = permutate(n);

         for(int k = 0; k < permutations.size(); ++k) {
            char[] a = str.toCharArray();
            Map<String, Set<Integer>> found = new HashMap<String, Set<Integer>>();
            String candidate = str;
            int j = 0;
            List<Integer> pk = permutations.get(k);
            while(true) {

               int pj = pk.get(j);
               exchange(a, pairs[pj][0]-1, pairs[pj][1]-1);
               candidate = new String(a);
               if(candidate.compareTo(result) > 0) {
                  result = candidate;
               }

               if(found.containsKey(candidate) && found.get(candidate).contains(j)) {
                  break;
               }

               if(found.containsKey(candidate)){
                  found.get(candidate).add(j);
               } else {
                  Set<Integer> s = new HashSet<Integer>();
                  s.add(j);
                  found.put(candidate, s);
               }

               j++;
               if(j >= n) j = 0;
            }
         }

         return result;
      }

      void exchange(char[] a, int i, int j) {
         char temp = a[i];
         a[i] = a[j];
         a[j] = temp;
      }

      List<List<Integer>> permutate(int n) {
         List<List<Integer>> set = new ArrayList<List<Integer>>();
         set.add(new ArrayList<Integer>());
         return permutate2(set, 0, n);
      }

      List<List<Integer>> permutate2(List<List<Integer>> set, int d, int n) {
         if(d == n){
            return set;
         }
         List<List<Integer>> newSet = new ArrayList<List<Integer>>();
         for(int i=0; i < set.size(); ++i) {
            List<List<Integer>> newSubSets = generate(set.get(i), d);
            newSet.addAll(newSubSets);
         }
         return permutate2(newSet, d+1, n);
      }

      List<List<Integer>> generate(List<Integer> list, int d) {
         List<List<Integer>> result = new ArrayList<List<Integer>>();
         for(int i=0; i < list.size(); ++i) {
            List<Integer> newList = insert(list, i, d);
            result.add(newList);
         }
         result.add(insert(list, list.size(), d));

         return result;
      }

      List<Integer> insert(List<Integer> list, int index, int d){
         List<Integer> result = new ArrayList<Integer>();
         for(int i=0; i < list.size(); ++i) {
            if(i == index) {
               result.add(d);
            }
            result.add(list.get(i));
         }
         if(index == list.size()) {
            result.add(d);
         }
         return result;
      }
   }
}
