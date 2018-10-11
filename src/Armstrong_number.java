// https://codefights.com/challenge/xTKzSZgATcYXboMyj/solutions/NdjCfreFKHemFuLYb
boolean Armstrong_number(int N) {
    List<Integer> digits = new ArrayList<Integer>();
    for(int i = N; i > 0;) {
        digits.add(i % 10);
        i /= 10;
    }
    int length = String.valueOf(N).length();
    double sum = 0;
    for(int i = 0; i < length; i++) {
        sum += Math.pow(digits.get(i), length);
	}
    if (sum == N) {
        return true;
    }
    return false;
}
