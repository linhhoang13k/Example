int digitDistanceNumber(int n) {
  int result = 0;
  int lastDigit = n % 10;
  int tenPower = 1;
  n /= 10;
  while (n != 0) {
    result += tenPower * Math.abs(n % 10 - lastDigit);
    tenPower *= 10;
    lastDigit = n % 10;
    n /= 10;
  }

  return result;
}
