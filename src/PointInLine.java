boolean pointInLine(int[] p, int[] l) {
//A * x + B * y + C = 0
    return p[0]*l[0]+p[1]*l[1]+l[2]==0;
}
