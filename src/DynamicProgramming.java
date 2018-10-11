package CodeFight;

import java.util.Arrays;

public class DynamicProgramming {

    public int knapsack(int[] weight, int[] val, int capacity){
        int[][] cache = new int[weight.length][capacity+1];
        for(int[] arr:cache)
            Arrays.fill(arr,-1);
        return knapsackHelper(weight,val,val.length-1,capacity,cache);
    }

    private int knapsackHelper(int[] weight, int[] val, int choice, int remainCapacity,int[][] cache){

        if(choice<0 || remainCapacity<=0)
            return 0;
        if(weight[choice]>remainCapacity)
            return knapsackHelper(weight,val,choice-1,remainCapacity,cache);

        if (cache[choice][remainCapacity]!=-1)
            return cache[choice][remainCapacity];

        int chooseValue = val[choice]+knapsackHelper(weight,val,choice-1,remainCapacity-weight[choice],cache);
        int unchooseValue = knapsackHelper(weight,val,choice-1,remainCapacity,cache);
        cache[choice][remainCapacity] = Math.max(chooseValue,unchooseValue);
        return cache[choice][remainCapacity];
    }
}
