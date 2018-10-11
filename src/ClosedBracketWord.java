// https://codefights.com/challenge/WAhmcLSBQcMPBN9HF/solutions/yx9fPXRDpoFhNPJef
boolean ClosedBracketWord(String word) {
    int b = word.length();
    int d = 0;
    int e = 0;
    ArrayList<Character> a = new ArrayList<Character>();
    for(char i = 'a'; i <= 'z'; i++) {
        a.add(i);
    }
    for(int i = 0; i < b; i++) {
        for(int j = 0; j < 26; j++) {
            if(a.get(j) == word.charAt(i)) {
                d = j;
            }
        }
        if(word.charAt(b - i - 1) == a.get(26 - (d + 1))) {
            e++;
        }
    }
    if(e == b) {
        return true;
    }
    return false;
}
