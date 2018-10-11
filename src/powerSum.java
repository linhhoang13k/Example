// https://codefights.com/challenge/YgF9vgTWbt2LiEm9A/solutions/McPZogy6v6RHdrMq4
/*long a;
String powerSum(int p) {
    while(p > -1) {
        a += Math.pow(2, p);
        p--;
    }
    return "" + a;
}
*/
String powerSum(int p) {
    return (long) Math.pow(2, p + 1) - 1 + "";
}
