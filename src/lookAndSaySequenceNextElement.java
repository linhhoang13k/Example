String lookAndSaySequenceNextElement(String element) {
    int count = 1;
    String res = "";
    char currentEle = element.charAt(0);
    for(int i = 1; i < element.length(); i++) {
        if(element.charAt(i)==(element.charAt(i - 1))) 
            count++;
        else {
            res += Integer.toString(count) + currentEle;
            count = 1;
            currentEle = element.charAt(i);
        }
    }
    res += Integer.toString(count) + currentEle;
    return res;
}
