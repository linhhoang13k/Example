/*
Note: Write a solution that only iterates over the string once and uses O(1) additional memory, since this is what you would be asked to do during a real interview.

Given a string s, find and return the first instance of a non-repeating character in it. If there is no such character, return '_'.
*/
char firstNotRepeatingCharacter(String s) {
    int[] alph = new int[26];
    for(int i = 0; i < s.length(); i++) alph[s.charAt(i)-'a']++;
    for(int j = 0; j < s.length(); j++){
        if(alph[s.charAt(j)-'a'] == 1) return s.charAt(j);
    }
    return '_';
}
