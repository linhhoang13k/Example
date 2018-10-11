double bitsToFloat(int bits) {
  double intp = (double)((bits & 0xFFFF0000) >> 16);
  double frap = (double)(bits & 0xFFFF);
  while (frap >= 1.) {
    frap /= 10.;
  }
  return intp + frap;
}
