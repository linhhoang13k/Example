package com.paigeruppel.interviewpractice.hashtables;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class RecipeBook {

	public String[][] groupingDishes(String[][] dishes) {

		List<String> repeatIngredients = buildRepeatIngredientList(dishes);

		Collections.sort(repeatIngredients);
		Map<String, String> ingredientMap = buildIngredientMap(dishes, repeatIngredients);

		String[][] sorted = new String[repeatIngredients.size()][];

		for (int i = 0; i < repeatIngredients.size(); i++) {
			String ingredient = repeatIngredients.get(i);
			String value = ingredientMap.get(ingredient);
			String[] recipes = value.split(",");
			Arrays.sort(recipes);
			String[] complete = new String[recipes.length + 1];
			complete[0] = ingredient;
			for (int j = 1; j < complete.length; j++) {
				complete[j] = recipes[j - 1];
			}
			sorted[i] = complete;
		}
		return sorted;
	}

	private List<String> buildRepeatIngredientList(String[][] dishes) {
		Set<String> allIngredients = new HashSet<>();
		List<String> repeatIngredients = new ArrayList<>();
		for (int dish = 0; dish < dishes.length; dish++) {
			for (int ingredient = 1; ingredient < dishes[dish].length; ingredient++) {
				String currentIngredient = dishes[dish][ingredient];
				if (allIngredients.contains(currentIngredient) && !repeatIngredients.contains(currentIngredient)) {
					repeatIngredients.add(currentIngredient);
				}
				allIngredients.add(currentIngredient);
			}
		}
		return repeatIngredients;
	}

	private Map<String, String> buildIngredientMap(String[][] dishes, List<String> repeatIngredients) {
		Map<String, String> ingredientMap = new HashMap<>();
		for (int dish = 0; dish < dishes.length; dish++) {
			for (int ingredient = 1; ingredient < dishes[dish].length; ingredient++) {
				String currentDish = dishes[dish][0];
				String currentIngredient = dishes[dish][ingredient];
				if (repeatIngredients.contains(currentIngredient)) {
					if (ingredientMap.containsKey(currentIngredient)) {
						String currentValue = ingredientMap.get(currentIngredient);
						String newValue = currentValue + "," + currentDish;
						ingredientMap.put(currentIngredient, newValue);
					} else {
						ingredientMap.put(currentIngredient, currentDish);
					}
				}
			}
		}
		return ingredientMap;
	}
}
