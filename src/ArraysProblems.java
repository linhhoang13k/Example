package com.il.training.interviewbit.arrays;


import java.util.*;

/**
 * Created by cesaregb on 5/5/17.
 */
@SuppressWarnings("Duplicates")
public class ArraysProblems {

  public static void main(String[] args) {
//		callMaxSete();
//		callSpiralOrder();
//		callWave();
//		callRepeatedNumbers();
  }

  private static void callRepeatedNumbers() {
    System.out.println(repeatedNumber(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7))));
    System.out.println(repeatedNumber(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 1))));
    System.out.println(repeatedNumber(new ArrayList<>(Arrays.asList(247, 240, 303, 9, 304, 105, 44, 204, 291, 26, 242, 2, 358, 264, 176, 289, 196, 329, 189, 102, 45, 111, 115, 339, 74, 200, 34, 201, 215, 173, 107, 141, 71, 125, 6, 241, 275, 88, 91, 58, 171, 346, 219, 238, 246, 10, 118, 163, 287, 179, 123, 348, 283, 313, 226, 324, 203, 323, 28, 251, 69, 311, 330, 316, 320, 312, 50, 157, 342, 12, 253, 180, 112, 90, 16, 288, 213, 273, 57, 243, 42, 168, 55, 144, 131, 38, 317, 194, 355, 254, 202, 351, 62, 80, 134, 321, 31, 127, 232, 67, 22, 124, 271, 231, 162, 172, 52, 228, 87, 174, 307, 36, 148, 302, 198, 24, 338, 276, 327, 150, 110, 188, 309, 354, 190, 265, 3, 108, 218, 164, 145, 285, 99, 60, 286, 103, 119, 29, 75, 212, 290, 301, 151, 17, 147, 94, 138, 272, 279, 222, 315, 116, 262, 1, 334, 41, 54, 208, 139, 332, 89, 18, 233, 268, 7, 214, 20, 46, 326, 298, 101, 47, 236, 216, 359, 161, 350, 5, 49, 122, 345, 269, 73, 76, 221, 280, 322, 149, 318, 135, 234, 82, 120, 335, 98, 274, 182, 129, 106, 248, 64, 121, 258, 113, 349, 167, 192, 356, 51, 166, 77, 297, 39, 305, 260, 14, 63, 165, 85, 224, 19, 27, 177, 344, 33, 259, 292, 100, 43, 314, 170, 97, 4, 78, 310, 61, 328, 199, 255, 159, 185, 261, 229, 11, 295, 353, 186, 325, 79, 142, 223, 211, 152, 266, 48, 347, 21, 169, 65, 140, 83, 156, 340, 56, 220, 130, 117, 143, 277, 235, 59, 205, 153, 352, 300, 114, 84, 183, 333, 230, 197, 336, 244, 195, 37, 23, 206, 86, 15, 187, 181, 308, 109, 293, 128, 66, 270, 209, 158, 32, 25, 227, 191, 35, 40, 13, 175, 146, 299, 207, 217, 281, 30, 357, 184, 133, 245, 284, 343, 53, 210, 306, 136, 132, 239, 155, 73, 193, 278, 257, 126, 331, 294, 250, 252, 263, 92, 267, 282, 72, 95, 337, 154, 319, 341, 70, 81, 68, 160, 8, 249, 96, 104, 137, 256, 93, 178, 296, 225, 237))));
  }

  // whether bucket[n] has more than expected elements
  private static boolean moreThanExpected(int nBucket, int[] buckets, int LAST_BUCKET_SIZE, int AVG_BUCKET_SIZE) {
    if (nBucket == buckets.length - 1) {
      return buckets[nBucket] > LAST_BUCKET_SIZE;
    } else {
      return buckets[nBucket] > AVG_BUCKET_SIZE;
    }
  }

  public static int repeatedNumber(final List<Integer> A) {
    int[] buckets;
    int AVG_BUCKET_SIZE = 0;
    int LAST_BUCKET_SIZE = 0;

    int n = A.size() - 1; // [1 : n] for (n + 1) number
    if (n < 1) {
      // no way to find duplicates
      return -1;
    }
    int nBuckets = (int) Math.ceil(Math.sqrt(n)); // ceiling of sqrt(n)
    int range = (int) Math.sqrt(n); // floor of sqrt(n)

    buckets = new int[nBuckets];
    if (range * nBuckets < n) {
      // enlarge range of each bucket to contain all elements
      range++;
    }

    LAST_BUCKET_SIZE = n - (nBuckets - 1) * range;

    AVG_BUCKET_SIZE = range;

    int targetBucket = -1;
    for (int num : A) {
      int iBucket = (num - 1) / range;
      buckets[iBucket]++;
      if (moreThanExpected(iBucket, buckets, LAST_BUCKET_SIZE, AVG_BUCKET_SIZE)) {
        // once we found a bucket holding more elements than expected
        targetBucket = iBucket;
        break;
      }
    }
    if (targetBucket != -1) {
      Set<Integer> targetSet = new HashSet<>();
      int lower = targetBucket * range + 1;
      int upper = lower + range - 1;
      for (int num : A) {
        if (num >= lower && num <= upper && !targetSet.add(num)) {
          // duplicate found
          return num;
        }
      }
    }
    return -1;
  }


  private static void callSpiralOrder() {
    ArrayList<List<Integer>> a = new ArrayList<List<Integer>>();
//		a.add(Arrays.asList(1, 2, 3));
//		a.add(Arrays.asList(4, 5, 6));
//		a.add(Arrays.asList(7, 8, 9));


//		a.add(Arrays.asList(1, 2));
//		a.add(Arrays.asList(3, 4));
//		a.add(Arrays.asList(5, 6));

    a.add(java.util.Arrays.asList(147, 253, 39, 243));
    a.add(java.util.Arrays.asList(194, 342, 97, 156));
    a.add(java.util.Arrays.asList(285, 351, 90, 10));
    a.add(java.util.Arrays.asList(332, 76, 212, 156));
    a.add(java.util.Arrays.asList(144, 395, 277, 402));


//		a.add(Arrays.asList(1));
//		a.add(Arrays.asList(2));
//		a.add(Arrays.asList(3));


    spiralOrder(a).forEach(System.out::print);
  }


  private static int coverPoints(List<Integer> X, List<Integer> Y) {
    int x1 = X.get(0);
    int y1 = Y.get(0);
    int steps = 0;
    for (int i = 1; i < X.size(); i++) {
      int dx = x1 - X.get(i);
      int dy = y1 - Y.get(i);
      steps +=
              steps += Math.max(Math.abs(dx), Math.abs(dy));
      x1 = X.get(i);
      y1 = Y.get(i);
    }

    return steps;
  }


  private static ArrayList<Integer> spiralOrder(final ArrayList<List<Integer>> a) {
    ArrayList<Integer> result = new ArrayList<Integer>();
    int l = 0;
    int size = a.size() * a.get(0).size();
    int i = 0;
    while (i < size) {

      int sizeA = a.get(0).size() - l;
      for (int j = l; j < sizeA; j++) {
        i++;
        int val = a.get(l).get(j);
        result.add(val);
      }

      sizeA = a.size() - l;
      for (int j = (l + 1); j < sizeA; j++) {
        i++;
        int val = a.get(j).get(a.get(0).size() - (1 + l));
        result.add(val);
      }

      sizeA = a.get(0).size() - l;
      if ((i < size))
        for (int j = sizeA - (2); j >= l; j--) {
          i++;
          int val = a.get(a.size() - (1 + l)).get(j);
          result.add(val);
        }

      sizeA = a.size() - l;
      if (i < size)
        for (int j = sizeA - (2); j > l; j--) {
          i++;
          int val = a.get(j).get(l);
          result.add(val);
        }

      l++;
    }

    return result;
  }

}