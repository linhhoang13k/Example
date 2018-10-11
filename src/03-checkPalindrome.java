boolean checkPalindrome(String str) {
      return str.equals(new StringBuilder(str).reverse().toString());
}
