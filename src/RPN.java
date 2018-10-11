// https://codefights.com/challenge/qsRziH273jPy4p4ga/solutions/5Gf4Pc76Sac5Wmvxo
int RPN(String e) {
    String B = R(e);
    for(int i = 0; i < 99; i++) {
        B = R(B);
    }
    return Integer.parseInt(B.substring(0, B.length() - 1));
}

String R(String E) {
    String[] a = E.split(" ");
    String b = "";
    if(a.length < 3) {
        return E;
    }
    for(int i = 0; i < a.length; i++) {
        if(a[i].matches(".*\\d+.*") && a[i + 1].matches(".*\\d+.*") && !(a[i + 2].matches(".*\\d+.*"))) {
            int y = Integer.parseInt(a[i]);
            int z = Integer.parseInt(a[i + 1]);
            if(a[i + 2].equals("+")) {
                b += String.valueOf(y + z) + " ";
            }
            if(a[i + 2].equals("-")) {
                b += String.valueOf(y - z) + " ";
            }
            if(a[i + 2].equals("*")) {
                b += String.valueOf(y * z) + " ";
            }
            if(a[i + 2].equals("/")) {
                b += String.valueOf(y / z) + " ";
            }
            if(a[i + 2].equals("%")) {
                b += String.valueOf(y % z) + " ";
            }
            if(a[i + 2].equals("^")) {
                b += String.valueOf((int) Math.pow(y, z)) + " ";
            }
            i += 2;
        }
        else {
            b += a[i] + " ";
        }
    }
    return b;
}
