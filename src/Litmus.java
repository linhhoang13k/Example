package com.sleepsoft.tests;

import org.junit.Test;

/**
 * Created by agermenos on 12/10/2016.
 */
public class Litmus {
    public void swap(Object one, Object two) {
        Object temp = one;
        one = two;
        two = temp;
    }

    @Test
    public void test(){
        String one = "one";
        String two = "two";
        showOneTwo (one, two);
        swap(one, two);
        showOneTwo (one, two);
    }

    private void showOneTwo(String one, String two) {
        System.out.println ("One :\t" + one);
        System.out.println("Two :\t" + two);
    }
}
