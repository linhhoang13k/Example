class EquilibriumPoint {
    int equilibriumPoint(int[] arr) {
        if (arr.length == 1) {
            return 1;
        }
        int total = 0;
        int[] cumulative = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            total += arr[i];
            cumulative[i] = total;
        }
        for (int i = 0; i < arr.length; i++) {
            if (cumulative[i] - arr[i] == total - cumulative[i]) {
                return i + 1;
            }
        }

        return -1;
    }
}