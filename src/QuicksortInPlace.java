package com.il.training.topics.sorting;

import com.il.training.topics.implmementation.GridSearch;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.Scanner;

/**
 * Created by cesaregb on 3/4/17.
 * https://www.hackerrank.com/challenges/quicksort3
 */
public class QuicksortInPlace {
  public static void main(String[] args) throws FileNotFoundException, URISyntaxException {
    String fileName = "QuicksortIn-Place/tc1.txt";
    ClassLoader classLoader = GridSearch.class.getClassLoader();
    File file = new File(classLoader.getResource(fileName).getFile());
    Scanner in = new Scanner(file);
    int n = in.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = in.nextInt();
    }


  }


}
