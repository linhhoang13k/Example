class HappyNumber {
    boolean happyNumber(int n) {
        for (int i = 0; i < 6; i++) {
            int sum = 0;
            while (n > 0) {
                sum += (n % 10) * (n % 10);
                n /= 10;
            }
            if (sum == 1) {
                return true;
            }
            n = sum;
        }
        return false;
    }
}