boolean checkPalindrome(String inputString) {

    return inputString.equals(new StringBuffer(inputString).reverse().toString());
}
