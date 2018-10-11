package com.il.training.codefights.datto;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by cesaregb on 12/29/16.
 */
public class BackupTimeEstimator {
  public static void main(String[] args) {
    BackupTimeEstimator bte = new BackupTimeEstimator();

    int[] a = new int[]{461620201, 461620202, 461620203};
    int[] b = new int[]{2, 2, 2};
    int c = 3;
    for (double itm :
            bte.backupTimeEstimator(a, b, c)) {
      System.out.printf("\n%f", itm);
    }
  }

  double[] backupTimeEstimator(int[] startTimes, int[] backupDuration, int maxThreads) {
    if (startTimes.length == 0) return new double[0];
    double[] result = new double[startTimes.length];
    int currentJob = 0;
    double currentTime = startTimes[currentJob];
    Queue<TimeNode> queue = new LinkedList<>();
    int pRunning = 0;
    boolean exit = startTimes.length == 0;
    while (!exit) {

      while (pRunning < maxThreads && currentJob < startTimes.length && currentTime >= startTimes[currentJob]) {
        System.out.println("currentTime: " + currentTime + " currentJob: " + currentJob);
        queue.add(new TimeNode(currentJob, backupDuration[currentJob], currentTime));
        pRunning++;
        currentJob++;
      }

      double time = (double) 1 / pRunning;
      int c = queue.size();

      Queue<TimeNode> helper = new LinkedList<>();

      while (c > 0) {
        TimeNode tn = queue.remove();
        tn.currentTime += 1;
        tn.duration -= time;
        if (tn.duration <= 0) {
          result[tn.index] = (tn.currentTime - Math.abs(tn.duration));
          pRunning--;
          if (pRunning == 0 && currentJob == startTimes.length) {
            exit = true;
          }
        } else {
          helper.offer(tn);
        }
        c--;
      }
      currentTime += 1;
      queue = helper;
    }
    return result;

  }

  class TimeNode {
    int index;
    double duration;
    double currentTime;

    public TimeNode(int index, int duration, double currentTime) {
      this.index = index;
      this.duration = duration;
      this.currentTime = currentTime;
    }
  }
}
