char firstNotRepeatingCharacter1(String s) {
        int [] array = new int [26];
        for (char c : s.toCharArray()) {
            array[c - 'a'] += 1;
        }
        for (char c : s.toCharArray()) {
            if (array[c - 'a'] == 1) {
                return c;
            }
        }
        return '_';
    }

char firstNotRepeatingCharacter2(String s) {
    // LinkedHashMap will maintain the order in which keys were inserted
    Map<Character, Boolean> map = new LinkedHashMap<>();
    for (char c : s.toCharArray()) {
        if (!map.containsKey(c)) {
            map.put(c, true);
        } else {
            map.put(c, false);
        }
    }
    for (char c : map.keySet()) {
        if (map.get(c)) {
            return c;
        }
    }
    return '_';
}

char firstNotRepeatingCharacter3(String s) {
    for (char c : s.toCharArray()) {
        // last index 如果跟 first index 相等，说明就出现了一次（不可能出现0次）
        if (s.lastIndexOf(c) == s.indexOf(c)) {
            return c;
        }
    }
    return '_';
}
