package com.codefights;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by miztli on 10/06/17.
 */
public class ProCategorization {
    public static String[][][] proCategorization(String[] pros, String[][] preferences) {
        TreeMap<String, List<String>> result = new TreeMap<>();
        for(int i=0; i<pros.length; i++) {
            for (int j = 0; j < preferences[i].length; j++) {
                if(result.containsKey(preferences[i][j])){
                    result.get(preferences[i][j]).add(pros[i]);
                }else{
                    List<String> proList = new ArrayList<>();
                    proList.add(pros[i]);
                    result.put(preferences[i][j], proList);
                }
            }
        }
        String[][][] resultArray = new String[result.entrySet().size()][2][];
        int index=0;
        for(Map.Entry<String, List<String>> entry : result.entrySet()){
            resultArray[index][0] = new String[]{entry.getKey()};
            resultArray[index][1] = new String[entry.getValue().size()];
            resultArray[index][1] = entry.getValue().toArray(new String[entry.getValue().size()]);
            index++;
        }
        return resultArray;

    }

    public static void main(String[] args) {
        String[] pros = new String[] {"Jack", "Leon", "Maria"};
        String[][] preferences = new String[][]{
                {"Computer repair", "Handyman", "House cleaning"},
                {"Computer lessons", "Computer repair", "Data recovery service"},
                {"Computer lessons", "House cleaning"}
        };

        String[][][] result = proCategorization(pros, preferences);
        System.out.println("Result array: ");
        for (int i = 0; i<result.length; i++){
            System.out.print("{"+result[i][0][0]+"},{");
            for(int j=0; j<result[i][1].length; j++){
                System.out.print(result[i][1][j]);
                System.out.print(",");
            }
            System.out.println("}");
        }
    }
}
