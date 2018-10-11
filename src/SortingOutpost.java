package evg.codefights.core;

import java.util.*;

public class SortingOutpost {

    public static void main(String[] args) {
        SortingOutpost so = new SortingOutpost();
//        System.out.println(Arrays.toString(so.digitDifferenceSort(new int[] {152, 23, 7, 887, 243})));
    }

    int[] shuffledArray(int[] shuffled) {
        int sum = Arrays.stream(shuffled).sum();
        int indx = 0;
        for (int i = 0; i < shuffled.length; i++) {
            if (sum - shuffled[i] == shuffled[i]) {
                indx = i;
                break;
            }
        }
        int[] res = new int[shuffled.length - 1];
        int i = 0;
        for (int j = 0; j < shuffled.length; j++) {
            if (j == indx) {
                continue;
            }
            res[i++] = shuffled[j];
        }
        Arrays.sort(res);
        return res;
    }

    int[] sortByHeight(int[] a) {
        int[] b = new int[a.length];
        System.arraycopy(a, 0, b, 0, a.length);
        Arrays.sort(b);
        int j = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == -1) {
                continue;
            }
            while (j < b.length && b[j] == -1) {
                j++;
            }
            a[i] = b[j++];
        }
        return a;
    }

    String[] sortByLength(String[] inputArray) {
        Arrays.sort(inputArray, Comparator.comparingInt(String::length));
        return inputArray;
    }

    boolean boxesPacking(int[] length, int[] width, int[] height) {
        int len = length.length;
        int[][] boxes = new int[len][3];
        for (int i = 0; i < len; i++) {
            boxes[i][0] = length[i];
            boxes[i][1] = width[i];
            boxes[i][2] = height[i];
            Arrays.sort(boxes[i]);
        }
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (!(boxes[i][0] > boxes[j][0] && boxes[i][1] > boxes[j][1] && boxes[i][2] > boxes[j][2])
                        && !(boxes[i][0] < boxes[j][0] && boxes[i][1] < boxes[j][1] && boxes[i][2] < boxes[j][2])) {
                    return false;
                }
            }
        }
        return true;
    }

    int maximumSum(int[] a, int[][] q) {
        int[] counts = new int[a.length];
        for (int i = 0; i < q.length; i++) {
            for (int k = q[i][0]; k <= q[i][1]; k++) {
                counts[k]++;
            }
        }
        Arrays.sort(counts);
        Arrays.sort(a);
        int result = 0;
        for (int i = 0; i < counts.length; i++) {
            result += counts[i] * a[i];
        }
        return result;
    }

    boolean rowsRearranging(int[][] matrix) {
        for (int i = 0; i < matrix.length - 1; i++) {
            for (int j = i + 1; j < matrix.length; j++) {
                if (matrix[i][0] > matrix[j][0]) {
                    swap(matrix, i, j);
                }
            }
        }
        for (int i = 0; i < matrix.length - 1; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] >= matrix[i + 1][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    void swap(int[][] matrix, int i, int j) {
        int[] temp = matrix[i];
        matrix[i] = matrix[j];
        matrix[j] = temp;
    }

    int[] digitDifferenceSort(int[] a) {
        List<Num> list = new ArrayList<>(a.length);
        for (int i = 0; i < a.length; i++) {
            list.add(new Num(a[i], i));
        }
        Collections.sort(list);
        return list.stream().mapToInt(n -> n.number).toArray();
    }

    int uniqueDigitProducts(int[] a) {
        Set<Integer> set = new HashSet<>();
        for (int t : a) {
            int prod = 1;
            while (t != 0) {
                int z = t % 10;
                prod *= z;
                t /= 10;
            }
            set.add(prod);
        }
        return set.size();
    }

    class Num implements Comparable<Num> {
        int number;
        int key;
        int index;

        public Num(int number, int index) {
            this.index = index;
            this.number = number;
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            int t = number;
            while (t != 0) {
                int k = t % 10;
                t /= 10;
                min = Math.min(min, k);
                max = Math.max(max, k);
            }
            key = max - min;
        }

        @Override
        public int compareTo(Num o) {
            if (key == o.key) {
                return o.index - index;
            }
            return key - o.key;
        }
    }


}
