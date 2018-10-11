String[] unusualLexOrder(String[] words) {
    String a[] = new String[words.length];
    String b[] = new String[words.length];
    for(int i = 0; i < words.length; i++){
        a[i] = new StringBuilder(words[i]).reverse().toString();
    }
    Arrays.sort(a);
    for(int i = 0; i < words.length; i++){
        b[i] = new StringBuilder(a[i]).reverse().toString();
    }
    return b;
}

/*
The citizens of Codeland read each word from right to left, meaning that lexicographical comparison works differently in their language. 
Namely, string a is lexicographically smaller than string b if either: a is a suffix of b (in common sense, i.e. b ends 
with a substring equal to a); or their last k characters are the same but the (k + 1)th character from the right in string a is smaller 
than the same character in string b.
Given an array of words in Codeland language, sort them lexicographically according to Codeland's unique rules.
For words = ["nigeb", "ta", "eht", "gninnigeb"], the output should be
unusualLexOrder(words) = ["ta", "nigeb", "gninnigeb", "eht"].
In particular, "ta" < "nigeb" because 'a' < 'b' and "nigeb" < "gninnigeb" because the former word is a suffix of the latter.
*/
