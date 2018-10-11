package com.il.training.hackerrank.ctci;

import java.util.Comparator;

/**
 * Created by cesaregb on 12/2/16.
 */
public class Checker implements Comparator<Player> {
  public int compare(Player one, Player two) {
    int r = two.score - one.score;
    if (r == 0) {
      return one.name.compareTo(two.name);
    }
    return r;
  }

}

// pending correct imp.
class Player {
  int score;
  String name;
}