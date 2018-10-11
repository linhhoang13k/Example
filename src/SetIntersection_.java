ArrayList<Integer> setIntersection(ArrayList<Integer> a, ArrayList<Integer> b) {

  Collections.sort(a);
  Collections.sort(b);
  ArrayList<Integer> c = new ArrayList<>();

  int pos_b = 0;
  for (int pos_a = 0; pos_a < a.size(); pos_a++) {
    while (pos_b < b.size() && b.get(pos_b) < a.get(pos_a)) {
      pos_b = pos_a+1;
    }
    if (pos_b == b.size()) {
      break;
    }
    if (a.get(pos_a).equals(b.get(pos_b))) {
      c.add(a.get(pos_a));
      pos_b++;
    }
  }

  return c;
}
