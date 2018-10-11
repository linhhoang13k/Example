// https://codefights.com/challenge/3eZwiyP6btWXDxohS/solutions/BFhmhAzjAWYRcPv3u
List<Integer> NarcissisticNumber(int s, int f) {
    List<Integer> r = new ArrayList<Integer>();
    for(int i = s; i <= f; i++) {
        int z = i;
        int t = 0;
        while(z > 0) {
            t += Math.pow(z % 10, String.valueOf(i).length());
            z /= 10;
        }
        if(t == i)
            r.add(i);
    }
    return r;
}
