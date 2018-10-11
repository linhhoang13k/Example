boolean checkPalindrome(String inputString) {
        
    String reverse = new StringBuffer(inputString).reverse().toString();
    if (inputString.equals(reverse)) {
        return true;
    }
    else {
        return false;
    }

}
