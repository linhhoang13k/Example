package com.ctci.sort;

import java.util.Arrays;

/**
 * Created by zambro on 3/31/17.
 */
public class BubbleSorter {

    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length - i; j++) {
                if (arr[j - 1] > arr[j]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }
        }
    }

    public static void sortByHeight(int[] a) {

        int t;

        for(int i=0; i<a.length; i++)
            for(int j=i+1; j<a.length; j++)
                if(a[i]>a[j] && a[i]!=-1 && a[j]!=-1) {
                    t = a[i];
                    a[i] = a[j];
                    a[j] = t;
                }

    }


    public static void sortIgnoringMinusOnes(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int offset = 0;
            for (int j = 1; j < arr.length - i; j++) {
                if(arr[j] != -1) {
                    if (arr[j - 1 - offset] > arr[j]) {
                        int temp = arr[j];
                        arr[j] = arr[j - 1 - offset];
                        arr[j - 1 - offset] = temp;
                    }
                    offset = 0;
                } else {
                    offset++;
                }
            }
        }
    }


    public static void main(String[] args) {
        int[] arr = new int[]{2, 4534, 232, 434, 22};
        sortIgnoringMinusOnes(arr);
        System.out.println(Arrays.toString(arr));

        arr = new int[]{2, 2, 2, 0};
        sortIgnoringMinusOnes(arr);
        System.out.println(Arrays.toString(arr));

        arr = new int[]{-234, -234, 23, 42, 0, 4234, -24234, 0, -2342, 234, 0};
        sortIgnoringMinusOnes(arr);
        System.out.println(Arrays.toString(arr));


        arr = new int[]{-1, 150, 190, 170, -1, -1, 160, 180};
        sortIgnoringMinusOnes(arr);
        System.out.println(Arrays.toString(arr));

        arr = new int[]{-1, 190, -1, -1, -1, -1, 180};
        sortIgnoringMinusOnes(arr);
        System.out.println(Arrays.toString(arr));


        arr = new int[]{-1, 150, 190, 170, -1, -1, 160, 180};
        sortByHeight(arr);
        System.out.println(Arrays.toString(arr));
    }
}
