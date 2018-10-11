boolean checkPalindrome(String inputString) {
  int n = inputString.length();
  for (int i = 0; i < (n/2); ++i) {
     if (inputString.charAt(i) != inputString.charAt(n - i - 1)) {
         return false;
     }
  }

  return true;
}
