package com.ab.cf.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.ab.cf.hashtable.GroupingDishes;

public class GroupingDishesTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGroupingDishes1() {

		GroupingDishes gd = new GroupingDishes();

		String[][] dishes = { { "Salad", "Tomato", "Cucumber", "Salad", "Sauce" },
				{ "Pizza", "Tomato", "Sausage", "Sauce", "Dough" }, { "Quesadilla", "Chicken", "Cheese", "Sauce" },
				{ "Sandwich", "Salad", "Bread", "Tomato", "Cheese" } };

		String[][] expected = { { "Cheese", "Quesadilla", "Sandwich" }, { "Salad", "Salad", "Sandwich" },
				{ "Sauce", "Pizza", "Quesadilla", "Salad" }, { "Tomato", "Pizza", "Salad", "Sandwich" } };
		Assert.assertArrayEquals(expected, gd.groupingDishes(dishes));
	}

	@Test
	public void testGroupingDishes4() {

		GroupingDishes gd = new GroupingDishes();
		String[][] dishes = { { "First", "a", "b", "c", "d", "e", "f", "g", "h", "i" },
				{ "Second", "i", "h", "g", "f", "e", "x", "c", "b", "a" } };

		String[][] expected = { { "a", "First", "Second" }, { "b", "First", "Second" }, { "c", "First", "Second" },
				{ "e", "First", "Second" }, { "f", "First", "Second" }, { "g", "First", "Second" },
				{ "h", "First", "Second" }, { "i", "First", "Second" } };

		Assert.assertArrayEquals(expected, gd.groupingDishes(dishes));

	}

}
