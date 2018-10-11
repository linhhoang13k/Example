package com.jeromewirth;

public class ArcadeTheCore {

    int addTwoDigits(int n) {
        return (n/10) + (n%10);
    }

    int largestNumber(int n) {
        int num = 0;
        for(int i = 0; i < n; i++) {
            num = num * 10 + 9;
        }

        return num;
    }

    int candies(int n, int m) {
        return (m/n)*n;
    }

    int seatsInTheater(int nCols, int nRows, int col, int row) {
        return (nCols - col + 1) * (nRows - row);
    }

    int maxMultiple(int divisor, int bound) {
        int N = 1;
        int sum = 0;

        while( sum <= bound) {
            sum = N * divisor;
            N++;
        }

        sum -= divisor;

        return sum;
    }

    int circleOfNumbers(int n, int firstNumber) {
        int temp = n/2;
        if(firstNumber < temp) {
            return firstNumber + temp;
        } else {
            return firstNumber - temp;
        }
    }

    int lateRide(int n) {
        int hours = n/60;
        int minutes = n%60;

        int a = hours/10;
        int b = hours%10;
        int c = minutes/10;
        int d = minutes%10;

        return a+b+c+d;
    }

    int phoneCall(int min1, int min2_10, int min11, int s) {
        int minutes = 0;

        s -= min1;
        minutes++;

        if (s < 0) {
            return 0;
        } else {

            while (s > 0 && minutes < 10 ) {
                s -= min2_10;
                minutes++;
            }

            minutes  = minutes + s / min11;

            return minutes;
        }
    }

    boolean reachNextLevel(int experience, int threshold, int reward) {
        return (experience + reward) >= threshold;
    }

    int knapsackLight(int value1, int weight1, int value2, int weight2, int maxW) {
        int value = 0;

        if (weight1 + weight2 <= maxW) {
            return value1 + value2;
        } else if ( ((value1 >= value2)  || (weight2 > maxW)) && (weight1 <= maxW) ) {

            return value1;

        } else if ( ((value2 >= value1)  || (weight1 > maxW)) && (weight2 <= maxW) ) {

            return value2;

        } else return 0;
    }

    int extraNumber(int a, int b, int c) {

        if (a == b) {
            return c;
        } else if (a == c) {
            return b;
        } else return a;

    }




}
