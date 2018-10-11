// https://codefights.com/challenge/wekLCp4wLKnfWpeut/solutions/Lbi9AthRieeHmRgkt
int s = 1;
int a_bit_bit_cnt(int n) {
    if(n == 1)
        return 1;
    String a = Integer.toBinaryString(n);
    int b = 0;
    for(int i = 0; i < a.length(); i++) {
        if(a.charAt(i) == '1')
            b++;
    }
    s += b + 1;
    if(!(b > 1))
        return s;
    return a_bit_bit_cnt(b);
}
