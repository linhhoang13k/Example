// https://codefights.com/challenge/rkciNfqSP3k6bfA4v/solutions/CJZR64RYbiXQ5Fovj
String Caesar(String t, int s) {
    String b = "";
    int c = 0;
    for(int i = 0; i < t.length(); i++) {
        c = Character.getNumericValue(t.charAt(i));
        if(c > 9) 
            b += (char)((c + s - 10) % 26 + 65);
        else 
            b += t.charAt(i);
    }
    return b;
}
