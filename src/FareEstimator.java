package com.sleepsoft.challenges.uber;

import com.sleepsoft.test.BaseTest;

/**
 * Created by agermenos on 8/22/16.
 */
public class FareEstimator extends BaseTest{
    double[] fareEstimator(int ride_time, int ride_distance, double[] cost_per_minute, double[] cost_per_mile) {
        double[] returnVal = new double[cost_per_mile.length];
        int k=0;
        while (k<cost_per_mile.length) {
            returnVal[k]=ride_time*ride_distance-cost_per_mile[k]*cost_per_minute[k++];
        }
        return returnVal;
    }



}
