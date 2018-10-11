int[] lazyFriends(int[] a, int d) {
    int len = a.length;
    int[] res = new int[len];
    for(int i = 0; i < len; i++) {
        for(int j = i + 1; j < len; j++) {
            if(a[j] - a[i] <= d) {
                res[j]++;
                res[i]++;
            }
        }
    }
    return res;
}

Another Solution :

int[] lazyFriends(int[] a, int d) {
    ArrayList<Integer> res = new ArrayList();
   for (int i = 0; i < a.length ; i++) {
        int c = 0;
        for (int j = 0; j < a.length ; j++)
            if (d >= Math.abs(a[i]-a[j])) c++;
        res.add(c-1);            
    }
    return res.stream().mapToInt(i->i).toArray();
}

https://codefights.com/tournaments/68pugCBf725fqevPi/C
