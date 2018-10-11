int[] videoPart(String part, String total) {
    String [] partArr = part.split(":"), totalArr = total.split(":");
    int p = Integer.parseInt(partArr[0]) * 3600 + Integer.parseInt(partArr[1]) * 60 + Integer.parseInt(partArr[2]), t = Integer.parseInt(totalArr[0]) * 3600 + Integer.parseInt(totalArr[1]) * 60 + Integer.parseInt(totalArr[2]), g = gcd(p, t);
    return new int[] {p/g, t/g};
}
    
int gcd(int a, int b) {
    return b == 0?a:gcd(b, a % b);
}
