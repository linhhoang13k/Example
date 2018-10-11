boolean composeKPalindromes(String s, int k) {
    if(k >s.length()) return false;    
    
    int[] map = new int[26];
    
    for(int i=0; i<s.length(); i++){
        map[s.charAt(i) - 'a']++;
    }
    
    int count = 0;
    for(int i = 0; i < map.length; i++){
        if( map[i] % 2 == 1 ) ++count;
    }
    return count <= k;
}

/*
Given a string s and an integer k, can you compose exactly k non-empty palindromes using each letter of s exactly once?

For s = "abracadabra" and k = 3, the output should be
composeKPalindromes(s, k) = true.

The answer is true since you are able to compose 3 palindromes using each letter of "abracadabra" once. 
3 possible palindromes that fulfill this requirement are: "araaara", "bcb", and "d".

For s = "abracadabra" and k = 2, the output should be
composeKPalindromes(s, k) = false.
*/
