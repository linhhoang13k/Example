boolean isSubstitutionCipher(String string1, String string2) {
    char[] x = new char[26];
    Arrays.fill(x , ' ');
    for(int i = 0 ; i < string1.length() ; i++){
        if(x[(string1.charAt(i) - 'a')] != ' ' 
           && x[(string1.charAt(i) - 'a')] != string2.charAt(i))
            return false;
        x[(string1.charAt(i) - 'a')] = string2.charAt(i);
    }
    int f = 0;
    for(int i = 0 ; i < x.length ; i++){
        if(x[i] == ' ')
            continue;
        for(int j = 0 ; j < x.length ; j++){
            if(x[i] == x[j] && i != j)
                return false;
        }
    }
    
    return true;
}
