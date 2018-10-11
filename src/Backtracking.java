package com.taidev198.game.CodingInterview.Backtraking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author traig on 7/26/2018.
 * @project Codefights
 */
public class Backtracking {

    static void climbingStaircase(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> chosen = new ArrayList<>();
        climbingStaircaseHelper( n,  k,  chosen,  result);
        int[][] answer = new int[result.size()][];

        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i).stream().mapToInt(Integer::intValue).toArray();
            for (int j = 0; j < answer[i].length; j++) {
                System.out.print(answer[i][j] +"  ");
            }
            System.out.println();
        }


    }

    static void climbingStaircaseHelper(int n, int k, List<Integer> chosen, List<List<Integer>> result){

        if(n == 0){
            System.out.println("add");
            result.add(chosen);
        }else{
            for(int i = 1; i<= k; i++){
                if(n - i >=0){
                    chosen.add(i);
                    climbingStaircaseHelper(n -i, k, chosen, result);
                    chosen.remove(chosen.size() -1);//backtracking
                }
            }
        }


    }

    public static void main(String...args){

        climbingStaircase(7,2);
       // System.out.println("thanh tai nguyen");

    }
}
