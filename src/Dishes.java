package hashtables;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class Dishes {
  static String[][] groupingDishes(String[][] dishes) {
    Map<String, TreeMap<String, Integer>> dishMap = new TreeMap<>();
    for (String[] dish :
        dishes) {
      String dishName = dish[0];
      for (int i = 1; i < dish.length; i++) {
        if(dishMap.containsKey(dish[i]) && !dishMap.get(dish[i]).containsKey(dishName)) {
          dishMap.get(dish[i]).put(dishName, 1);
        } else {
          TreeMap<String, Integer> usedIn = new TreeMap<>();
          usedIn.put(dishName, 0);
          dishMap.put(dish[i], usedIn);
        }
      }
    }

    ArrayList<String> toDelete = new ArrayList<>();
    dishMap.forEach((key, value) -> {
      if(value.size() < 2)
        toDelete.add(key);
    });
    dishMap.keySet().removeAll(toDelete);
    String[] keys = dishMap.keySet().toArray(new String[0]);
    String[][] mappings = new String[keys.length][];
    for(int i = 0; i < keys.length; i++) {
      String[] s = dishMap.get(keys[i]).keySet().toArray(new String[0]);
      mappings[i] = new String[s.length+1];
      mappings[i][0] = keys[i];
      for(int j = 1; j <= s.length; j++) {
        mappings[i][j] = s[j-1];
      }
    }
    return mappings;
  }

  public static void main(String[] args) {
    String[][] dishes = {{"Salad", "Tomato", "Cucumber", "Salad", "Sauce"},
        {"Pizza", "Tomato", "Sausage", "Sauce", "Dough"},
        {"Quesadilla", "Chicken", "Cheese", "Sauce"},
        {"Sandwich", "Salad", "Bread", "Tomato", "Cheese"}};

    dishes = groupingDishes(dishes);
    System.out.println("Done");
  }
}
