package com.il.training.interviewbit.binarySearch;

import java.util.Arrays;
import java.util.List;

/**
 * Created by cesaregb on 6/4/17.
 */
@SuppressWarnings("Duplicates")
public class BinarySearch1 {

  public static void main(String[] args) {
//		callFindBS();
//		callFindMin();
//		callSearchInsert();
  }


  private static void callSearchInsert() {
    System.out.println(searchInsert(Arrays.asList(1, 3, 5, 6), 5));
    System.out.println(searchInsert(Arrays.asList(1, 3, 5, 6), 2));
    System.out.println(searchInsert(Arrays.asList(1, 3, 5, 6), 0));
    System.out.println(searchInsert(Arrays.asList(1, 3, 5, 6), 7));
    System.out.println(searchInsert(Arrays.asList(1), 0));
    System.out.println(searchInsert(Arrays.asList(3, 4, 18, 19, 20, 27, 28, 31, 36, 42, 44, 71, 72, 75, 82, 86, 88, 97, 100, 103, 105, 107, 110, 116, 118, 119, 121, 122, 140, 141, 142, 155, 157, 166, 176, 184, 190, 199, 201, 210, 212, 220, 225, 234, 235, 236, 238, 244, 259, 265, 266, 280, 283, 285, 293, 299, 309, 312, 317, 335, 341, 352, 354, 360, 365, 368, 370, 379, 386, 391, 400, 405, 410, 414, 416, 428, 433, 437, 438, 445, 453, 457, 458, 472, 476, 480, 485, 489, 491, 493, 501, 502, 505, 510, 511, 520, 526, 535, 557, 574, 593, 595, 604, 605, 612, 629, 632, 633, 634, 642, 647, 653, 654, 656, 658, 686, 689, 690, 691, 709, 716, 717, 737, 738, 746, 759, 765, 775, 778, 783, 786, 787, 791, 797, 801, 806, 815, 820, 822, 823, 832, 839, 841, 847, 859, 873, 877, 880, 886, 904, 909, 911, 917, 919, 937, 946, 948, 951, 961, 971, 979, 980, 986, 993), 902));
  }

  // https://www.interviewbit.com/problems/sorted-insert-position/
  public static int searchInsert(List<Integer> integers, int search) {
    int init = 0;
    int result;
    if (integers.size() == 1) {
      if (integers.get(0) == search) return 0;
      result = (search > integers.get(0)) ? integers.size() : 0;
      return result;
    }
    int end = integers.size() - 1;
    int n = integers.size() - 1;
    while (init <= end) {
      int mid = (init + end) / 2;
      int prev = (mid + (n - 1)) % n;
      int next = (mid + 1) % n;
      if (integers.get(mid) == search) {
        return mid;
      } else if (integers.get(prev) < search && integers.get(mid) > search) {
        return mid;
      } else if (integers.get(mid) < search && integers.get(next) > search) {
        return mid + 1;
      } else if (integers.get(mid) > search) {
        end = mid - 1;
      } else {
        init = mid + 1;
      }
    }
    result = (search > integers.get(0)) ? integers.size() : 0;
    return result;

  }

  private static void callFindMin() {
    System.out.println(findMin(Arrays.asList(40342, 40766, 41307, 42639, 42777, 46079, 47038, 47923, 48064, 48083, 49760, 49871, 51000, 51035, 53186, 53499, 53895, 59118, 60467, 60498, 60764, 65158, 65838, 65885, 65919, 66638, 66807, 66989, 67114, 68119, 68146, 68584, 69494, 70914, 72312, 72432, 74536, 77038, 77720, 78590, 78769, 78894, 80169, 81717, 81760, 82124, 82583, 82620, 82877, 83131, 84932, 85050, 85358, 89896, 90991, 91348, 91376, 92786, 93626, 93688, 94972, 95064, 96240, 96308, 96755, 97197, 97243, 98049, 98407, 98998, 99785, 350, 2563, 3075, 3161, 3519, 4176, 4371, 5885, 6054, 6495, 7218, 7734, 9235, 11899, 13070, 14002, 16258, 16309, 16461, 17338, 19141, 19526, 21256, 21507, 21945, 22753, 25029, 25524, 27311, 27609, 28217, 30854, 32721, 33184, 34190, 35040, 35753, 36144, 37342)));
  }

  // https://www.interviewbit.com/problems/rotated-array/
  public static int findMin(final List<Integer> integers) {
    if (integers.size() == 1) {
      return 1;
    }
    int init = 0;
    int end = integers.size() - 1;
    int n = integers.size() - 1;
    while (init <= end) {
      int mid = (init + end) / 2;
      int next = (mid + 1) % n;
      int prev = (mid + (n - 1)) % n;
      if (integers.get(mid) <= integers.get(next)
              && integers.get(mid) <= integers.get(prev)) {
        return integers.get(mid);
      } else if (integers.get(mid) < integers.get(end)) {
        end = mid - 1;
      } else {
        init = mid + 1;
      }
    }
    return integers.get(integers.size() - 1);
  }

  private static void callFindBS() {
    System.out.println(findCount(Arrays.asList(1, 2, 3), 0));
    System.out.println(findCount(Arrays.asList(5, 7, 7, 8, 8, 10), 5));
    System.out.println(findCountIterative(Arrays.asList(1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 4, 4, 5, 5, 5, 5, 5, 6, 6, 6, 7, 7, 8, 8, 8, 8, 9, 9, 10, 10, 10), 11));
  }

  // https://www.interviewbit.com/problems/count-element-occurence/
  public static int findCount(final List<Integer> integers, int find) {
    return findCountRecursive(integers, find, 0, integers.size() - 1);
  }

  public static int findCountIterative(final List<Integer> integers, int find) {
    int init = 0;
    int end = integers.size() - 1;
    while (init <= end) {
      int mid = (init + end) / 2;
      if (integers.get(mid) == find) {
        int elements = 1;
        int indexHelper = mid;
        while (--indexHelper >= 0 && integers.get(indexHelper) == find) {
          elements++;
        }

        indexHelper = mid;
        while (++indexHelper < integers.size() && integers.get(indexHelper) == find) {
          elements++;
        }
        return elements;
      } else if (integers.get(mid) > find) {
        end = mid - 1;
      } else {
        init = mid + 1;
      }
    }
    return 0;
  }

  public static int findCountRecursive(final List<Integer> integers, int find, int init, int end) {
    if (init == end) {
      return 0;
    }
    int mid = init + ((end - init) / 2);
    if (integers.get(mid) == find) {
      int elements = 1;
      int indexHelper = mid;
      while (--indexHelper >= 0 && integers.get(indexHelper) == find) {
        elements++;
      }

      indexHelper = mid;
      while (++indexHelper < integers.size() && integers.get(indexHelper) == find) {
        elements++;
      }
      return elements;
    } else if (integers.get(mid) > find) {
      return findCountRecursive(integers, find, init, mid);
    } else {
      return findCountRecursive(integers, find, mid, end);
    }
  }


}
