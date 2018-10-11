package com.il.training.codefights.quora;

import java.util.*;

/**
 * Created by cesaregb on 1/16/17.
 */
public class MostViewedWriters {

//	topicIds = [[1, 2, 3], [2, 3, 4], [1, 4], [2, 3]]
//	answerIds = [[6, 4], [1, 2], [5], [3]]
//	views = [[2, 1, 2], [6, 3, 5], [3, 3, 0], [5, 1, 1], [4, 2, 3], [1, 4, 2]]

//	[
//		[[3, 5], [2, 3], [1, 1]],
//		[[3, 5], [2, 3], [1, 2], [4, 2]],
//		[[3, 5], [2, 3], [1, 2], [4, 2]],
//		[[1, 3], [4, 2]]
//	]


  public static void main(String[] args) {
    int[][] topicIds = new int[][]{{5, 6, 81},
            {1, 3, 2},
            {10, 12, 34},
            {13, 14, 23, 43},
            {11, 22, 17}};
    int[][] answerIds = new int[][]{{1, 2, 3},
            {},
            {},
            {4, 5, 6, 7},
            {8, 9, 10, 11}};
    int[][] view = new int[][]{{4, 18, 5},
            {5, 23, 37},
            {8, 1, 23},
            {11, 18, 18},
            {1, 7, 20},
            {9, 239, 10},
            {2, 239, 1},
            {10, 18, 1},
            {3, 239, 5},
            {6, 169, 2},
            {7, 800, 1}};

    int[][][] a = mostViewedWriters(topicIds, answerIds, view);
  }

  static int[][][] mostViewedWriters(int[][] topicIds, int[][] answerIds, int[][] views) {
    HashMap<Integer, List<Integer>> topics = new HashMap<Integer, List<Integer>>();

    // get topics and the questions each topic is in.
    int maxTopic = 0;
    for (int i = 0; i < topicIds.length; i++) {
      for (int j = 0; j < topicIds[i].length; j++) {
        topics.putIfAbsent(topicIds[i][j], new ArrayList<>());
        topics.get(topicIds[i][j]).add(i);
        if (maxTopic < topicIds[i][j]) {
          maxTopic = topicIds[i][j];
        }
      }
    }

    HashMap<Integer, UserViewsInfo> initialViewsInfo = new HashMap<>(views.length);
    for (int[] view : views) {
      initialViewsInfo.put(view[0], new UserViewsInfo(view[1], view[2]));
    }

    HashMap<Integer, TopicsUsers> preResult = new HashMap<>();

    for (Map.Entry<Integer, List<Integer>> entry : topics.entrySet()) {
      Integer key = entry.getKey();
      List<Integer> value = entry.getValue();

      List<Integer> lAnswersIds = new ArrayList<>();
      for (Integer index : value) {
        for (int i = 0; i < answerIds[index].length; i++) {
          lAnswersIds.add(answerIds[index][i]);
        }
      }
      preResult.putIfAbsent(key, new TopicsUsers(key));
      for (Integer id : lAnswersIds) {
        preResult.get(key).enqueue(initialViewsInfo.get(id));
      }
    }

    PriorityQueue<TopicsUsers> tQueue = new PriorityQueue<>(Comparator.comparingInt(a -> a.idTopic));
    for (Map.Entry<Integer, TopicsUsers> el : preResult.entrySet()) {
      tQueue.offer(el.getValue());
    }

    int[][][] result = new int[tQueue.size()][][];
    int i = 0;
    while (tQueue.size() != 0) {
      TopicsUsers el = tQueue.remove();

      result[i] = new int[el.helper.size()][];
      System.out.print(el.idTopic + " [");

      PriorityQueue<UserViewsInfo> queue = new PriorityQueue<>((a, b) -> {
        if (a.views == b.views) {
          return a.idUser - b.idUser;
        }
        return (b.views - a.views);
      });

      el.helper.entrySet().forEach(helper -> {
        queue.offer(new UserViewsInfo(helper.getKey(), helper.getValue()));
      });

      int j = 0;
      while (queue.size() != 0) {
        UserViewsInfo el1 = queue.remove();
        System.out.print("[" + el1.idUser + ", " + el1.views + "], ");
        result[i][j] = new int[]{el1.idUser, el1.views};
        j++;
      }
      System.out.print("]");
      System.out.println("*************");
      i++;

    }
    return result;
  }

  private static class TopicsUsers {
    int idTopic;
    HashMap<Integer, Integer> helper = new HashMap<>();

    TopicsUsers(int idTopic) {
      this.idTopic = idTopic;
    }

    void enqueue(UserViewsInfo it) {
      helper.putIfAbsent(it.idUser, 0);
      helper.put(it.idUser, helper.get(it.idUser) + it.views);
    }
  }

  private static class UserViewsInfo {
    int idUser;
    int views;

    UserViewsInfo(int idUser, int views) {
      this.idUser = idUser;
      this.views = views;
    }
  }
}
