package com.codefight.challanges;

import java.util.Arrays;

public class ProductionSeries {

    public static void main(String args[]){

        String[] result1 = productionSeriesInfo(16, 2, 5,new int[]{1, 1, 2, 1, 2});
        System.out.println("Expected: [\"Ok\"]");
        System.out.println("Actual:");
        Arrays.stream(result1).forEach(System.out::print);
        System.out.println("--------------------------");

        String[] result2 = productionSeriesInfo(25, 1, 2,new int[]{1, 1, 3, 2});
        System.out.println("Expected: [\"Ok\", \"Ingredients for 2 more series\"]");
        System.out.println("Actual:");
        Arrays.stream(result2).forEach(System.out::print);
        System.out.println("--------------------------");

        String[] result3 = productionSeriesInfo(5, 1, 5,new int[]{1, 1, 1, 1, 1});
        System.out.println("Expected: [\"Ok\"]");
        System.out.println("Actual:");
        Arrays.stream(result3).forEach(System.out::print);
        System.out.println("--------------------------");

        String[] result4 = productionSeriesInfo(10,1,10 ,new int[]{1, 2});
        System.out.println("Expected: [\"Out of ingredients!\", \"Missing 1 ingredients\"]");
        System.out.println("Actual:");
        Arrays.stream(result4).forEach(System.out::print);
        System.out.println("--------------------------");

        String[] result5 = productionSeriesInfo(200, 10, 20,new int[]{2, 1, 2, 2, 2, 2, 2, 1, 2, 2});
        System.out.println("Expected: [\"Ok\"]");
        System.out.println("Actual:");
        Arrays.stream(result5).forEach(System.out::print);
        System.out.println("--------------------------");

        String[] result6 = productionSeriesInfo(18, 1, 3,new int[]{3, 3, 3});
        System.out.println("Expected: [\"Ok\", \"Ingredients for 1 more series\"]");
        System.out.println("Actual:");
        Arrays.stream(result6).forEach(System.out::print);
        System.out.println("--------------------------");

        String[] result7 = productionSeriesInfo(30, 9, 2, new int[]{2, 2, 2, 1, 1, 1});
        System.out.println("Expected: [\"Out of ingredients!\", \"Missing 3 ingredients\"]");
        System.out.println("Actual:");
        Arrays.stream(result7).forEach(System.out::print);
        System.out.println("--------------------------");


        String[] result8 = productionSeriesInfo(98, 6, 4, new int[]{3, 2, 1});
        System.out.println("Expected: [\"Ok\", \"Ingredients for 6 more series\"]");
        System.out.println("Actual:");
        Arrays.stream(result8).forEach(System.out::print);
        System.out.println("--------------------------");


        String[] result9 = productionSeriesInfo(100, 50, 25, new int[]{1, 2, 10, 2, 1});
        System.out.println("Expected: [\"Out of ingredients!\", \"Missing 60 ingredients\"]");
        System.out.println("Actual:");
        Arrays.stream(result9).forEach(System.out::print);
        System.out.println("--------------------------");

    }

    static String[] productionSeriesInfo(int i, int r1, int r2, int[] ps) {
        String more = "Ingredients for # more series";
        String less = "Missing # ingredients";
        //Out of ingredients!
        int n =0;
        String[] r = null;
        for(int p : ps){
            switch (p) {
                case 1:
                    n = n + r1;
                    break;
                case 2:
                    n = n + r2;
                    break;
                default:
                    n = n + p;
            }
        }
        int q = i / n;
        if (q == 0) {
            r = new String[2];
            r[0] = "Out of ingredients!";
            int j = i - n;
            r[1] = "Missing " + Math.abs(j)  + " ingredients";
        }else if(q == 1){
            r = new String[1];
            r[0] = "Ok";
        }else if(q > 1){
            r = new String[2];
            r[0] = "Ok";
            r[1] = "Ingredients for " + (q-1) + " more series";
        }
        return r;
    }

}
