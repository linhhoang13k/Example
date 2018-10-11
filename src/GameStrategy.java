package com.il.training.topics.dynamicPrograming;

/**
 * Created by cesaregb on 6/17/17.
 */
public class GameStrategy {

	 /*
    5, 3, 12, 100, 100, 10

    5 + 12 + 100 = 117
    3 + 100 + 10 = 113


    10 + 100 + 5 = 105
    100 + 12 + 3 = 105

	5, 8, 12, 100, 100, 10
	118 = [5, 8, 12, 100, 100, 10] - 10
	117 = [5, 8, 12, 100, 100] - 5
	112 = [8, 12, 100, 100] - 100
	108 = [8, 12, 100] - 100
	12 = [8, 12] - 12
	8 = [8] - 8


	5 + 100 + 12 = 117
    10 + 100 + 8 = 118


    10 + 100 + 8 =
    100 + 12 + 5 =


    memo[ n ]
    [5, 3, 12, 100, 100, 10]
    [10, 112, 118]

    [10, 105, 118]
    prevA, prevB
    i, j
    val = Math.max(arr[i] + prevB, arr[j] + prevA); -> 10
    prevA = val;
    prevB = Math.min(arr[i] + prevB, arr[j] + prevA);

   8, 15, 3, 7 = 22
   2, 2, 2, 2 = 4
   20, 30, 2, 2, 2, 10 = 42
*/


  public static void main(String[] args) throws java.lang.Exception {
    System.out.println(bestApproach(new int[]{5, 3, 7, 10}));
    System.out.println(bestApproach(new int[]{5, 8, 12, 100, 100, 10}));
    System.out.println(bestApproach(new int[]{8, 15, 3, 7}));
    System.out.println(bestApproach(new int[]{2, 2, 2, 2}));
    System.out.println(bestApproach(new int[]{20, 30, 2, 2, 2, 10}));
  }


  public static int bestSolution(int[] input) {
    int i = 0;
    int j = input.length - 1;
    int[] turnArray = new int[2];
    int[][] indices = new int[2][2];
    int count = 0;
    while (i <= j) {
      int turn = count % 2;
      turnArray[turn] = Math.max(input[i] + turnArray[turn], input[j] + turnArray[turn]);
      if (input[i] > input[j]) {
        i++;
      } else {
        j--;
      }
      count++;
    }
    return Math.max(turnArray[0], turnArray[1]);
  }

  private static int bestApproach(int[] input) {
    if (input.length == 1) {
      return input[0];
    }
    if (input.length == 2) {
      return Math.max(input[0], input[1]);
    }
    int[] dp = new int[input.length + 1];
    dp[1] = input[0];
    dp[2] = input[1];
    for (int i = 3; i < input.length + 1; i++) {
      int max = Math.max(dp[i - 2], dp[i - 3]);
      dp[i] = input[i - 1] + max;
    }

    return Math.max(dp[input.length - 1], dp[input.length - 2]);
  }


  private static int ImTheBest(int[] input, int index, int sum, int used) {
    if (used >= input.length / 2 || index == input.length) {
      return sum;
    }
    int tmpSum = sum + input[index];
    return Math.max(ImTheBest(input, index + 1, sum, used), ImTheBest(input, index + 1, tmpSum, used + 1));
  }
}