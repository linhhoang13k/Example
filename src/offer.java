// https://codefights.com/challenge/JRaHC4vd4RiMxQjWj/solutions/GGeF5pYvTeE95XoAM
int offer(int n, int[] p) {
    int a = 0;
    int b = 0;
    int d = p.length;
    List<Integer> c = new ArrayList<Integer>();
    for(int i = 0; i < d; i++) {
        c.add(p[i]);
    }
    Collections.sort(c, Collections.reverseOrder());
    for(int i = 0; i < d; i++) {
        if(b == 2) {
            i++;
            b = 0;
        }
        if((i == d) == false) {
            a += c.get(i);
        }
        b++;
    }
    return a;
}
