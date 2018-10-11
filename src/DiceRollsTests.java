package com.codefight.williamking.dailychallenges.dicerolls;

public class DiceRollsTests {
	
	public static void runTests() {
		testOne();
		testTwo();
		testThree();
		testFour();
		testFive();
		testSix();
		testSeven();
		testEight();
		
	}
	
	/*
	private static void printArray(int[][] arrayToPrint) {
		for (int i = 0; i < arrayToPrint.length; i++) {
			for (int j = 0; j < arrayToPrint[i].length; j++) {
				
			}
		}
	}
	*/
	
	private static void testOne() {
		int[][] arrayOne = new int[][]{{1,2,3,4,5,6},{1,2,3,4,5,6}};
		int sum = 9;
		System.out.println("Test 1: Expected 4, Found : " + DiceRolls.diceRolls(arrayOne, sum));
	}
	
	private static void testTwo() {
		int[][] arrayTwo = new int[][]{{2,4,6},{1,3,5,7}};
		int sum = 8;
		System.out.println("Test 2: Expected 0, Found : " + DiceRolls.diceRolls(arrayTwo, sum));
	}
	
	private static void testThree() {
		int[][] arrayThree = new int[][]{{1,2},{3,4}};
		int sum = 1;
		System.out.println("Test 3: Expected 0, Found : " + DiceRolls.diceRolls(arrayThree, sum));
	}
	
	private static void testFour() {
		int[][] arrayFour = new int[][]{{3,7},{2,6}};
		int sum = 9;
		System.out.println("Test 4: Expected 2, Found : " + DiceRolls.diceRolls(arrayFour, sum));
	}
	
	private static void testFive() {
		int[][] arrayFive = new int[][]{{1,2,3,4},{2,4,6,8},{1,3,5,7,9}};
		int sum = 12;
		System.out.println("Test 5: Expected 8, Found : " + DiceRolls.diceRolls(arrayFive, sum));
	}
	
	private static void testSix() {
		int[][] arraySix = new int[][]{{12,19,20,25,33,43,62,68,72,78,88,92,98}, 
		                               {0,1,4,11,22,37,45,53,74,79,82,83,89}, 
		                               {12,17,37,61,80,98}, 
		                               {14,15,16,24,46,67,77,79,80,82,83}, 
		                               {3,13,28,50,62,80,81,83,98}};
		int sum = 45;
		System.out.println("Test 6: Expected 1, Found : " + DiceRolls.diceRolls(arraySix, sum));
	}
	
	private static void testSeven() {
		int[][] arraySeven = new int[][]{{1,2}, 
		                               {3,4}, 
		                               {5,9,14}};
		int sum = 20;
		System.out.println("Test 7: Expected 1, Found : " + DiceRolls.diceRolls(arraySeven, sum));
	}
	
	private static void testEight() {
		int[][] arrayEight = new int[][]{{1,6,8,9}, 
		                               {1,2,4,5,6,7,8,9}, 
		                               {0,1,2,3,4,5,6}, 
		                               {0,4,5,6,8}, 
		                               {1,3,4,9}};
		int sum = 25;
		System.out.println("Test 8: Expected 284, Found : " + DiceRolls.diceRolls(arrayEight, sum));
	}
	
}
