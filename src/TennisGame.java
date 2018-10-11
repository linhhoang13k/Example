package exercise14;

public class TennisGame {
    public boolean tennisSet(int score1, int score2) {
        int winningScoreMinBelow5 = 6;
        int winningScoreMinAtOrAbove5 = 7;
        int max = Math.max(score1, score2);
        int min = Math.min(score1, score2);
        boolean tie = score1 == score2;
        boolean matchRule = (min < 5) ? max == winningScoreMinBelow5 : max == winningScoreMinAtOrAbove5;
        return !tie && matchRule;
    }
}
