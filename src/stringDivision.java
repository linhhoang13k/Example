// https://codefights.com/challenge/ifSxNwEhkPER6hExe/solutions/PRj3v7zKJpDNwiDKQ
String stringDivision(String s) {
    String a = "";
    for(int i = 0; i < s.length(); i++)
        a += s.charAt(i) - 96;
    BigInteger z = new BigInteger(a);
    BigInteger t = new BigInteger("2");
    String b = String.valueOf(z.divide(t));
    String c = "";
    for(int i = 0; i < b.length(); i++)
        c += (char) ('a' + (int) b.charAt(i) - 48);
    return c;
}
