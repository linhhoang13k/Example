int piecesOfDistinctLengths(int strawLength) {
    int i = 0, cnt = 0;
    while (i + cnt < strawLength)
        i += ++cnt;
    return cnt;
}
