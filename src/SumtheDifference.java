// https://codefights.com/challenge/uNQ7ePA5GM9XLEaba/solutions/oxoyPXjrE9MaLNLQt
int a;
int SumtheDifference(String e) {
  e = e.replaceAll("\\s+","");
  for(int i = 0; i < e.length(); i++) {
    int b = Character.getNumericValue(e.charAt(i));
    if(Character.isDigit(e.charAt(i)) && e.charAt(i) % 2 == 0) {
      if(i != 0 && e.charAt(i - 1) == '-') {
        b = -b;
      }
      a += b;
    }
    else if(Character.isDigit(e.charAt(i)) && e.charAt(i) % 2 != 0) {
      if(i != 0 && e.charAt(i - 1) == '-') {
        b = -b;
      }
      a -= b;
    }
  }
  return a;
}
