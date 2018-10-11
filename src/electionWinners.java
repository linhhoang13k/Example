package Intro.eruption_of_light;


public class electionWinners {

    int electionsWinners(int[] votes, int k) {
        int[] n = new int[votes.length];
        int max = n[0];
        for (int i = 0; i < votes.length; i++) {
            if (votes[i] + k > max) {
                return votes[i + 1];
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] votes = {2, 3, 5, 2};
        System.out.println(new electionWinners().electionsWinners(votes, 2));
    }

}
