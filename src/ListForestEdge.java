package evg.codefights.core;

import java.util.Arrays;

public class ListForestEdge {

    public static void main(String[] args) {

    }

    int[] createArray(int size) {
        int[] r = new int[size];
        Arrays.fill(r, 1);
        return r;
    }

    int[] arrayReplace(int[] inputArray, int elemToReplace, int substitutionElem) {
        for (int i = 0; i < inputArray.length; i++) {
            if (inputArray[i] == elemToReplace) {
                inputArray[i] = substitutionElem;
            }
        }
        return inputArray;
    }

    int[] firstReverseTry(int[] arr) {
        int len = arr.length;
        if (len == 0) {
            return arr;
        }
        int tmp = arr[0];

        arr[0] = arr[len - 1];
        arr[len - 1] = tmp;
        return arr;
    }

    int[] concatenateArrays(int[] a, int[] b) {
        int[] res = new int[a.length + b.length];

        System.arraycopy(a, 0, res, 0, a.length);
        System.arraycopy(b, 0, res, a.length, b.length);
        return res;
    }

    int[] removeArrayPart(int[] inputArray, int l, int r) {
        int len = inputArray.length - (r - l) - 1;
        int[] res = new int[len];
        System.arraycopy(inputArray, 0, res, 0, l);
        System.arraycopy(inputArray, r + 1, res, l, inputArray.length - r - 1);
        return res;
    }

    boolean isSmooth(int[] arr) {
        int n = arr.length;
        int middle = 0;
        if (arr.length % 2 == 0) {
            middle = arr[n / 2] + arr[n / 2 - 1];
        } else {
            middle = arr[n / 2];
        }

        return arr[0] == arr[n - 1] && arr[0] == middle;
    }

    int[] replaceMiddle(int[] arr) {
        int n = arr.length;
        if (n % 2 == 1 || n == 0) {
            return arr;
        }
        int[] res = new int[n - 1];
        if (n == 2) {
            res[0] = arr[0] + arr[1];
            return res;
        }
        int mid = n / 2 - 1;
        int newMid = arr[mid] + arr[mid + 1];
        res[mid] = newMid;
        System.arraycopy(arr, 0, res, 0, mid);
        System.arraycopy(arr, mid + 2, res, mid + 1, mid);
        return res;
    }

    int makeArrayConsecutive2(int[] sequence) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i : sequence) {
            max = Math.max(max, i);
            min = Math.min(min, i);
        }

        return max - min - sequence.length + 1;
    }
}
