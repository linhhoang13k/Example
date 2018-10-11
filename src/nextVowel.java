char nextVowel(char e) {
    char[] v = {'A', 'E', 'I', 'O', 'U'};
    for(int i = 1 ; i < v.length ;i++)
        if(v[i-1] == e) return v[i];
    return 'A';
}
/*
Given a single character, an English vowel; find the next vowel. Vowels are listed from alphabetical order: 'A', 'E', 'I', 'O', 'U'.

Example
For vowel = 'A', the output should be
nextVowel(vowel) = 'E'.
*/
