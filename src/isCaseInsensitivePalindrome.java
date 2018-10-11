boolean isCaseInsensitivePalindrome(String inputString) {
    
  String a = inputString.toLowerCase();
    for (int i = 0; i < a.length(); i++) {
        if (a.charAt(i) != a.charAt(a.length() - i - 1))
            return false;
    }
    return true;
}
