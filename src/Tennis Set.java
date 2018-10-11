boolean tennisSet(int score1, int score2) {
    return (Math.max(score1, score2) == 6 && Math.min(score1, score2) < 5) || (Math.max(score1, score2) == 7 && Math.min(score1, score2) < 7 && Math.min(score1, score2) >= 5);
}
