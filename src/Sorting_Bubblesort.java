package HackerRank;

/**
 * Given an n-element array, A, of distinct elements, sort array in ascending order using the Bubble Sort algorithm.
 * Once sorted, print the following three lines:

 Array is sorted in numSwaps swaps., where numSwaps is the number of swaps that took place.
 First Element: firstElement, where firstElement is the first element in the sorted array.
 Last Element: lastElement, where lastElementis the last element in the sorted array.

 Input Format

 The first line contains an integer, n, denoting the number of elements in array A.
 The second line contains n space-separated integers describing the respective values of A.
 */

import java.io.*;
import java.util.*;

public class Sorting_Bubblesort {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = in.nextInt();
        }

        int total_swaps = 0;
        int this_pass_through_swaps;
        for (int i = 0; i < n; i++) {
            this_pass_through_swaps = 0;
            for (int j = 0; j < n - 1; j++) {
                if (numbers[j] > numbers[j + 1]) {
                    int temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                    this_pass_through_swaps += 1;
                    total_swaps += 1;
                }
            }
            if (this_pass_through_swaps == 0){
                System.out.println("Array is sorted in " + total_swaps + " swaps.");
                break;
            }
        }

        System.out.println("First Element: " + numbers[0]);
        System.out.println("Last Element: " + numbers[n - 1]);
    }
}