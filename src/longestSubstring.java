int longestSubstring(String s, int m) {
    int[] count = new int[128];
    int x = 0,v = 0 , l = s.length();
    if(l < 4) return v;
    for(int i = 0; i < l;i++){
        if(count[(int) s.charAt(i)]++==0) x++;
        if(x>m)      
            {
                if(--count[(int) s.charAt(v)]==0) x--;
                v++;
            }
    }
    return l-v;
}
/*
Given a string s and a positive integer m, find the length of longest substring of s having exactly m distinct characters.

The string is guaranteed to contain only lower case English letters.

Example
For s = "abcc" and m = 2, the output should be
longestSubstring(a, m) = 3.
*/
