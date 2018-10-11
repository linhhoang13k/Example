package com.sleepsoft.test;

/**
 * Created by agermenos on 3/20/17.
 */
public class SingAndDance {
    public static void main(String args[]){
        Thread sing = new Sing();
        sing.start();
        throw new RuntimeException("main");
    }
}

class Sing extends Thread {
    public void run() {
        System.out.println("Singing");
        throw new RuntimeException("run");
    }
}
