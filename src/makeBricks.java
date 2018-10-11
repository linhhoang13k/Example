// https://codefights.com/challenge/tDtMqypcKkyZCoZSb/solutions/waDdnTBoH6sSagZko
boolean makeBricks(int small, int big, int goal) {
    return goal % 5 <= small && goal - big * 5 <= small;
}
