package com.paigeruppel.codefights.challenges;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class KitchenPlannerTest {

    KitchenPlanner underTest;

    @Before
    public void setup() {
        underTest = new KitchenPlanner();
    }

    @Test
    public void chefsWithEqualValuesForOneFoodShouldBeDeterminedBySecondFood() {
        String[] chefs = {"Jack", "Jeanne"};
        String[] food = {"Pasta", "Chicken"};
        int[][] values = {{3, 6}, {3, 4}};
        String[] answer = {"Jack - Chicken", "Jeanne - Pasta"};
        assertArrayEquals(answer, underTest.areYouHungary(chefs, food, values));
    }

    @Test
    public void inputWithOneFoodAndThreeChefsShouldPreferenceHighestValueAndAddNothingForOthers() {
        String[] chefs = {"Hayley", "Amy", "Brendan"};
        String[] food = {"Salad"};
        int[][] values = {{5}, {8}, {-1}};
        String[] answer = {"Hayley - Nothing", "Amy - Salad", "Brendan - Nothing"};
        assertArrayEquals(answer, underTest.areYouHungary(chefs, food, values));
    }

    @Test
    public void shouldReturnImpossibleIfNoChefCanMakeOneFood() {
        String[] chefs = {"Jeff", "Dalia"};
        String[] food = {"Dessert", "Tea"};
        int[][] values = {{7, -1}, {5, -1}};
        String[] answer = {"Impossible"};
        assertArrayEquals(answer, underTest.areYouHungary(chefs, food, values));
    }

}

