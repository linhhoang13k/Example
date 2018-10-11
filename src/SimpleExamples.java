package com.il.java.threads;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by cesaregb on 11/8/16.
 */
public class SimpleExamples {

  public static void main(String[] args) {
    MyRunnable r = new MyRunnable("thread");
    MyResource mr = new MyResource();
    for (int i = 0; i < 10; i++) {
      MyRunnableSlow r2 = new MyRunnableSlow(String.valueOf(i), mr);
      r2.start();
    }

    Reentrant2 ree = new Reentrant2();
    r.setRee(ree);
    r.start();
  }
}

class MyRunnable implements Runnable {

  Thread t;
  String tName;
  Reentrant2 ree;

  public void setRee(Reentrant2 ree) {
    this.ree = ree;
  }

  public MyRunnable(String tName) {
    this.tName = tName;
  }

  @Override
  public void run() {
    ree.outer();
    System.out.println("this is my thread...");
  }

  public void start() {
    t = new Thread(this, this.tName);
    t.start();
  }
}

class MyRunnableSlow implements Runnable {

  Thread t;
  String tName;
  MyResource mr;

  public MyRunnableSlow(String tName, MyResource mr) {
    this.tName = tName;
    this.mr = mr;
  }

  @Override
  public void run() {

    try {
      TimeUnit.SECONDS.sleep(1);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
//		System.out.println(tName + " " + mr.setGetResource(Integer.valueOf(tName)));
    mr.setReseource(Integer.valueOf(tName));
    System.out.println(tName + " " + mr.getResource());
  }

  public void start() {
    t = new Thread(this, this.tName);
    t.start();
  }
}

class MyResource {

  private int reseource;
  private volatile int reseource2;


  public int getResource() {
    return this.reseource2;
  }

  public void setReseource(int reseource) {
    System.out.println("o: " + reseource);
    this.reseource2 = reseource;
  }

  synchronized public int setGetResource(int reseource) {
    this.reseource = reseource;
    return this.reseource;
  }
}

class Reentrant2 {

  Lock lock = new ReentrantLock();

  public void outer() {
    lock.lock();
    inner();
    lock.unlock();
  }

  synchronized public void inner() {
    lock.lock();
    System.out.println("in inner!!");
    //do something
    lock.unlock();
  }
}