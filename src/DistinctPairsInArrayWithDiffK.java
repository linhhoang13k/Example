// Distinct Pairs in an Array with difference K
int distinctDiffPairsWithDiffK(int n[], int k) {
  int pairs=0;
  HashMap<Integer,Boolean> map = new HashMap<>();
  for (int i: n) {
    map.put(i,true);
  }
  for (int j=0;j<n.length;j++) {
    if (map.containsKey(n[j]+k) && map.get(n[j])) {
      pairs++;
      map.put(n[j],false);
    }
  }
  return pairs;
}
