int sumUpDigits(String inputString) {

  int answer = 0;

  for (int i = 0; i < inputString.length(); i++) {
    if (inputString.charAt(i) >='0'&&inputString.charAt(i)<='9'  ) {
      answer += inputString.charAt(i) - '0';
    }
  }

  return answer;
}
