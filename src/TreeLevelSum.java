class TreeLevelSum {
    int treeLevelSum(String tree, int k) {
        int level = -1;
        int ans = 0;
        int num = 0;
        for (int i = 0; i < tree.length(); i++) {
            if (tree.charAt(i) == '(') {
                ans += num;
                num = 0;
                level++;
            } else if (tree.charAt(i) == ')') {
                ans += num;
                num = 0;
                level--;
            } else if (level == k) {
                num = num * 10 + Integer.parseInt("" + tree.charAt(i));
            }
        }
        return ans;
    }
}