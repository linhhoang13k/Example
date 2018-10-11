class CountPairsWithDifference {
    int countPairsWithDifference(int k, int[] a) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int ai : a) {
            if (map.containsKey(ai)) {
                map.put(ai, map.get(ai) + 1);
            } else {
                map.put(ai, 1);
            }
        }
        long ans = 0;
        for (int ai : a) {
            if (map.containsKey(k + ai)) {
                ans += map.get(k + ai);
            }
        }
        return (int) (ans %= 1000000007);
    }
}