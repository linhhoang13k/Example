package com.sleepsoft.challenges;

import com.sleepsoft.test.BaseTest;
import org.junit.Test;

/**
 * Created by agermenos on 8/19/16.
 */
public class Squares extends BaseTest{
    int MoreTimesLess(String n) {
        int incidence=0;
        int b = (int)Math.ceil(Float.valueOf(n)/2);
        while (b>0){
            int a =(int) Math.sqrt(b*b-Integer.valueOf(n));
            if (a!=0 && (b*b) - (a*a) == Integer.valueOf(n)) {
                incidence++;
            }
            b--;
        }

        return incidence;
    }
    public void preTest(int value, int value2){
        System.out.print("test: " + value + "\t");
        prepare(MoreTimesLess(value+""), value2);
    }
    @Test
    public void test(){
        preTest(3, 1);
        preTest(15, 2);
        preTest(45, 3);
        preTest(388382828, 8);
    }
}
