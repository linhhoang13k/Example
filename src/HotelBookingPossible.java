package com.il.training.interviewbit.arrays.java;

import com.il.training.interviewbit.arrays.ArrayProblems2;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by cesaregb on 6/6/17.
 */

//https://www.interviewbit.com/problems/hotel-bookings-possible/

public class HotelBookingPossible {

  private static void callHotel(ArrayProblems2 ap2) {
//		System.out.println(ap2.hotel(new ArrayList<>(Arrays.asList(49, 8, 22, 28, 9, 15, 42, 3)),
//				new ArrayList<>(Arrays.asList(72, 38, 66, 51, 49, 57, 79, 30)),
//				1));
  }

  public boolean hotel(ArrayList<Integer> arrive, ArrayList<Integer> depart, int K) {
    Collections.sort(arrive);
    Collections.sort(depart);
    int ar = 0, de = 0, nos = 0, satisfy = 0, roomoccupancy = 0;
    while (ar < arrive.size() && de < depart.size()) {
      if (arrive.get(ar) < depart.get(de)) {
        ar++;
        nos++;
        roomoccupancy++;
        satisfy = Math.max(nos, satisfy);
      } else {
        de++;
        nos--;
      }
    }
    return (satisfy <= K) ? true : false;
  }

  public boolean hotel2(ArrayList<Integer> arrive, ArrayList<Integer> depart, int K) {
    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;


    for (int i = 0; i < arrive.size(); i++) {
      if (arrive.get(i) < min) {
        min = arrive.get(i);
      }

      if (depart.get(i) > max) {
        max = depart.get(i);
      }
    }

    int size = max - min;
    int[] pos = new int[size + 1];
    for (int i = 0; i < arrive.size(); i++) {
      int indexA = arrive.get(i);
      int indexB = depart.get(i);
      for (int j = indexA; j < indexB; j++) {
        pos[j - min]++;
        if (pos[j - min] > K) {
          return false;
        }
      }
    }

    int maxElement = 0;
    for (int i = 0; i < size; i++) {
      if (pos[i] > maxElement) {
        maxElement = pos[i];
      }
    }


    return (maxElement <= K);
  }
}
