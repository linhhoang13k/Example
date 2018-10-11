boolean isPangram(String sentence) {
  if (sentence.length() < 26) {
      return false;
    }
    for (char ch = 'A'; ch <= 'Z'; ch++) {
      if (sentence.indexOf(ch) < 0
          && sentence.indexOf((char) (ch + 32)) < 0) {
        return false;
      }
    }
    return true;
}
