package Arcade_Intro;

public class _22_avoidObstacles {

    int avoidObstacles(int[] inputArray) {
        for(int numberToTest = 1 ; ; ++numberToTest) // find the number from 1 to inf.
        {
            boolean flag = true;
            for(int elem : inputArray) { // se if the current number doesn't divide any of the nums in array
                int mod = elem % numberToTest;
                flag = flag && (mod != 0);
            }
            if(flag)return numberToTest;
        }
    }
}
