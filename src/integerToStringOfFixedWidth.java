String integerToStringOfFixedWidth(int number, int width) {
    String y = "000000000000";
    String x = "" + number;
    if(x.length() > width)
        return x.substring(x.length() - width);
    if(x.length() == width)
        return x;
    return y.substring(0 , width - x.length()) + x;
}
