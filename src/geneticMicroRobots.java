// https://codefights.com/challenge/uvH5mv6iMwm7mwKJs/solutions/esYLSn8xuXkdqMKqD
String[] geneticMicroRobots(int n, String[] s) {
    String[] a = new String[n];
    for(int i = 0; i < n; i++) {
        String b = "";
        String c = "";
        for(int j = 0; j < s[i].length(); j++) {
            if(s[i].charAt(j) == 'A') {
                b += "T";
            }
            if(s[i].charAt(j) == 'T') {
                b += "A";
            }
            if(s[i].charAt(j) == 'C') {
                b += "G";
            }
            if(s[i].charAt(j) == 'G') {
                b += "C";
            }
        }
        for(int k = b.length() - 1; k > -1; k--) {
            c += b.charAt(k);
         }
        a[i] = c;
    }
    return a;
}
