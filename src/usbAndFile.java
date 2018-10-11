// https://codefights.com/challenge/hMCmr72eyrJBNEdp9/solutions/Ldiaq8NfgYTsDX4GM
int a;
int z;
int usbAndFile(int s, int[] u) {
    List<Integer> r = new ArrayList<Integer>();
    for(int i = 0; i < u.length; i++) {
        r.add(u[i]);
    }
    Collections.sort(r);
    Collections.reverse(r);
    for(int i = 0; i < r.size(); i++) {
        if(s > z) {
            z += r.get(i);
            a++;
        }
    }
    return a;
}
