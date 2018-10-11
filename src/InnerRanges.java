class InnerRanges {
    String[] innerRanges(int[] nums, int l, int r) {
        int prevl = l;
        boolean overflow = false;
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= l && nums[i] <= r) {
                String range = getRange(prevl, nums[i] - 1);
                if (nums[i] == Integer.MIN_VALUE) {
                    prevl = nums[i] + 1;
                    continue;
                }
                if (range.length() > 0) {
                    list.add(range);
                }
                if (nums[i] + 1 < nums[i]) {
                    overflow = true;
                    break;
                }
                prevl = nums[i] + 1;
            }
        }

        String range = getRange(prevl, r);

        if (range.length() > 0 && !overflow)
            list.add(range);
        return list.toArray(new String[0]);
    }

    String getRange(int l, int r) {
        if (l == r) {
            return "" + l;
        } else if (r < l) {
            return "";
        } else {
            return "" + l + "->" + r;
        }
    }
}