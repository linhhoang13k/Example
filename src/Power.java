int power(int base, int exponent) {
  int result = 1;
  for (int count = 0; count < exponent; count++) {
    result *=  base ;
  }
  return result;
}
