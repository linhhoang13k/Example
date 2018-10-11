class CountVowelConsonant {
    int countVowelConsonant(String s) {
        int sum = 0;
        for (char c : s.toCharArray()) {
            switch (c) {
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
                sum += 1;
                break;
            default:
                sum += 2;
                break;
            }
        }
        return sum;
    }
}