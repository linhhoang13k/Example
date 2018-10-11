package com.il.training.hackerrank.sad_examples.oct;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by cesaregb on 10/14/16.
 */
@SuppressWarnings("Duplicates")
public class Solution9A {

  public static void main(String[] args) {
    int[] arr = new int[0];
    arr = new int[]{3, 2, 1};
    System.out.println(getSwaps(arr, 0, 2));

    arr = new int[]{2, 1, 3, 1, 2};
    System.out.println(getSwaps(arr, 0, arr.length - 1));

    arr = new int[]{1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 0, 5, 1, 700, 2, 2, 2, 2, 2, 2, 2, 2, 2, 0, 5, 1, 700, 2, 2, 2, 2, 2, 2, 2, 2, 2, 0, 5, 1, 700, 2, 2, 2, 2, 2, 2, 2, 2, 2, 0, 5, 1, 700, 2, 2, 2, 2, 2, 2, 2, 2, 2, 0, 5, 1, 700, 2, 2, 2, 2, 2, 2, 2, 2, 2, 0, 5, 1, 700, 2, 2, 2, 2, 2, 2, 2, 2, 2, 0, 5, 1, 700, 2, 2, 2, 2, 2, 2, 2, 2, 2, 0, 5, 1, 700, 2, 2, 2, 2, 2, 2, 2, 2, 2, 0, 5, 1, 700, 2, 2, 2, 2, 2, 2, 2, 2, 2, 0, 5, 1, 700, 2, 2, 2, 2, 2, 2, 2, 2, 2, 0, 5, 1, 700, 2, 2, 2, 2, 2, 2, 2, 2, 2, 0, 5, 1, 700, 2, 2, 2, 2, 2, 2, 2, 2, 2, 0, 5, 1, 700, 2, 2, 2, 2, 2, 2, 2, 2, 2, 0, 5, 1, 700, 2, 2, 2, 2, 2, 2, 2, 2, 2, 0, 5, 1, 700, 2};
    System.out.println(getSwaps(arr, 0, arr.length - 1));

    arr = new int[]{1, 2, 3, 4, 4, 3, 2, 1};
    System.out.println(getSwaps(arr, 0, arr.length - 1));

    arr = new int[]{2, 2, 2, 2, 2, 1, 1, 1, 1};
    System.out.println(getSwaps(arr, 0, arr.length - 1));

    NumberFormat formatter = new DecimalFormat("#0");

    List<Integer> lInt = new ArrayList<>();
    try {
      List<String> lines = getFileContent("input2.txt");

      for (String l : lines) {
        String[] nums = l.split("\\s+");
        for (String n : nums) {
          lInt.add(Integer.valueOf(n));
        }
        arr = new int[lInt.size()];
        for (int i = 0; i < lInt.size(); i++) {
          arr[i] = lInt.get(i);
        }
        System.out.println(formatter.format(getSwaps(arr, 0, arr.length - 1)));
        lInt = new ArrayList<>();
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private static double getSwaps(int[] arr, int index1, int index2) {
    if (arr.length < 2) {
      return 0;
    }
    if (index1 >= index2) {
      return 0;
    }
    double r = 0;
    int mid = (index1 + index2) / 2;
    r = r + getSwaps(arr, index1, mid);
    r = r + getSwaps(arr, (mid + 1), index2);
    return r + (merge(arr, index1, mid, (mid + 1), index2));
  }

  private static double merge(int[] arr, int a, int b, int c, int d) {
    double swaps = 0;
    int[] helper = new int[(d - a) + 1];

    for (int i = 0; i < helper.length; i++) {
      helper[i] = arr[(a + i)];
    }

    int left = a;
    int right = c;
    int index = a;
    while (left <= b && right <= d) {
      if (helper[(left - a)] <= helper[(right - a)]) {
        arr[index] = helper[(left - a)];
        left++;
      } else {
        arr[index] = helper[(right - a)];
        swaps = swaps + ((b + 1) - left);
        right++;
      }
      index++;
    }
    while (left <= b) {
      arr[index] = helper[(left - a)];
      left++;
      index++;
    }
    while (right <= d) {
      arr[index] = helper[(right - a)];
      right++;
      index++;
    }

    return swaps;
  }

  private static void printArr(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
    System.out.println();
  }

  private static List<String> getFileContent(String fileName) throws Exception {
    BufferedReader br = null;
    List<String> result = new ArrayList<>();
    URL path = Solution9A.class.getResource(fileName);
    if (path != null) {
      try {
        String sCurrentLine;
        br = new BufferedReader(new FileReader(path.getPath()));
        boolean exit = false;

        while (((sCurrentLine = br.readLine()) != null) && !exit) {
          result.add(sCurrentLine);
        }
      } catch (IOException e) {
        e.printStackTrace();
      } finally {
        try {
          if (br != null)
            br.close();
        } catch (IOException ex) {
          ex.printStackTrace();
        }
      }
    }
    return result;
  }
}
