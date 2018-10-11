boolean checkPalindrome(String inputString) {
    int i = 0;
    int j = inputString.length() - 1;
    boolean isPrime = true;
    while(i < j) {
        if(inputString.charAt(i) != inputString.charAt(j)) {
            isPrime = false;
            break;
        }
        else {
            i++;
            j--;
        }
    }
    return isPrime;
}