// https://codefights.com/challenge/v3D3PzpaJnyXuySsw/solutions/p3PcM37vuBhvdPGZY
boolean EasyNum(int n) {
    List<Integer> a = new ArrayList<Integer>();
    for(int i = n; i > 0;) {
        a.add(i % 10);
        i /= 10;
    }
	double b = Math.pow(a.get(2),a.get(1));
    b /= a.get(0);
    if(b % a.get(2) == 0) {
        return true;
    }
    return false;
}
