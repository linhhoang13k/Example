package Arcade_Intro;

import java.util.Arrays;

public class _46_electionsWinners {
    int electionsWinners(int[] votes, int k) {
        int max =  Arrays.stream(votes).max().getAsInt();

        if(k == 0){ //No one left to vote --> check standings
            int numberOfEquals = 0;
            for(int elem : votes) if (elem == max) numberOfEquals++;
            return numberOfEquals > 1 ? 0 : 1;
        }

        // Check who might win
        int numberOfPossibleWinners = 0;
        for(int elem : votes) if (elem + k > max) numberOfPossibleWinners++;
        return numberOfPossibleWinners;
    }

    int electionsWinnersTwoLiner(int[] votes, int k) {
        int max =  Arrays.stream(votes).max().getAsInt();
        return k == 0 ? (Arrays.stream(votes).filter(x -> x == max).count() == 1 ? 1 : 0)
                        : (int)Arrays.stream(votes).filter(x->x+k > max).count();
    }
}
