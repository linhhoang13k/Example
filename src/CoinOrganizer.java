package com.paigeruppel.interviewpractice.hashtables;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CoinOrganizer {

    /* Make the hash table's keys the possible sums (or a set containing the possible sums).
    Start empty, and add new coins to it.
    When adding a new coin, you only need to consider the results you get from adding coins
    to a previous possible result.*/

    public int possibleSums(int[] coins, int[] quantity) {
        HashSet<Integer> uniqueSums = new HashSet<Integer>();
        uniqueSums.add(0); // start with 0 so that the initial set has a value

        for(int i=0; i < coins.length; i++) {
            int coin = coins[i];
            HashSet<Integer> currentSums = new HashSet<Integer>();
            for(Integer sum : uniqueSums) {
                for(int j = 1; j <= quantity[i]; j++) {
                    currentSums.add(sum + coin*j);
                }
            }
            uniqueSums.addAll(currentSums);
        }

        uniqueSums.remove(0); // remove the 0 used to initialize the set
        int numberUniqueSums = uniqueSums.size();
        return numberUniqueSums;
    }

}
