boolean alphabetSubsequence(String s) {
    char t = s.charAt(0);
    for(int i = 1 ; i < s.length() ; i++){
        if(s.charAt(i) <= t)
            return false;
        else
            t = s.charAt(i);
    }
    return true;
}
