package com.sleepsoft.challenges.uber;

import com.sleepsoft.test.BaseTest;
import org.junit.Test;

/**
 * Created by agermenos on 8/22/16.
 */
public class DrivingGrid extends BaseTest {
    double perfectCity(double[] departure, double[] destination) {
        double x = getDirection(departure[0], destination[0]);
        double y = getDirection(departure[1], destination[1]);
        return x+y;
    }

    private double getDirection(double a, double b) {
        //lrrl
        double lrrd = Math.ceil(a)-a+Math.abs(b-Math.ceil(a));
        double rlld = a-Math.floor(a)+Math.abs(b-Math.floor(a));
        return lrrd>rlld?rlld:lrrd;
    }

    @Test
    public void test(){
        prepare("Testing: [0.4, 1], [0.9, 3]\t", perfectCity(new double[]{0.4, 1}, new double[]{0.9, 3}));
        prepare("Testing: [2.4, 1], [5, 7.3]\t", perfectCity(new double[]{2.4, 1}, new double[]{5, 7.3}));
        prepare("Testing: [0.9, 6], [1.1, 5]\t", perfectCity(new double[]{0.9, 6}, new double[]{1.1, 5}));
        prepare("Testing: [0, 0.4], [1, 0.6]\t", perfectCity(new double[]{0, 0.4}, new double[]{1, 0.6}));
    }



}
