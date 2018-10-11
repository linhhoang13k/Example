boolean checkBlanagrams(String word1, String word2) {
    int[] map = new int [26];
    
    for(int i=0; i < word1.length(); i++){
        map[word1.charAt(i)-'a']++;
        map[word2.charAt(i)-'a']--;
    }
    
    int avg = 0;
    for(int i = 0 ; i < 26 ; i++) avg += Math.abs(map[i]); 
    return avg == 2;
}

/*
For word1 = "tangram" and word2 = "anagram", the output should be
checkBlanagrams(word1, word2) = true.
For word1 = "tangram" and word2 = "pangram", the output should be
checkBlanagrams(word1, word2) = true.
*/
