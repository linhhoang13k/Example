class RepetitionEncryption {
    int repetitionEncryption(String letter) {
        Pattern pattern = Pattern.compile("(?i)[^a-z]?([a-z]+)[^a-z]+\\1\\b");
        Matcher matcher = pattern.matcher(letter);

        int res = 0;
        while (matcher.find()) {
            res++;
        }
        return res;
    }
}