int largestDistance(int[] a) {

  int[] mx = new int[] {a[0], a[1]};
  int[] mn = new int[] {a[0], a[1]};
  for (int i = 0; i < a.length; i++) {
    int k = i / 2;
    if (a[i] > mx[k]) {
      mx[k] = a[i];
    } else if (a[i] < mn[k]) {
      mn[k] = a[i];
    }
  }
  return Math.max(mx[0] - mn[0], mx[1] - mn[1]);
}
