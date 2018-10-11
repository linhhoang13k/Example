package com.il.training.codefights.datto;

/**
 * Created by cesaregb on 12/29/16.
 */
public class TroubleFiles {

  public static void main(String[] args) {
    int[][] files = new int[][]{{461618501, 3},
            {461618502, 1},
            {461618504, 2},
            {461618506, 5},
            {461618507, 6}};
    int[] backups = new int[]{461618501, 461618502, 461618504, 461618505, 461618506};

    int[] r = troubleFiles(files, backups);
    for (int i : r) {
      System.out.println(i);
    }

  }

  static int[] troubleFiles(int[][] files, int[] backups) {
    int[] result = new int[backups.length];
    int endTime = 0;
    int fileIndex = 0;
    for (int i = 0; i < backups.length; i++) {
      int conflict = 0;
      if (endTime < backups[i]) {
        endTime = backups[i];
        while (fileIndex < files.length && files[fileIndex][0] <= backups[i]) {
          endTime += files[fileIndex][1];
          fileIndex++;
        }
        conflict = 0;
        while (fileIndex < files.length && files[fileIndex][0] <= endTime) {
          conflict++;
          fileIndex++;
        }
      }
      result[i] = conflict;
    }
    return result;
  }
}


