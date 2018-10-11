class BallsRearranging {
    int ballsRearranging(int[] balls) {
        if (balls.length == 0 || balls.length == 1) {
            return 0;
        } else if (balls.length == 2) {
            if (Math.abs(balls[0] - balls[1]) == 1) {
                return 0;
            } else {
                return 1;
            }
        }
        Arrays.sort(balls);

        int l = 0;
        int r = balls.length - 1;
        int min = Integer.MAX_VALUE;
        int i = 0;

        boolean flip = true;

        for (int j = l; j < r; j++) {
            while (i <= r + 1 && balls[i] + r < balls[j]) {
                i++;
            }

            min = Math.min(min, r - (j - i));
        }

        return min;
    }
}