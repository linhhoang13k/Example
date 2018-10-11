package arcadeintro.eruptionoflight;

import java.util.Arrays;

/*
For votes = [2, 3, 5, 2] and k = 3, the output should be
electionsWinners(votes, k) = 2.
 */
public class ElectionsWinner {
    public static void main(String[] args) {

        int[] votes = {2, 3, 5, 2};
        int k = 3;
        System.out.println(electionsWinner(votes, k));

    }

    private static int electionsWinner(int[] votes, int k) {
        Arrays.sort(votes);
        int max = votes[votes.length - 1];
        int counter = 1;
        boolean possibleDraw = false;
        for (int i = 0; i < votes.length - 1; i++) {
            if (votes[i] + k > max) {
                counter++;
            } else if (votes[i] + k == max) {
                possibleDraw = true;
            }
        }
        return (counter == 1 && possibleDraw) ? 0 : counter;
    }
}
