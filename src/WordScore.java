// https://codefights.com/challenge/SN3MKKNQcqL2CqJjp/solutions/ykENuCbGMBTJawFrp
int a;
int WordScore(String w) {
    for(int i = 0; i < w.length(); i++) {
        a += (int) w.charAt(i) - 96;
    }
    return a;
}
