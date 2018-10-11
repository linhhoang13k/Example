// https://codefights.com/challenge/SzWYtTbm2qGtgwhXX/solutions/bWuhNJ4a7rKiQNYhr
int notPaired(int[] n) {
  for(int i = 0; i < n.length; i++) {
    int a = 0;
    for(int j = 0; j < n.length; j++) {
      if(n[i] == n[j])
        a++;
    }
    if(a < 2)
      return n[i];
  }
  return 1;
}
