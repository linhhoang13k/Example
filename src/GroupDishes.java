package edu.learning.codefights.hashtable;

import java.util.AbstractMap.SimpleImmutableEntry;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by duchuunguyen on 8/23/17.
 */
public class GroupDishes {
    public static String[][] groupingDishes(String[][] dishes) {
        List<Map.Entry<String, String>> list = Arrays.stream(dishes)
                .map(dish -> toEntries(dish))
                .flatMap(Collection::stream).collect(Collectors.toList());

        Map<String, List<String>> map = new HashMap<>();
        for (Map.Entry<String, String> entry : list) {
            if (!map.containsKey(entry.getKey())) {
                map.put(entry.getKey(), new ArrayList<>());
            }
            map.get(entry.getKey()).add(entry.getValue());
        }
        String[][] result = map.entrySet().stream()
                .map(entry -> toArray(entry))
                .filter(arr -> arr.length > 2)
                .collect(Collectors.toList())
                .toArray(new String[0][0]);
        Arrays.sort(result, Comparator.comparing(e -> e[0]));
        return result;
    }

    public static String[] toArray(Map.Entry<String, List<String>> entry) {
        List<String> list = new ArrayList<>(Arrays.asList(entry.getKey()));
        List<String> dishes = entry.getValue();
        dishes.sort(String::compareTo);
        list.addAll(dishes);

        return list.toArray(new String[0]);
    }

    public static List<Map.Entry<String, String>> toEntries(String[] dish) {
        if (dish == null || dish.length == 0) {
            return new ArrayList<>();
        }
        List<Map.Entry<String, String>> entries = new ArrayList<>();
        for (int i = 1; i < dish.length; i++) {
            entries.add(new AbstractMap.SimpleEntry<>(dish[i], dish[0]));
        }
        return entries;
    }

    public static void main(String[] args) {
        String[][] dishes = new String[][]{{"Pasta", "Tomato Sauce", "Onions", "Garlic"},
                {"Chicken Curry", "Chicken", "Curry Sauce"},
                {"Fried Rice", "Rice", "Onions", "Nuts"},
                {"Salad", "Spinach", "Nuts"},
                {"Sandwich", "Cheese", "Bread"},
                {"Quesadilla", "Chicken", "Cheese"}};
        String[][] groupedDishes = groupingDishes(dishes);
        System.out.println();
    }
}
