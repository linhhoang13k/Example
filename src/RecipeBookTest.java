package com.paigeruppel.interviewpractice.hashtables;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class RecipeBookTest {

	private RecipeBook underTest;

	@Before
	public void setup() {
		underTest = new RecipeBook();
	}

	@Test
	public void shouldReturnSortedByCommonIngredientsTestCase1() {
		String[][] dishes = { { "Salad", "Tomato", "Cucumber", "Salad", "Sauce" },
				{ "Pizza", "Tomato", "Sausage", "Sauce", "Dough" }, { "Quesadilla", "Chicken", "Cheese", "Sauce" },
				{ "Sandwich", "Salad", "Bread", "Tomato", "Cheese" } };
		String[][] sorted = { { "Cheese", "Quesadilla", "Sandwich" }, { "Salad", "Salad", "Sandwich" },
				{ "Sauce", "Pizza", "Quesadilla", "Salad" }, { "Tomato", "Pizza", "Salad", "Sandwich" } };
		assertThat(underTest.groupingDishes(dishes), is(sorted));
	}

	@Test
	public void shouldReturnSortedByCommonIngredientsTestCase2() {
		String[][] dishes = { { "Pasta", "Tomato Sauce", "Onions", "Garlic" },
				{ "Chicken Curry", "Chicken", "Curry Sauce" }, { "Fried Rice", "Rice", "Onions", "Nuts" },
				{ "Salad", "Spinach", "Nuts" }, { "Sandwich", "Cheese", "Bread" },
				{ "Quesadilla", "Chicken", "Cheese" } };
		String[][] sorted = { { "Cheese", "Quesadilla", "Sandwich" }, { "Chicken", "Chicken Curry", "Quesadilla" },
				{ "Nuts", "Fried Rice", "Salad" }, { "Onions", "Fried Rice", "Pasta" } };
		assertThat(underTest.groupingDishes(dishes), is(sorted));
	}

	@Test
	public void shouldReturnEmptyListWithNoRepeatIngredientsTestCase3() {
		String[][] dishes = { { "Pasta", "Tomato Sauce", "Onions", "Garlic" },
				{ "Chicken Curry", "Chicken", "Curry Sauce" }, { "Fried Rice", "Rice", "Onion", "Nuts" },
				{ "Salad", "Spinach", "Nut" }, { "Sandwich", "Cheese", "Bread" },
				{ "Quesadilla", "Chickens", "Cheeseeee" } };
		String[][] sorted = {};
		assertThat(underTest.groupingDishes(dishes), is(sorted));
	}
}
