boolean isTandemRepeat(String inputString) {
    String s1 = inputString.substring(0 , inputString.length()/2);
    String s2 = inputString.substring(inputString.length()/2);
    return s1.equals(s2);
}
