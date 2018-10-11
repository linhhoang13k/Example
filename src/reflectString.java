String reflectString(String inputString) {
    String x = "";
    for(int i = 0 ; i < inputString.length() ; i++)
        x += (char)('z' - inputString.charAt(i) + 97);
    return x;
}
