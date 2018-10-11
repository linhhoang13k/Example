package HackerRank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Noosh on 29/06/17.
 */
public class MergeSort_Inversions {

    static long inversions;


    static void startMergeSort(List<Integer> array) {
        inversions = 0;

        List<Integer> sorted = mergeSort(array);
        System.out.println(sorted.toString());

        System.out.println(inversions);
    }

    // outer mergeSort call
    static List<Integer> mergeSort(List<Integer> array) {

        if (array == null || array.size() <= 1)
            return array;

        List<Integer> left = mergeSort(array.subList(0, array.size() / 2));
        List<Integer> right = mergeSort(array.subList(array.size()/2, array.size()));

        int leftInd = 0;
        int rightInd = 0;
        List<Integer> sorted = new ArrayList<>(array.size());

        // while still processing both lists, any time draw from the right before left, have an inversion
        while (leftInd < left.size() && rightInd < right.size()) {
            if (left.get(leftInd) <= right.get(rightInd)) {
                sorted.add(left.get(leftInd));
                leftInd++;
            } else {
                sorted.add(right.get(rightInd));
                rightInd++;
                // If rightsublist has smallest element, must move it across
                inversions += left.size() - leftInd;
            }
        }

        // Clean out the left subarray if anything left
        while (leftInd < left.size()) {
            sorted.add(left.get(leftInd));
            leftInd++;
        }

        // clean out the right subarray if anything left
        while (rightInd < right.size()) {
            sorted.add(right.get(rightInd));
            rightInd++;
        }

        return sorted;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();               // Number of arrays to be processed
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();           // Number of ints in current array
            ArrayList<Integer> unsortedNums = new ArrayList<>(n);
            // Build ArrayList
            for(int arr_i=0; arr_i < n; arr_i++){
                unsortedNums.add(in.nextInt());
            }
            startMergeSort(unsortedNums);
        }
    }
}
