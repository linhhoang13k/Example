package Arcade_Intro;

public class _07_almostIncreasingSequence {
    boolean almostIncreasingSequence(int[] sequence) {
        boolean foundFirstOccurrence = false;
        int errorPosition = -1;
        for(int i = 1; i < sequence.length; i++)
        {
            if(sequence[i-1] >= sequence[i]){
                if(foundFirstOccurrence) return false;
                foundFirstOccurrence = true;
                errorPosition = i;
            }
        }

        return !foundFirstOccurrence ||
                errorPosition == 1 ||
                errorPosition == sequence.length-1 ||
                sequence[errorPosition -1] < sequence[errorPosition +1] ||
                sequence[errorPosition -2] < sequence[errorPosition];
    }
}
