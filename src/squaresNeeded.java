long squaresNeeded(long squares, long circles, double percentage) {
    return (long)((percentage / (100 - percentage)) * circles) - squares;
}
