package com.il.amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by cesaregb on 7/17/17.
 */
public class TestCase2 {
  public static void main(String[] args) {
    String[][] lunchMenuPairs = new String[][]{
            {"Pizza","Italian"},
            {"Curry","Indian"},
            {"Masala","Indian"}
    };
    String[][] teamCuisinePreference = new String[][]{
            {"Jose", "Italian"},
            {"John", "Indian"},
            {"Sarah", "Thai"},
            {"Mary", "*"}
    };

    String[][] result = matchLunches(lunchMenuPairs, teamCuisinePreference);
    for (String[] a : result){
        System.out.println(a[0] + " " + a[1]);
    }
  }

  public static String[][] matchLunches(String[][] lunchMenuPairs, String[][] teamCuisinePreference) {
    HashMap<String, List<String>> menuHash = new HashMap<>();
    List<String> allFood = new ArrayList<>();
    for (int i = 0; i < lunchMenuPairs.length; i++) {
      menuHash.putIfAbsent(lunchMenuPairs[i][1], new ArrayList<>());
      menuHash.get(lunchMenuPairs[i][1]).add(lunchMenuPairs[i][0]);
      allFood.add(lunchMenuPairs[i][0]);
    }


    HashMap<String, List<String>> resultMap = new HashMap<>();
    int size = 0;
    for (int i = 0; i < teamCuisinePreference.length; i++) {
      final String name = teamCuisinePreference[i][0];
      final String type = teamCuisinePreference[i][1];
      if (menuHash.containsKey(type) || type.equalsIgnoreCase("*")){
        resultMap.putIfAbsent(name, new ArrayList<>());
        if (!type.equalsIgnoreCase("*")){
          size += menuHash.get(type).size();
          resultMap.get(name).addAll(menuHash.get(type));
        }else {
          size += allFood.size();
          resultMap.get(name).addAll(allFood);
        }
      }
    }
    String[][] result = new String[size][2];
    int i = 0;
    for (String k : resultMap.keySet()) {
      for(String food : resultMap.get(k)){
        result[i][0] = k;
        result[i][1] = food;
        i++;
      }
    }
    return result;

  }
}
