class MaxPairProduct {
    int maxPairProduct(int[] a) {
        int ans = Integer.MIN_VALUE;
        int max = Integer.MIN_VALUE;
        HashSet<Integer> set = new HashSet<>();
        for (int ai : a) {
            if (ai > max) {
                max = ai;
            }
            set.add(ai);
        }
        double m = Math.sqrt(max);
        Arrays.sort(a);
        HashSet<Integer> dups = new HashSet<>();
        for (int i = 0; i < a.length && a[i] <= m; i++) {
            for (int j = i + 1; j < a.length && !dups.contains(a[j]); j++) {
                if (a[i] == a[j]) {
                    dups.add(a[j]);
                }
                int mult = a[i] * a[j];
                if (set.contains(mult)) {
                    if (ans < mult) {
                        ans = mult;
                    }
                }
            }
        }
        if (ans == Integer.MIN_VALUE) {
            return -1;
        }
        return ans;
    }
}