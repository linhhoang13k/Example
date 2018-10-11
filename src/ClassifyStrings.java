class ClassifyStrings {
    static boolean isBad = false;
    static boolean isGood = false;

    String classifyStrings(String s) {
        isBad = false;
        isGood = false;
        int vowels = 0;
        int cons = 0;
        if (isVowel(s.charAt(0))) {
            vowels++;
            DP(s, vowels, cons, 1, '\0', false);
        } else if (!isWildcard(s.charAt(0))) {
            cons++;
            DP(s, vowels, cons, 1, '\0', false);
        } else {
            DP(s, vowels + 1, cons, 1, '\0', false);
            DP(s, vowels, cons + 1, 1, '\0', false);
        }
        if (isBad) {
            if (isGood) {
                return "mixed";
            } else {
                return "bad";
            }
        } else {
            return "good";
        }
    }

    void DP(String s, int vowels, int cons, int i, char last, boolean badFound) {
        if (vowels > 2 || cons > 4) {
            isBad = true;
            if (!badFound) {
                badFound = true;
            }
        }
        if (i == s.length() && vowels < 3 && cons < 5) {
            if (!badFound) {
                isGood = true;
            }
        }
        if (i == s.length()) {
            return;
        }
        if (isVowel(s.charAt(i))) {
            if (last == 'c') {
                vowels = 0;
                cons = 0;
            }
            DP(s, vowels + 1, cons, i + 1, 'v', badFound);
        } else if (isWildcard(s.charAt(i))) {
            DP(s, vowels + 1, cons, i + 1, 'v', badFound);
            DP(s, vowels, cons + 1, i + 1, 'c', badFound);
        } else {
            if (last == 'v') {
                vowels = 0;
                cons = 0;
            }
            DP(s, vowels, cons + 1, i + 1, 'c', badFound);
        }
    }

    boolean isVowel(char c) {
        switch (c) {
        case 'a':
        case 'e':
        case 'i':
        case 'o':
        case 'u':
            return true;
        default:
            return false;
        }
    }

    boolean isWildcard(char c) {
        return c == '?';
    }
}