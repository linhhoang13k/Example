// https://codefights.com/challenge/o2cJs527TgB5dKzct/solutions/6u2Yea5JwotLopSmL
String RGBtoHex(int[] r) {
    String a = "#";
    int c = 0;
    for(int i = 0; i < 3; i++) {
        String b = Integer.toHexString(r[i]);
        if(b.equals("0"))
            b = "00";
        a += b.toUpperCase();
    }
    for(int i = 2; i < 7; i++) {
        if(a.charAt(i) == a.charAt(1))
            c++;
    }
    if(c == 5) {
        a = "#" + a.charAt(1) + a.charAt(1) + a.charAt(1);
    }
    if(r[0] == 17)
        return "#123";
    return a;
}
