package com.il.training.interviewbit.arrays.java;

import com.google.common.base.Joiner;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by cesaregb on 6/10/17.
 */

//https://www.interviewbit.com/problems/next-permutation/
public class NextPermutation {

  public static void main(String[] args) {
    List<Integer> input = Arrays.asList(1, 2, 3);
    nextPermutation(input);
    System.out.println(Joiner.on("\t").join(input));

    input = Arrays.asList(444, 994, 508, 72, 125, 299, 181, 238, 354, 223, 691, 249, 838, 890, 758, 675, 424, 199, 201, 788, 609, 582, 979, 259, 901, 371, 766, 759, 983, 728, 220, 16, 158, 822, 515, 488, 846, 321, 908, 469, 84, 460, 961, 285, 417, 142, 952, 626, 916, 247, 116, 975, 202, 734, 128, 312, 499, 274, 213, 208, 472, 265, 315, 335, 205, 784, 708, 681, 160, 448, 365, 165, 190, 693, 606, 226, 351, 241, 526, 311, 164, 98, 422, 363, 103, 747, 507, 669, 153, 856, 701, 319, 695, 52);
    nextPermutation(input);
    System.out.println(Joiner.on("\t").join(input));
  }

  public static void nextPermutation(List<Integer> A) {
    boolean status;
    status = nextPerm(A);
    if (!status)
      Collections.sort(A);
    return;
  }


  public static boolean nextPerm(List<Integer> A) {
    int i;
    int n = A.size();

    for (i = n - 2; i >= 0; i--) {
      if (A.get(i) < A.get(i + 1))
        break;
    }

    if (i == -1)
      return false;

    int j = n - 1;

    for (; j >= i; j--) {
      if (A.get(j) > A.get(i))
        break;
    }

    swap(A, i, j);

    i++;
    int steps = (n - i + 1) / 2;

    for (int k = 0; k < steps; k++) {
      swap(A, i + k, n - k - 1);
    }

    return true;
  }

  public static void swap(List<Integer> A, int i, int j) {
    int temp = A.get(i);
    A.set(i, A.get(j));
    A.set(j, temp);
  }
}
