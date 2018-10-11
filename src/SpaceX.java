package com.taidev198.game.CodingInterview.Companies.SpaceX;

public class SpaceX {


    static boolean launchSequenceChecker(String[] systemNames, int[] stepNumbers) {
        int n = systemNames.length;
        int i= 0;
        while (i < n -1){
            int j = i;
            String temp = systemNames[i];
            int k = n -1;
            while(j < k){
                if(!systemNames[k].equals(temp))
                    k--;
                else{
                    if(stepNumbers[j] >= stepNumbers[k])
                        return false;
                    j++;
                }
            }
            i++;
        }
        return true;
    }

    public static void main(String...args){

        System.out.println("thanh tai nguyen");
    }
}
