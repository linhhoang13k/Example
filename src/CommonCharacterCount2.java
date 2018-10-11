class CommonCharacterCount2 {
    int commonCharacterCount2(String[] s) {
        int[] common = new int[26];
        boolean first = true;
        for (String str : s) {
            int[] temp = new int[26];
            char[] cs = str.toCharArray();
            for (char c : cs) {
                temp[(int) c - (int) 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                if (first) {
                    common[i] = temp[i];
                } else {
                    common[i] = Math.min(common[i], temp[i]);
                }
            }
            first = false;
        }
        int ans = 0;
        for (int c : common) {
            ans += c;
        }
        return ans;
    }
}