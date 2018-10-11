// https://codefights.com/challenge/7T3uBRMPPCcTG3r7D/solutions/XRJnipJc9kzFsCASc
int reverseHexadecimal(String r) {
    String a[] = {"F", "E", "D", "C", "B", "A", "9", "8", "7", "6", "5", "4", "3", "2", "1", "0"};
    String b[] = r.split("");
    String c = "";
    for(int i = 0; i < b.length; i++) {
        for(int j = 0, k = 15; j < 16; j++) {
            if(b[i].contains(a[j])) {
                b[i] = b[i].replaceAll(a[j], a[k]);
                break;
            }
            k--;
        }
        c += b[i];
    }
    return Integer.parseInt(c, 16);
}
