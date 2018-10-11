// https://codefights.com/challenge/qQ762Pzrgm5KaBMT6/solutions/J6jSvBQvHP4WrwybJ
int secondLargest(int n) {
    ArrayList<Integer> a = new ArrayList<Integer>();
    int z = 1;
    a.add(n);
    while(n != 1) {
        if(n % 2 == 0)
            n /= 2;
        else
            n = 3 * n + 1;
        a.add(n);
    }
    Collections.sort(a);
    if(a.size() > 1)
        z++;
    return a.get(a.size() - z);
}
