class GroupsOfAnagrams {
    int groupsOfAnagrams(String[] words) {
        HashSet<String> set = new HashSet<>();

        for (int i = 0; i < words.length; i++) {
            set.add(calcInvariant(words[i]));
        }
        return set.size();
    }

    String calcInvariant(String w) {
        char[] wc = w.toCharArray();
        int[] count = new int[26];
        for (char c : wc) {
            count[(int) c - (int) 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if (count[i] > 0) {
                sb.append((char) (i + (int) 'a') + "" + count[i]);
            }
        }
        return sb.toString();
    }
}