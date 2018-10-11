package com.il.training.codefights.datto;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

/**
 * Created by cesaregb on 12/29/16.
 */
public class IncrementalBackup {

  static int[] incrementalBackups(int lastBackupTime, int[][] changes) {
    List<Integer> result = new ArrayList<>();
    HashSet<Integer> added = new HashSet<>();
    for (int i = 0; i < changes.length; i++) {
      long lastUpdated = changes[i][0];
      int id = changes[i][1];

      if (lastUpdated > lastBackupTime && !added.contains(id)) {
        result.add(id);
        added.add(id);
      }
    }

    int[] r = new int[result.size()];
    int i = 0;
    result.sort(Comparator.comparingInt(a -> a));
    for (Integer itm : result) {
      r[i++] = itm;
    }

    return r;
  }
}
