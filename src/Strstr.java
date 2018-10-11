class Strstr {
    int strstr(String s, String x) {
        int N = s.length();
        int M = x.length();

        int[] automata = buildAutomata(x);

        int i = 0;
        int j = 0;
        while (i < N) {
            if (x.charAt(j) == s.charAt(i)) {
                i++;
                j++;
            }
            if (j == M) {
                return i - j;
            } else if (i < N && x.charAt(j) != s.charAt(i)) {
                if (j != 0) {
                    j = automata[j - 1];
                } else {
                    i++;
                }
            }
        }
        return -1;
    }

    int[] buildAutomata(String pat) {
        int M = pat.length();
        int atmtaIdx = 0;
        int i = 1;
        int[] automata = new int[M];
        automata[0] = 0;
        while (i < M) {
            if (pat.charAt(i) == pat.charAt(atmtaIdx)) {
                atmtaIdx++;
                automata[i] = atmtaIdx;
                i++;
            } else {
                if (atmtaIdx != 0) {
                    atmtaIdx = automata[atmtaIdx - 1];
                } else {
                    automata[i] = 0;
                    i++;
                }
            }
        }
        return automata;
    }
}