String removeDuplicateCharacters(String str) {
    int[] map = new int[256];
    for (int i = 0 ; i < str.length() ;i++)
        map[str.charAt(i)]++;
    String result = "";
    for (int i = 0 ; i < str.length() ;i++)
        if (map[str.charAt(i)] == 1) 
            result +=(char)str.charAt(i);
    return result;       
}

/*
Remove all characters from a given string that appear more than once in it.

Example
For str = "zaabcbd", the output should be
removeDuplicateCharacters(str) = "zcd".
*/
