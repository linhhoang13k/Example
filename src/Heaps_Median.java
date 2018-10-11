package HackerRank;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 * Problem description: https://www.hackerrank.com/challenges/ctci-find-the-running-median
 *
 * In a nutshell, use the heap data structure to track a running median of ints
 *
 **/
public class Heaps_Median {

    // Heaps can only efficiently return a lowest or highest number. As such, need to maintain two heaps.
    // Max heap stores bottom half of values and can pop the higher (i.e. middle) and vice versa for min heap
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    // Add a number to the heap with fewer elements
    private void add(int num) {
        if (maxHeap.size() <= minHeap.size()) {
            maxHeap.add(num);
        } else {
            minHeap.add(num);
        }
        balance();
    }

    // Make sure the heaps have same number of elements, max heap has the smaller values and min heap has the larger
    private void balance() {
        if (maxHeap.size() == 0 || minHeap.size() == 0) {
            // do nothing
        } else {
            if (minHeap.peek() < maxHeap.peek()) {
                int tooBig = maxHeap.poll();
                int tooSmall = minHeap.poll();
                minHeap.add(tooBig);
                maxHeap.add(tooSmall);
            }
        }
    }

    private void printMedian() {
        double median;
        if (maxHeap.size() == minHeap.size())
            median = Math.round(((maxHeap.peek() + minHeap.peek()) / 2.0) * 10) / 10;
        else
            median = Math.round(maxHeap.peek() * 10) / 10;
        System.out.println(median);
    }

    public static void main(String[] args) {

        Heaps_Median heapy = new Heaps_Median();

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();                   // number of ints to be read from std in

        for(int a_i=0; a_i < n; a_i++){         // ints being read in
            heapy.add(in.nextInt());
            heapy.printMedian();
        }
    }
}
