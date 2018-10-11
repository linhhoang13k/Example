// https://codefights.com/challenge/ZYcY8u59FAog4F5fk/solutions/Twe57SrmC2o2ys2k4
boolean swapSequence(String a, String b) {
    int c = 0;
    StringBuilder d = new StringBuilder(b);
    for(int i = 0; i < a.length(); i++) {
        if(d.toString().contains("" + a.charAt(i))) {
            for(int j = 0; j < d.length(); j++) {
                if(d.charAt(j) == a.charAt(i)) {
                    d.deleteCharAt(j);
                    break;
                }
            }
            c++;
        }
    }
    if(c == a.length())
        return true;
    return false;
}
