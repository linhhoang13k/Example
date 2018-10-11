// https://codefights.com/challenge/gBN2GChGLoRP9iLCB/solutions/sPPrTf7satb4Z5Fjd
String PalindromeOrNot(String s) {
    String a = new StringBuffer(s).
    reverse().toString();
    String b = "No";
    if(a.equals(s)) {
        b = "Yes";
    }
    return b;
}
