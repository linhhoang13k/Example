/* Given a pattern string and a test string, your task is to implement regex substring matching. If pattern is preceded by a ^, the pattern, excluding the ^, will be matched with the starting position of the test string. If pattern is followed by a $, the pattern, excluding the $, will be matched with the ending position of the test string. If no such markers are present, check whether pattern is a substring of test, regardless of its position.
*/

boolean regexMatching(String pattern, String test) {
    if (pattern == null || pattern.length() ==0) return true;
    
    // Special processing for start and end symbols
    boolean start = (pattern.charAt(0) == '^');
    if (start) pattern = pattern.substring(1);
    boolean end = (pattern.charAt(pattern.length()-1) == '$');
    if (end) pattern = pattern.substring(0, pattern.length()-1);
    
    if (start || end) {
        return (!start || test.startsWith(pattern)) &&
            (!end || test.endsWith(pattern));
    }
    
    return textHasPattern(pattern, test);
}

boolean textHasPattern(String pattern, String text){
    int plen = pattern.length();
    int tlen = text.length();
    if (plen > tlen) return false;
    
    // Calculate hash value for pattern
    int hash = 0;
    for (char c: pattern.toCharArray()){
        hash += c;
    }
    
    // Calculate hash value for text start
    int thash = 0;
    for (int i=0; i<plen; i++){
        thash += text.charAt(i);
    }
    // Equal strings must have equal hashes (but not visa versa)
    
    // Compare strings only when hashes are equal
    if (thash == hash && pattern.equals(text.substring(0, plen)))
            return true;
    
    // Slide the text window, recalculate text hash, 
    // if hashes are equal, compare strings
    for (int i=plen+1; i < tlen+1; i++){
        thash -= text.charAt(i-plen-1);
        thash += text.charAt(i-1);
        if (thash == hash && 
            pattern.equals(text.substring(i-plen, i)))
            return true;
    }
    return false;
}