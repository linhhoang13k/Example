package com.sleepsoft.test;

/**
 * Created by agermenos on 8/19/16.
 */
public class BaseTest {
    public void log(String message){
        System.out.println(message);
    }
    public void prepare (int value, int expected){
        log("number: " + value + "\t value: " + expected);
    }
    public void prepare(String message, double v) {
        log ("\t" + message + "distance: " + v);
    }

    public void prepare(String s, boolean b) {
        log ("\t" + s + "result: " + b);
    }
    public void prepare (String value, String expected){
        log("received: " + value + "\t expected: " + expected);
        assert(value.equals(expected));
    }
}
