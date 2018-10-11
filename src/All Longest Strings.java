String[] allLongestStrings(String[] inputArray) {
    int maxLength = 0;
    int count = 0;

    for (int i = 0; i < inputArray.length; i++) {
        if (maxLength < inputArray[i].length()) {
            maxLength = inputArray[i].length();
        }
    }

    for (int i = 0; i < inputArray.length; i++) {
        if(maxLength == inputArray[i].length())count++;
    }

    String[]maxLengthArr = new String[count];
    int n = 0;

    for (int i = 0; i < inputArray.length; i++) {
        if(maxLength == inputArray[i].length()){
            maxLengthArr[n] = inputArray[i];
            n++;
        }
    }

    return maxLengthArr;
}