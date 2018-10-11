package Arcade_Intro;

public class _17_arrayChange {
    int arrayChange(int[] inputArray) {
        int sum = 0;
        for(int i = 1; i < inputArray.length; i++){
            if(inputArray[i] - inputArray[i-1] <= 0){
                sum += -(inputArray[i] - inputArray[i-1]) +1;
                inputArray[i] = inputArray[i] + -(inputArray[i] - inputArray[i-1]) +1;
            }
        }
        return sum;
    }
}
