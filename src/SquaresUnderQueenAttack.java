class SquaresUnderQueenAttack {
    boolean[] squaresUnderQueenAttack(int n, int[][] queens, int[][] queries) {
        boolean[] ans = new boolean[queries.length];
        for (int i = 0; i < queries.length; i++) {
            for (int[] queen : queens) {
                if (!ans[i] && isAttacked(n, queen, queries[i])) {
                    ans[i] = true;
                    continue;
                }
            }
        }
        return ans;
    }

    boolean isAttacked(int n, int[] queen, int[] query) {
        if (query[0] == queen[0] || query[1] == queen[1]) {
            return true;
        } else if (Math.abs(query[0] - queen[0]) == Math.abs(query[1] - queen[1])) {
            return true;
        }
        return false;
    }
}