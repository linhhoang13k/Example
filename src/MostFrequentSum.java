class MostFrequentSum {
    //
    // Definition for binary tree:
    // class Tree<T> {
    //   Tree(T x) {
    //     value = x;
    //   }
    //   T value;
    //   Tree<T> left;
    //   Tree<T> right;
    // }
    static HashMap<Integer, Integer> map;

    int[] mostFrequentSum(Tree<Integer> t) {
        map = new HashMap<>();
        getSum(t);
        int max = 0;
        ArrayList<Integer> list = new ArrayList<>();
        for (int k : map.keySet()) {
            int v = map.get(k);
            if (v > max) {
                max = v;
                list.clear();
                list.add(k);
            } else if (v == max) {
                list.add(k);
            }
        }
        Collections.sort(list);
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    int getSum(Tree<Integer> t) {
        if (t == null) {
            return 0;
        }
        int sum = t.value;
        sum += getSum(t.left);
        sum += getSum(t.right);
        if (map.containsKey(sum)) {
            map.put(sum, map.get(sum) + 1);
        } else {
            map.put(sum, 1);
        }
        return sum;
    }
}
