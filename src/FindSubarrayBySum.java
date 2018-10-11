class FindSubarrayBySum {
    int[] findSubarrayBySum(int s, int[] arr) {
        int sum = 0;
        int l = 0;
        int r = 0;
        boolean found = false;
        for (int i = 0; i < arr.length; i++) {
            if (sum < s) {
                sum += arr[i];
                r = i;
            }
            while (sum > s) {
                sum -= arr[l];
                l++;
            }
            if (sum == s) {
                found = true;
                break;
            }
        }
        if (found) {
            return new int[] { l + 1, r + 1 };
        }
        return new int[] { -1 };
    }
}