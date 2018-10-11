package com.il.java.threads.git;

import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by cesaregb on 11/10/16.
 */
public class AtomicVsLocks {

  public static void main(String[] args) {

    TaskAtomic atomicTask = new TaskAtomic();

    TaskLock lockTask = new TaskLock();

    int numberThreads = 50;
    Thread threads[] = new Thread[numberThreads];
    Date begin, end;

    begin = new Date();
    for (int i = 0; i < numberThreads; i++) {
      threads[i] = new Thread(lockTask);
      threads[i].start();
    }

    for (int i = 0; i < numberThreads; i++) {
      try {
        threads[i].join();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    end = new Date();

    System.out.printf("Main: Lock results: %d\n", (end.getTime() - begin.getTime()));

    begin = new Date();
    for (int i = 0; i < numberThreads; i++) {
      threads[i] = new Thread(atomicTask);
      threads[i].start();
    }

    for (int i = 0; i < numberThreads; i++) {
      try {
        threads[i].join();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    end = new Date();

    System.out.printf("Main: Atomic results: %d\n", (end.getTime() - begin.getTime()));
  }

  public static void main2(String[] args) {

    int[] data = {1, 2, 3, 4, 7, 9, 0, -1};
    int requiredSum = 10;
    int sum = 0;

    for (int i = 0; i < data.length - 2; i++) {
      for (int j = i + 1; j < data.length - 1; j++) {
        sum = data[i] + data[j];
        for (int k = j + 1; k < data.length; k++) {
          if (data[k] + sum == requiredSum) {
            System.out.println(data[i]);
            System.out.println(data[j]);
            System.out.println(data[k]);
            System.out.println("True");
          }
        }
      }
    }
  }
}

class TaskLock implements Runnable {
  private Lock lock;
  private int number;

  public TaskLock() {
    this.lock = new ReentrantLock();
  }

  @Override
  public void run() {
    for (int i = 0; i < 1000000; i++) {
      lock.lock();
      number = i;
      lock.unlock();
    }
  }
}

class TaskAtomic implements Runnable {

  private AtomicInteger number;

  public TaskAtomic() {
    this.number = new AtomicInteger();
  }

  @Override
  public void run() {
    for (int i = 0; i < 1000000; i++) {
      number.set(i);
    }
  }

}

