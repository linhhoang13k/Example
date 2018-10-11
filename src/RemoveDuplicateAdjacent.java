class RemoveDuplicateAdjacent {
    String removeDuplicateAdjacent(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if ((i == 0 || s.charAt(i) != s.charAt(i - 1)) && (i == s.length() - 1 || s.charAt(i) != s.charAt(i + 1))) {
                sb.append(s.charAt(i));
            }
        }
        if (sb.length() != s.length()) {
            return removeDuplicateAdjacent(sb.toString());
        }
        return sb.toString();
    }
}